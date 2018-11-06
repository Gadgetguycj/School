package PassTrack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class game {

	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	//Takes a single line and writes it to a file
	public static boolean writeFile(String file, String item) {
		boolean pass=true;
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			bufferedWriter.write(item);
			bufferedWriter.close();

		} catch (IOException e) {
			pass=false;
			e.printStackTrace();
			System.out.println("Write Error");
		}
		return pass;

	}

	//Writes differences of game data to disk
	public static void saveGame() {
		//Import array of disk and of arraylist
		int[][] diskData = loadDataToArray("src/PassTrack/db.txt");
		System.out.println("\nDISKDATA");
		method.printTwoDimIntArray(diskData);

		System.out.println("\nCURRENT DATA");	

		int[][] currentData = currentDataToArray();
		method.printTwoDimIntArray(currentData);
		int[][] differences = new int[currentData.length][currentData[0].length];

		//Find differences between the two arrays
		for(int outer=0; outer<currentData[0].length; outer++) {
			for(int inner=0; inner<currentData[0].length; inner++) {
				differences[outer][inner] = (currentData[outer][inner] - diskData[outer][inner]);

			}

		}
		writeFile("src/PassTrack/db.txt",getDateTime());
		writeArray(differences);
		System.out.println("\nDIFFERENCES");
		method.printTwoDimIntArray(differences);

	}

	//Write an array to disk
	public static void writeArray(int array[][]) {
		for(int outer=0; outer<array.length; outer++) {
			for(int inner=0; inner<array[0].length; inner++) {
				String writeLine="";
				if(array[outer][inner]!=0) {
					writeLine = outer+" "+loadDataToStat(inner)+" "+array[outer][inner];
					writeFile("src/PassTrack/db.txt", writeLine);
				}
			}

		}
	}

	//Takes data in arraylist playerArray and transforms it into an array
	public static int[][] currentDataToArray() {
		int[][] data = new int[player.currentID][8];

		for(int p=0; p<player.currentID; p++) {
			data[p][1] = player.playerArray.get(p).getCompletions();
			data[p][2] = player.playerArray.get(p).getCatches();
			data[p][3] = player.playerArray.get(p).getGoals();
			data[p][4] = player.playerArray.get(p).getDrops();
			data[p][5] = player.playerArray.get(p).getBadThrows();
			data[p][6] = player.playerArray.get(p).getBlocks();
			data[p][7] = player.playerArray.get(p).getAssists();
		}
		return data;

	}

	public static void loadData(String file) {
		int[][] fileArray = loadDataToArray(file);
		for(player index: player.playerArray) {
			for(int i=0; i<fileArray[0].length; i++) {
				if(fileArray[index.getID()][i]!=0) {
					index.setCompletions(fileArray[index.getID()][1]);	
					index.setCatches(fileArray[index.getID()][2]);	
					index.setGoals(fileArray[index.getID()][3]);	
					index.setDrops(fileArray[index.getID()][4]);	
					index.setBadThrows(fileArray[index.getID()][5]);	
					index.setBlocks(fileArray[index.getID()][6]);	
					index.setAssists(fileArray[index.getID()][7]);	

				}
			}
		}
	}

	public static boolean isANumber(String test) {
		boolean answer=false;
		for(int i=0; i<999; i++) {
			if((test).equals(Integer.toString(i)))
				answer=true;
		}
		return answer;
	}

	public static int[][] loadDataToArray(String file) {
		int[][] statArray = new int[player.currentID][8];
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;

			//Stores a map of all found stats
			while ((line = bufferedReader.readLine()) != null) {
				
				String[] strArray = line.split(" ");
				strArray[0].replaceAll("[^a-zA-Z0-9 ]", "");

				if(!"$".equals(strArray[0]) && !"".equals(strArray[0])) {
					System.out.println("strArray: "+strArray[0]);
					int index = Integer.parseInt(strArray[0]);
					statArray[index][loadDataSort(strArray[1])] = (Integer.parseInt(strArray[2])
							+ statArray[index][loadDataSort(strArray[1])]);

				}

			}

			reader.close();

		} catch (IOException
				e) {
			e.printStackTrace();
		}
		return statArray;
	}

	//Determines position in array
	public static int loadDataSort(String type) {
		int index=0;
		if(type.equals("completions"))	index=1;
		else if(type.equals("catches"))	index=2;
		else if(type.equals("goals"))	index=3;
		else if(type.equals("drops"))	index=4;
		else if(type.equals("bdthrows"))	index=5;
		else if(type.equals("blocks"))	index=6;
		else if(type.equals("assists"))	index=7;
		return index;
	}

	//Determines type based on position in array
	public static String loadDataToStat(int index) {
		String type="NULL";
		if(index==1) type = "completions";
		if(index==2) type = "catches";
		if(index==3) type = "goals";
		if(index==4) type = "drops";
		if(index==5) type = "bdthrows";
		if(index==6) type = "blocks";
		if(index==7) type = "assists";
		return type;
	}
}
