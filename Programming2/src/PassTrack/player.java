package PassTrack;

import java.util.ArrayList;
import java.util.Scanner;


public class player {

	//Player Stat Variables
	private int assists, blocks, catches, drops, goals, completions, badThrows, ID, fouls;
	public static int currentID=0;
	
	static ArrayList<player> playerArray = new ArrayList<player>();

	//Info
	String name, positionBuffer;
	static Scanner r = new Scanner(System.in);

	//Constructor
	public player(int ID) {
		this.ID = ID;
		this.name = "";
		this.assists = 0;
		this.blocks = 0;
		this.catches = 0;
		this.drops = 0;
		this.goals = 0;
		this.completions = 0;
		this.badThrows = 0;
		this.positionBuffer = "";
		this.fouls = 0;
	}
	
	//Adding and Removing Stats
	
	
	//Assists
	public void addAssist() {
		this.assists++;
	}
	public void removeAssist() {
		this.assists--;
	}
	public int getAssists() {
		return this.assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	
	//Blocks
	public void addBlock() {
		this.blocks++;
	}
	public void removeBlock() {
		this.blocks--;
	}
	public int getBlocks() {
		return this.blocks;
	}
	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}
	
	//Catches
	public void addCatch() {
		this.catches++;
	}
	public void removeCatch() {
		this.catches--;
	}
	public int getCatches() {
		return this.catches;
	}
	public void setCatches(int catches) {
		this.catches = catches;
	}
	
	//Drops
	public void addDrop() {
		this.drops++;
	}
	public void removeDrop() {
		this.drops--;
	}
	public int getDrops() {
		return this.drops;
	}
	public void setDrops(int drops) {
		this.drops = drops;
	}
	
	//Goals
	public void addGoal() {
		this.goals++;
	}
	public void removeGoal() {
		this.goals--;
	}
	public int getGoals() {
		return this.goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	
	//Completions
	public void addCompletion() {
		this.completions++;
	}
	public void removeCompletion() {
		this.completions--;
	}
	public int getCompletions() {
		return this.completions;
	}
	public void setCompletions(int completions) {
		this.completions = completions;
	}
	
	//Bad Throws
	public void addBadThrow() {
		this.badThrows++;
	}
	public void removeBadThrow() {
		this.badThrows--;
	}
	public int getBadThrows() {
		return this.badThrows;
	}
	public void setBadThrows(int badThrows) {
		this.badThrows = badThrows ;
	}
	
	//Fouls (Strip, etc)
	public void addFouls() {
		this.fouls++;
	}
	public void removeFouls() {
		this.fouls--;
	}
	public int getfouls() {
		return this.fouls;
	}
	public void setfouls(int fouls) {
		this.fouls = fouls ;
	}
	
	
	
	
	//Name
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//ID
	public int getID() {
		return this.ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	
	
	//PositionBuffer - Stores the positions the player caught the disk 
	// Values of the position are stored, separated by a comma
	public String getPositionBuffer(){
		return this.positionBuffer;
	}
	public void setPositionBuffer(String buffer) {
		this.positionBuffer = buffer;
	}
	
	//Find rank points
	public double getRankPoint() {
		double rankPoint=0;
		rankPoint = (this.goals*2 + this.assists + this.blocks*2 //Points with bonuses
		+ this.completions + this.catches) // Normal one point 
		/ (this.badThrows*.5 + this.drops*.5 + 1) ; // Negative stats
		return rankPoint;
	}


}
