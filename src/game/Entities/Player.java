package game.Entities;
import game.Equipement;
import game.Boards.ClassicalBoard;
import game.Cells.BuildingCell;
import game.Cells.StreetCell;
import game.Entities.Players.Healer;
import game.Entities.Players.Snooper;
import game.Board;
import game.Cell;
import game.Direction;
import game.Entity;
import game.Equipements.Weapon;

import java.util.*;

import game.Equipements.Items.MasterKey;
import game.Equipements.Weapons.Gun;

/** The Player class extends Entity class */
public abstract class Player extends Entity{

	/** The bag of the player */
    protected List<Equipement> bag;
	/** Equipement player have in hand */
	protected Equipement inHand;
	/** The expertise Level of the player */
	private int expertiseLevel;
	/** The max life points player can have */
    static final int MAX_LIFE_LEVEL = 5;


    /**
     * Builds a new player.
	 * 
	 * @param cell the cell of the player.
     */
    public Player(Cell cell, Board board){
        super(MAX_LIFE_LEVEL, cell, board,3);
        this.expertiseLevel = 0;
        this.bag = new ArrayList<Equipement>();
		this.inHand = new Gun();
    }

	/**
	 * Gets the expertise level of the player.
	 * @return the expertise level of the player.
	 */
	public int getExpertiseLevel() {
		return this.expertiseLevel;
	}

	/**
	 * Sets the expertise level of the player.
	 * @param expertiseLevel the expertise level of the player.
	 */
	public void setExpertiseLevel(int expertiseLevel) {
		this.expertiseLevel = expertiseLevel;
	}

	/**
	 * Gets the bag of the player.
	 * @return the bag of the player.
	 */
	public List<Equipement> getEquipments() {
		return this.bag;
	}

	/**
	 * Adds an equipment to the bag of the player.
	 * @param Equipement the equipment to add to the bag of the player.
	 */
    public void setEquipment(Equipement Equipement) {
		this.bag.add(Equipement);
	}

	/**
	 * Removes an equipment from the bag of the player.
	 * 
	 * @param Equipement the equipment to remove from the bag of the player.
	 */
	public void removeEquipement(Equipement Equipement) {
		if (this.bag.contains(Equipement)) {
			this.bag.remove(Equipement);
		}
	}

	/**
	 * Returns the equipment currently held by the player.
	 *
	 * @return the equipment in hand
	 */
	public Equipement getInHand() {
		return this.inHand;
	}

	/**
	 * Sets the specified equipment as the currently held equipment by the player.
	 * If the equipment is present in the player's bag, it is removed from the bag and set as the in-hand equipment.
	 *
	 * @param Equipement The equipment to be set as the in-hand equipment.
	 */
	public void setInHand(Equipement Equipement) {
		if(this.bag.contains(Equipement)){
			this.removeEquipement(Equipement);
			if (this.inHand != null) {
				this.bag.add(this.inHand);
			}
			this.inHand = Equipement;
		}
	}

	/**
	 * Get the maximum life level of the player.
	 * @return the maximum life level of the player.
	 */
    public int getMaxLifeLevel() {
		return MAX_LIFE_LEVEL;
	}

