package PassTrack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class game {

	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static void writeFile(String file,String text) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(file);
		try {
			byte[] strToBytes = text.getBytes();
			outputStream.write(strToBytes);
			outputStream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	//Writes differences of game data to disk
	public static void saveGame() throws IOException {
		//Import array of memory and of write to disk
		int[][] currentData = currentDataToArray();
		writeArray(currentData);

	}

	//Write an array to disk
	public static void writeArray(int array[][]) throws IOException {
		
		try {
			FileOutputStream outputStream = new FileOutputStream("src/PassTrack/db.txt",true);		
			for(int outer=0; outer<array.length; outer++) {
				for(int inner=0; inner<array[0].length; inner++) {
					if(array[outer][inner]!=0) {
						String writeLine = (outer)+" "+loadDataToStat(inner)+" "+1;
						writeLine = "\n"+writeLine;
						byte[] strToBytes = writeLine.getBytes();
						outputStream.write(strToBytes);
					}
				}

			}
			outputStream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			
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
				//strArray[0].replaceAll("[^a-zA-Z0-9 ]", "");

				if(!"$".equals(strArray[0]) && !"".equals(strArray[0])) {
					int index = Integer.parseInt(strArray[0]);
					statArray[index][loadDataSort(strArray[1])] = (Integer.parseInt(strArray[2])
							+ statArray[index][loadDataSort(strArray[1])]);

				}

			}

			reader.close();
		} catch (IOException e) {
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
		else if(type.equals("bdthrows"))index=5;
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
