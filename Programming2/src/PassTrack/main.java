/* Chase Lauer
 * Made: 4-29-2018
 * Last Edited 4-29-2018
 * Frisbee Throw Tracker
 */
package PassTrack;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class main {

	static Scanner r = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		boolean running=true;
		String input;

		//Teams
		String[] nyitTeam = 
			{"Vinny","Matt","David","Josh","Melinda"
			,"Christian","Nelly","Michael","Leroy"
			,"John","Jan","Chase","Darren","Jordan","Chris"
			,"Said","Beno","Alexis","Joel","Bjorn","Busta","Elan","Jim"
			,"Nick","Joshua","Other"};
		String[] MIT = 
			{
				"Optimus Prime", "The Green Lantern"	
			};
		

		method.addPlayers(nyitTeam);
		game.loadData("src/PassTrack/db.txt");
		
		//Main loop and menu
		while(running) {
			System.out.println("\nFrisbee Tracker 1.2");
			System.out.println("1. List Players");
			System.out.println("2. List Stats");
			System.out.println("3. Add Players");
			System.out.println("4. Add Team");
			System.out.println("5. Start Match");
			System.out.println("6. Save");
			System.out.println("7. Exit");
			input = r.nextLine();

			switch(input) {
			
			//List All Players
			case "1":
				method.listPlayers();
				break;
			
			//Sort Player Array / Print Stats
			case "2":
				player.playerArray.sort(Comparator.comparing(player::getRankPoint).reversed());
				method.listStats();
				break;
			
			//Add Players
			case "3":
				method.addPlayers();
				break;
			
			//Adding a Team
			case "4":
				String input2="";
				do {
					System.out.println("\tPlease Select a Team");
					System.out.println("\t1. MIT");
					System.out.println("\t2. Exit");
					input2 = r.nextLine();

					switch(input2) {
					case "1":
						method.addPlayers(MIT);
						input2="!";
						break;
					case "!":
					case "2":
						input2="!";
						break;

					default:
						System.out.println("\tOption not found, please try again/n");
						break;
					}

				} while(!"!".equals(input2));
				break;
			
			//Start a game
			case "5":
				method.startGame();
				break;
			
			//Exit
			case "6":
				game.saveGame();
				break;
			
			case "7":
				System.exit(0);
				break;
			//For Testing
			case "8":
				game.saveGame();
				break;
			default:
				System.out.println("Invalid Option ("+input+"), please try again");
				break;

			}

		}

	}



}