	/**
	 * Give all the action player can do.
	 */
	public void action(){
		while (this.getActionPoints()!= 0){
			Scanner in = new Scanner(System.in);
			System.out.println("What to do ? / Number of action's points : " + this.getActionPoints());
			String msg = "LOOK AROUND | RESUME | EQUIP | USE | MAKE NOISE | MOVE ";
			if(this instanceof Healer){
				msg += "| HEAL ";
			}
			if(this.getCell() instanceof BuildingCell){
				msg += "| SNOOP ";
			}
			if(!(this.inHand == null) && this.inHand.getCanOpenDoor() && (this.northLocked() || this.southLocked() || this.eastLocked() || this.westLocked())){
				msg += "| OPEN DOOR ";
			}
			if (!(this.inHand == null) && this.inHand.getIsWeapon() && this.zombieCanBeAttack().size() > 0 ){
				msg += "| ATTACK ";
			}
			System.out.println(msg);
			String action = in.nextLine();
        	switch (action) {
            	case "LOOK AROUND" :
					try{
                		this.lookAround();
					}
					catch (Exception e) {
						System.out.println(e);
					}
                	break;
				
				case "RESUME" :
					this.resume();
					break;
    
            	case "SNOOP" :
					if(this.getCell() instanceof BuildingCell){
                		try {
							this.snoopAction();
						} catch (Exception e) {
							System.out.println(e);
						}
					}
                	break;
    
            	case "EQUIP" :
                	this.equip();
                	break;
    
            	case "USE" :
					try {
						this.inHand.use(this);
						this.inHand = null;
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
                    
            	case "MAKE NOISE" :
                	this.getCell().setNoiseLevel(this.getCell().getNoiseLevel()+1);
					this.actionPoints -= 1;
                	break;
    
            	case "OPEN DOOR" :
					if(this.inHand.getCanOpenDoor() && (this.northLocked() || this.southLocked() || this.eastLocked() || this.westLocked())){
						this.openDoor();
						this.actionPoints -= 1;
					}
					break;
    
            	case "MOVE" :
					this.move();
					this.actionPoints -= 1;
					break;

				case "HEAL" :
					if(this instanceof Healer){
						int randumNum = (int)(Math.random() * this.board.getPlayers().size());
 						Player randPlayer = this.board.getPlayers().get(randumNum);
						if(randPlayer.getLifepoints() + 1 <= randPlayer.getMaxLifeLevel()){
							randPlayer.setLifepoints(randPlayer.getLifepoints() + 1);
						}
					}
					break;
    
            	case "ATTACK" :
					if(!(this.inHand == null) && this.inHand.getIsWeapon() && this.zombieCanBeAttack().size() > 0 ){
                		this.attackAction(this.zombieCanBeAttack(), this.zombieCanBeAttack());
						this.actionPoints -= 1;
					}
                	break;
            }
		}
		this.actionPoints = 3;
    }

	/**
	 * Returns a string representation of the surrounding cells of the player's current position on the board.
	 * The surrounding cells include the player's current cell and the adjacent cells in all directions.
	 * 
	 * @throws Exception if an error occurs during the process
	 */
	public void lookAround() throws Exception{
		List<Player> players = new ArrayList<Player>();
		Board board = new ClassicalBoard(this.board.getSize(), players);
		board.setCells(this.board.createFakeboard());
		int posx=this.cell.getCoord()[0];
		int posy=this.cell.getCoord()[1];
		for(int x=posx-1;x<posx+2;x++){
			for(int y=posy-1;y<posy+2;y++){
				if (x>=0 && x<board.getSize() && y>=0 && y<board.getSize()){
					board.setCell(x, y, this.board.getCell(x, y));
				}
			}
		}
		System.out.println(board.toString());
	}

	/**
	 * Give all the equipments player can equip.
	 */
	public void equip() {
		Scanner in = new Scanner(System.in);
		System.out.println("You are holding : " + this.inHand);
		System.out.print("swap with : ");
		int i = 1;
		for (Equipement equipement : this.getEquipments()) {
			System.out.printf(equipement.toString() + " (%d) | " , i);
			i++;
		}
		System.out.print("quit (Q) \n");
		String input = in.nextLine();
		if (!input.equals("Q")) {
			int choice = Integer.parseInt(input);
			System.out.println("You are equiping : " + this.getEquipments().get(choice-1).toString());
			this.setInHand(this.getEquipments().get(choice-1));
		}
		else {
			System.out.println("you do nothing");
		}
	}

	/**
	 * Give all the doors player can open.
	 */
	public void openDoor(){
		Scanner in = new Scanner(System.in);
		System.out.println("Where to open door?");
		String msgDirection = "";
		if (this.northLocked()) {
			msgDirection += "North (N) | ";
		}
		if (this.southLocked()) {
			msgDirection += "South (S) | ";
		}
		if (this.eastLocked()) {
			msgDirection += "East (E) | ";
		}
		if (this.westLocked()) {
			msgDirection += "West (W) | ";
		}
		System.out.println(msgDirection);
		String direction = in.nextLine();
		switch (direction) {
			case "N":
				if (this.northLocked()) {
					this.inHand = new MasterKey();
					((MasterKey)this.inHand).use(this,Direction.NORTH);
				}
				break;
			case "S":
				if (this.southLocked()) {
					this.inHand = new MasterKey();
					((MasterKey)this.inHand).use(this,Direction.SOUTH);
				}
				break;
			case "E":
				if (this.eastLocked()) {
					this.inHand = new MasterKey();
					((MasterKey)this.inHand).use(this,Direction.EAST);
				}
				break;
			case "W":
				if (this.westLocked()) {
					this.inHand = new MasterKey();
					((MasterKey)this.inHand).use(this,Direction.WEST);
				}
				break;
			default:
				System.out.println("Invalid direction");
				break;
		}
	}

	/**
	 * Check if the player can open north door.
	 * 
	 * @return true if the player can open north door, false otherwise.
	 */
	public boolean northLocked(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		if (x == 0) {
			return false;
		}
		return (cells[x][y].isLocked(Direction.NORTH)) && ((cells[x][y] instanceof BuildingCell) || ((cells[x][y] instanceof StreetCell) && cells[x-1][y] instanceof BuildingCell));
	}

	/**
	 * Check if the player can open south door.
	 * 
	 * @return true if the player can open south door, false otherwise.
	 */
	public boolean southLocked(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		if (x == board.getSize() - 1) {
			return false;
		}
		return (cells[x][y].isLocked(Direction.SOUTH)) && ((cells[x][y] instanceof BuildingCell) || ((cells[x][y] instanceof StreetCell) && cells[x+1][y] instanceof BuildingCell));
	}

	/**
	 * Check if the player can open east door.
	 * 
	 * @return true if the player can open east door, false otherwise.
	 */
	public boolean eastLocked(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		if (y == board.getSize() - 1) {
			return false;
		}
		return (cells[x][y].isLocked(Direction.EAST)) && ((cells[x][y] instanceof BuildingCell) || ((cells[x][y] instanceof StreetCell) && cells[x][y+1] instanceof BuildingCell));
	}

	/**
	 * Check if the player can open west door.
	 * 
	 * @return true if the player can open west door, false otherwise.
	 */
	public boolean westLocked(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		if (y == 0) {
			return false;
		}
		return (cells[x][y].isLocked(Direction.WEST)) && ((cells[x][y] instanceof BuildingCell) || ((cells[x][y] instanceof StreetCell) && cells[x][y-1] instanceof BuildingCell));
	}

	/**
	 * Give all the movements player can do.
	 */
	public void move(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		boolean canMoveNorth = (x > 0) && ((cells[x-1][y] instanceof StreetCell) || ((cells[x-1][y] instanceof BuildingCell) && !(cells[x-1][y].isLocked(Direction.SOUTH))));
		boolean canMoveSouth = (x < board.getSize() - 1) && ((cells[x+1][y] instanceof StreetCell) || ((cells[x+1][y] instanceof BuildingCell) && !(cells[x+1][y].isLocked(Direction.NORTH))));
		boolean canMoveEast = (y < board.getSize() - 1) && ((cells[x][y+1] instanceof StreetCell) || ((cells[x][y+1] instanceof BuildingCell) && !(cells[x][y+1].isLocked(Direction.WEST))));
		boolean canMoveWest = (y > 0) && ((cells[x][y-1] instanceof StreetCell) || ((cells[x][y-1] instanceof BuildingCell) && !(cells[x][y-1].isLocked(Direction.EAST))));
		Scanner in = new Scanner(System.in);
		System.out.println("Where to move?");
		String msgDirection = "";
		if (canMoveNorth) {
			msgDirection += "North (N) | ";
		}
		if (canMoveSouth) {
			msgDirection += "South (S) | ";
		}
		if (canMoveEast) {
			msgDirection += "East (E) | ";
		}
		if (canMoveWest) {
			msgDirection += "West (W) | ";
		}
		System.out.println(msgDirection.substring(0, msgDirection.length() - 3));
		String direction = in.nextLine();
		switch (direction) {
			case "N":
				if (canMoveNorth) {
					this.moveNorth();
				}
				break;
			case "S":
				if (canMoveSouth) {
					this.moveSouth();
				}
				break;
			case "E":
				if (canMoveEast) {
					this.moveEast();
				}
				break;
			case "W":
				if (canMoveWest) {
					this.moveWest();
				}
				break;
			default:
				System.out.println("Invalid direction");
				break;
		}
	}

	/**
	 * Move the player north.
	 */
	public void moveNorth() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		if (x > 0) {
			try{
				coord[x][y].removePlayer(this);
				coord[x-1][y].setPlayer(this);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}

	/**
	 * Move the player south.
	 */
	public void moveSouth() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		if (x < board.getSize() - 1) {
			try{
				coord[x][y].removePlayer(this);
				coord[x+1][y].setPlayer(this);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}

	/**
     * Move the player east.
     */
	public void moveEast() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		if (y < board.getSize() - 1) {
			try{
				coord[x][y].removePlayer(this);
				coord[x][y+1].setPlayer(this);

			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}

	/**
     * Move the player west.
     */
	public void moveWest() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		if (y > 0) {
			try{
				coord[x][y].removePlayer(this);
				coord[x][y-1].setPlayer(this);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}

	/**
	 * Run the attack action of the player.
	 * Give which zombie can be attacked by the player.
	 * 
	 * @param zombies the list of all the zombies on the board.
	 * @param zombiesSub the list of 4 zombies that can be attacked by the player.
	 */
	public void attackAction(List<Zombie> zombies, List<Zombie> zombiesSub){
		Scanner in = new Scanner(System.in);
		System.out.println("Which one to attack");
		String msg = "";
		int count = 0;
		int index = 0;
		while(count < zombiesSub.size() && count < 4){
			msg += zombiesSub.get(count).toString()  + " (" + (count+1) + ") | ";
			count++;
		}
		if(zombiesSub.size() >= 4 && !(zombiesSub.get(3).equals(zombies.get(zombies.size()-1)))){
			msg += "Next (5) | ";
		}
		if(!(this.zombieCanBeAttack().get(0).equals(zombiesSub.get(0)))){
			msg += "Previous (6) | ";
		}
		System.out.println(msg);
		String action = in.nextLine();
		switch (action) {
			case "1":
				index = this.board.getZombies().indexOf(zombiesSub.get(0));
				this.attack(this.board.getZombies().get(index));
				break;
			case "2":
				index = this.board.getZombies().indexOf(zombiesSub.get(1));
				this.attack(this.board.getZombies().get(index));
				break;
			case "3":
				index = this.board.getZombies().indexOf(zombiesSub.get(2));
				this.attack(this.board.getZombies().get(index));
				break;
			case "4":
				index = this.board.getZombies().indexOf(zombiesSub.get(3));
				this.attack(this.board.getZombies().get(index));
				break;
			case "5":
				if (zombiesSub.size() >= 4 && !(zombiesSub.get(3).equals(zombies.get(zombies.size()-1)))) {
					index = zombies.indexOf(zombiesSub.get(3));
					if(index+5 < zombies.size()){
						List<Zombie> zombies2 = zombies.subList(index+1, index+5);
						this.attackAction(zombies, zombies2);
					}
					else{
						List<Zombie> zombies2 = zombies.subList(index+1, zombies.size());
						this.attackAction(zombies, zombies2);
					}
				}
				break;	
			case "6":
				if (!(this.zombieCanBeAttack().get(0).equals(zombiesSub.get(0)))) {
					index = zombies.indexOf(zombiesSub.get(0));
					List<Zombie> zombies2 = this.zombieCanBeAttack().subList(index-4, index);
					this.attackAction(zombies, zombies2);
				}
				break;
			default:
				System.out.println("Invalid choice");
				break;
		}
	}

	/**
	 * Check if the player can attack a zombie.
	 * 
	 * @param zombie the zombie to be checked.
	 * @return true if the player can attack the zombie, false otherwise.
	 */
	public boolean canAttackZombie(Zombie zombie) {
		int distance = this.cell.calculateDistance(zombie.getCell());
		return ((distance <= ((Weapon)this.inHand).getRange()[1]) && (distance >= ((Weapon)this.inHand).getRange()[0]));
	}

	/**
	 * Get the zombies that can be attacked by the player.
	 * 
	 * @return the zombies that can be attacked by the player.
	 */
	public List<Zombie> zombieCanBeAttack(){
		List<Zombie> zombies = new ArrayList<Zombie>();
		for (Zombie zombie : this.board.getZombies()) {
			if(canAttackZombie(zombie)){
				zombies.add(zombie);
			}
		}
		return zombies;	
	}

	/**
	 * Attack a zombie.
	 * 
	 * @param zombie the zombie to be attacked.
	 */
	public void attack(Zombie zombie){
		((Weapon)this.inHand).use(this,zombie);
		if (zombie.getLifepoints() <= 0) {
			try {
				this.board.getZombies().remove(zombie);
				Cell cell = zombie.getCell();
				cell.removeZombie(zombie);
				this.expertiseLevel += 1; 
				if(this.expertiseLevel == 3 || this.expertiseLevel == 7 || this.expertiseLevel == 11){
					this.actionPoints += 1;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Give all the equipements player can loot.
	 * 
	 * @throws Exception if the player tries to loot an equipement from an empty cell.
	 */
	public void snoopAction() throws Exception{
		if (this.cell.getEquipements().size() == 0){
			System.out.println("No equipement to loot");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Which one to loot");
		String msg = "";
		for (int i = 0; i < this.cell.getEquipements().size(); i++) {
			msg += this.cell.getEquipements().get(i).toString() + " (" + (i+1) + ") | ";
		}
		System.out.println(msg);
		String action = in.nextLine();
		int index = Integer.parseInt(action);
		this.bag.add(this.cell.getEquipements().get(index));
		this.cell.removeEquipement(this.cell.getEquipements().get(index));
		if(this instanceof Snooper && ((Snooper)this).getFreeSnoop() == 1){
			((Snooper)this).setFreeSnoop(0);
		}
		else{
			this.actionPoints -= 1;
		}
	}

	/**
	 * Check if the player is dead.
	 */
	public boolean isDead(){
		if (this.getLifepoints() <= 0) {
			try {
				this.board.getPlayers().remove(this);
				Cell cell = this.cell;
				cell.removePlayer(this);
			} catch (Exception e) {
				System.out.println(e);
			}
			return true;
		}
		return false;
	}

	/**
     * Emulate a dice.
     * 
     * @return a random number between 1 and 6
     */
    public int dice(){
        return (int)(Math.random() * 6 + 1);
    }

	public void resume(){
		System.out.println("Players : ");
		for (Player player : this.board.getPlayers()){
			if(this.equals(player)){
				System.out.println(player.ToString() + '\n');
			}
			else{
				System.out.println(player.toString() + '\n');
			}
		}
		System.out.println("Zombies : ");
		for (Zombie zombie : this.getCell().getZombie()){
			System.out.println(zombie.toString() + '\n');
		}
	}

	public abstract String ToString();
}