package PassTrack;

import java.util.Scanner;

public class method {



	static Scanner r = new Scanner(System.in);

	//Settings
	static int maxNameLength=15;

	//Add New Player
	public static void addPlayers() {
		String input;
		System.out.println("Please enter the names of team members, enter ! to stop");

		do {
			input = r.nextLine();

			//Clean Input
			if(input.equals("!")) {			
			}	else if(wordNormalize(input).equals("")) {
				System.out.println("Invalid Name, please try again.");
			}	else if (input.length()>maxNameLength){
				System.out.println("Player's name must be less than "+maxNameLength+" characters");
			}	else if (!"!".equals(input)) {
				player.playerArray.add(new player(player.currentID));
				player.playerArray.get(player.currentID).setName(wordNormalize(input));
				player.currentID++;
			}

		} while(!"!".equals(input));

	}

	//Add New Player - from array
	public static void addPlayers(String[] name) {
		for(String index : name) {
			if(wordNormalize(index).equals("")) {
				System.out.println("Invalid Name, skipping...");
			}	else if (index.length()>maxNameLength){
				System.out.println("Player's name must be less than "+maxNameLength+" characters, skipping...");
			}	else	{
				player.playerArray.add(new player(player.currentID));
				player.playerArray.get(player.currentID).setName(wordNormalize(index));
				player.currentID++;
			}

		}

	}

	//List All Players
	public static void listPlayers() {
		int count=0;
		for(player index : player.playerArray) {
			count++;
			System.out.println("Player "+count+" "+capitalizeFirstLetter(index));

		}

	}

	//List All Players
	public static void listPlayers(String[] array) {
		for(String index : array)
			System.out.println("Player "+index);

	}

	//List Players and Stats
	public static void listStats() {
		int count=0;
		for(player index : player.playerArray) {
			count++;

			System.out.print("\nPlayer "+count+" "+capitalizeFirstLetter(index));

			//Space Generator						
			int spaces = maxNameLength-index.getName().length()+1;
			if(count>99)
				spaces-=2;	
			else if(count>9)
				spaces--;
			for(int x=spaces; x>=0; x--) {
				System.out.print(" ");

			}
			//Different Stats
			System.out.print("RankPT "+index.getRankPoint());
			System.out.print("	Completions "+index.getCompletions());
			System.out.print("	Catches "+index.getCatches());
			System.out.print("   Goals "+index.getGoals());
			System.out.print("    Drops "+index.getDrops());
			System.out.print("	   Bad Throw "+index.getBadThrows());
			System.out.print("	 Blocks "+index.getBadThrows());
			System.out.print("   Assists "+index.getAssists());
			System.out.print("   ID "+index.getID());

		}
		System.out.println("\n");

	}

	public static void printTwoDimIntArray(int[][] array) {

		//Reads left to right
		for(int x=0; x < array.length; x++) {
			for(int i=0; i < array[0].length; i++)
				System.out.print(array[x][i]+" ");
			System.out.println();
		}

	}

	//Capitalize and Return Value
	public static String capitalizeFirstLetter(player index) {
		String result = "Player Not Found";
		if(!"".equals(index.getName()))
			result = index.getName().substring(0,1).toUpperCase() + index.getName().substring(1).toLowerCase();
		return result; 

	}

	//Start Game
	public static void startGame() {
		String input="0";
		int play=0;
		System.out.println("New Game Started \nPlease enter the order of player throws: ");

		while(!"!".equals(input)) {
			String playEnd="";
			int passNumber=0;
			play++;
			System.out.println("Play #"+play);

			while(!"!".equals(input)) {			
				input = r.nextLine();

				//How did the play end?
				if("!".equals(input)) {
					System.out.println("How did the play end? (drop, goal, block, bad throw, other)");
					do {
						switch(r.nextLine()){
						case "drop":
							playEnd="drop";
							break;
						case "goal":
							playEnd="goal";
							break;
						case "block":
							boolean found=false;
							do {
								System.out.println("Who blocked the pass?");
								String input2 = r.nextLine().toLowerCase();				
								for(player index : player.playerArray) {
									if(input2.equals(index.getName())) {
										index.addBlock();
										found=true;
										break;
									}	
								}
								if(!found)
									System.out.println("Player not found, please try again");
							} while(!found);
							playEnd="block";
							break;
						case "bad throw":
							playEnd="bad throw";
							break;
						case "other":
							playEnd="other";
							break;

						default:
							System.out.println("Option not found, please try again\n");
						}
					}while(playEnd.equals(""));

					//Read in players
				}else{
					boolean found=false;
					for(player index : player.playerArray) {
						if(wordNormalize(input).equals(index.getName())) {
							passNumber++;
							found=true;
							index.setPositionBuffer(index.getPositionBuffer()+"-"+passNumber);
						}	
					}
					if(!found)
						System.out.println("Player not found, please try again");

				}

			}
			//Total Passes, How play ended
			playInterpreter(passNumber,playEnd);

		}

	}

	//Remove everything but letters / make lowercase
	public static String wordNormalize(String word) {
		return word.replaceAll("[^A-Za-z]+", "").toLowerCase();

	}

	public static String closeTo(String word) {
		return word.replaceAll("[^A-Za-z]+", "").toLowerCase();

	}
	
	//Reads position buffer and adds player statistics
	public static void playInterpreter(int passNumber, String playEnd) {
		for(player index : player.playerArray) {
			if(!"".equals(index.getPositionBuffer())) {

				//Split string up and place into integer array starting from 0
				String[] strArray = index.getPositionBuffer().split("-");
				int[] intArray = new int[strArray.length-1];
				for(int x=1; x<strArray.length; x++)
					intArray[x-1] = Integer.parseInt(strArray[x]);

				//Figures out statistics
				for(int x=0; x<intArray.length; x++) {

					//Add Catches
					if(intArray[x]<passNumber&&intArray[x]>1)
						index.addCatch();

					//Add Catches after lass pass
					if(intArray[x]==passNumber&&!"drop".equals(playEnd))
						index.addCatch();

					//Add Throws/Completions
					if(intArray[x]<passNumber&&intArray[x]>=1) 
						index.addCompletion();

					//Add Drops
					if(intArray[x]==passNumber&&playEnd.equals("drop"))
						index.addDrop();

					//Add Assists
					if(intArray[x]==passNumber-1&&playEnd.equals("goal"))
						index.addAssist();

					//Add Goals
					if(intArray[x]==passNumber&&playEnd.equals("goal")) {
						index.addGoal();
					}

					//Add Bad Throws
					if(intArray[x]==passNumber&&playEnd.equals("bad throw"))
						index.addBadThrow();

				}
				index.setPositionBuffer("");

			}

		}

	}

	//Find players
	public static String findPlayer(String playerName) {
		String sendBack="";
		boolean found=false;
		for(player index : player.playerArray) {
			if(playerName.equals(index.getName().toLowerCase())) {
				sendBack = index.getName();
				break;
			}

		}
		return sendBack;
	}


}
