package game.Entities;
import game.Equipement;
import game.Boards.ClassicalBoard;
import game.Cells.BuildingCell;
import game.Cells.StreetCell;
import game.Board;
import game.Cell;
import game.Direction;
import game.Entity;
import game.Equipements.Weapon;

import java.util.*;

import game.Equipements.Weapon;
import game.Equipements.Items.MasterKey;

public abstract class Player extends Entity{
    protected List<Equipement> bag;
	protected Equipement inhand;
    private int actionPoints;
	private int expertiseLevel;
    static final int MAX_LIFE_LEVEL = 5;


    /**
     * Builds a new player.
	 * 
	 * @param Lifepoints the lifepoints of the player.
	 * @param cell the cell of the player.
     */
    public Player(int Lifepoints, Cell cell, Board board){
        super(Lifepoints,cell, board,3);
        this.expertiseLevel = 0;
        this.bag = new ArrayList<Equipement>();
				this.inhand = null;
    }

	public void AttackAction(){
		Scanner in = new Scanner(System.in);
		System.out.println("Which one to attack");
		String msg = "";
		for (Zombie zombie : this.cell.getZombie()) {
			msg += zombie.toString()  + " (" + (this.board.getZombies().indexOf(zombie) + 1) + ") | ";
		}
		System.out.println(msg);
		String action = in.nextLine();
		switch (action) {
			case "0":
				this.attack(this.board.getZombies().get(0));
				break;
			case "1":
				this.attack(this.board.getZombies().get(1));
				break;
			case "2":
				this.attack(this.board.getZombies().get(2));
				break;
			case "3":
				this.attack(this.board.getZombies().get(3));
				break;
			case "4":
				this.attack(this.board.getZombies().get(4));
				break;
			default:
				System.out.println("Invalid choice");
				break;
		}
	}

	public boolean canAttackZombie(Zombie zombie){
		if(this.getInHand().getIsWeapon()){
				
	
		if(zombie.getCell().getcoord()[0]==this.getCell().getcoord()[0]){
			if(this.calculateDistance(this.getCell(),zombie.getCell())<((Weapon) this.getInHand()).getrange()[1]){
				return true;
			}



		}
		if(zombie.getCell().getcoord()[1]==this.getCell().getcoord()[1]){
			return true;
		}
	}
	return false;
	}

	public void attack(Zombie zombie){
		((Weapon)this.inhand).use(this,zombie);
		if (zombie.getLifepoints() <= 0) {
			try {
				this.board.getZombies().remove(zombie);
				this.cell.getZombie().remove(zombie);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		}


	/**
	 * Gets the action points of the player.
	 * @return the action points of the player.
	 */
    public int getActionPoints() {
		return this.actionPoints;
	}


	/**
	 * Returns the board associated with this player.
	 *
	 * @return the board associated with this player
	 */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * Returns a string representation of the surrounding cells of the player's current position on the board.
	 * The surrounding cells include the player's current cell and the adjacent cells in all directions.
	 * 
	 * @return a string representation of the surrounding cells
	 * @throws Exception if an error occurs during the process
	 */
	public void lookaround() throws Exception{
		List<Player> players = new ArrayList<Player>();
		Board board = new ClassicalBoard(this.board.getSize(), players);
		board.setCells(this.board.createfakeboard());
		int posx=this.cell.getcoord()[0];
		int posy=this.cell.getcoord()[1];
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
	 * Sets the board for the player.
	 * 
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	/**
	 * Sets the action points of the player.
	 * @param actionPoints the action points of the player.
	 */
	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
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
	 * Gets the life level of the player.
	 * @return the life level of the player.
	 */
    public int getLifeLevel() {
		return this.Lifepoints;
	}
   
	/**
	 * Sets the life level of the player.
	 * @param Lifepoints the life level of the player.
	 */
	public void setLifeLevel(int Lifepoints) {
		this.Lifepoints = Lifepoints;
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
	 * Sets the specified equipment as the currently held equipment by the player.
	 * If the equipment is present in the player's bag, it is removed from the bag and set as the in-hand equipment.
	 *
	 * @param equipment The equipment to be set as the in-hand equipment.
	 */
	public void setInHand(Equipement Equipement) {
		if(this.bag.contains(Equipement)){
			this.removeEquipement(Equipement);
			if (this.inhand != null) {
				this.bag.add(this.inhand);
			}
			this.inhand = Equipement;
		}
	}

	/**
	 * Returns the equipment currently held by the player.
	 *
	 * @return the equipment in hand
	 */
	public Equipement getInHand() {
		return this.inhand;
	}

	/**
	 * Get the maximum life level of the player.
	 * @return the maximum life level of the player.
	 */
    public int getMaxLifeLevel() {
		return MAX_LIFE_LEVEL;
	}

	public void action(){
		while (this.actionPoints != 0){
			Scanner in = new Scanner(System.in);
			System.out.println("What to do ? / Number of action's points : " + this.actionPoints);
			String msg = "LOOK AROUND | LOOT | EQUIP | USE | MAKE NOISE | MOVE ";
			if( this.inhand.getCanOpenDoor() && (this.northLocked() || this.southLocked() || this.eastLocked() || this.westLocked())){
				msg += "| OPEN DOOR ";
			}
			if (this.inhand.getIsWeapon() && this.cell.getZombie().size() > 0 ){
				msg += "| ATTACK ";
			}
			System.out.println(msg);
			String action = in.nextLine();
        	switch (action) {
            	case "LOOK AROUND" :
					try{
                		this.lookaround();
					}
					catch (Exception e) {
						System.out.println(e);
					}
                	break;
    
            	case "LOOT" :
                	System.out.println("Do loot");
                	break;
    
            	case "EQUIP" :
                	this.equip();
                	break;
    
            	case "USE" :
                	System.out.println("Do use");
                	break;
                    
            	case "MAKE NOISE" :
                	System.out.println("Do makeNoise");
                	break;
    
            	case "OPEN DOOR" :
					if(this.inhand.getCanOpenDoor() && (this.northLocked() || this.southLocked() || this.eastLocked() || this.westLocked())){
						this.openDoor();
						this.actionPoints -= 1;
					}
					break;
    
            	case "MOVE" :
					this.move();
					this.actionPoints -= 1;
					break;
    
            	case "ATTACK" :
					if(this.inhand.getIsWeapon() && this.cell.getZombie().size() > 0 ){
                		this.AttackAction();
						this.actionPoints -= 1;
					}
                	break;
            	}
			}
			this.actionPoints = 3;
    	}

	public void openDoor(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
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
					this.inhand = new MasterKey();
					((MasterKey)this.inhand).use(this,Direction.NORTH);
				}
				break;
			case "S":
				if (this.southLocked()) {
					this.inhand = new MasterKey();
					((MasterKey)this.inhand).use(this,Direction.SOUTH);
				}
				break;
			case "E":
				if (this.eastLocked()) {
					this.inhand = new MasterKey();
					((MasterKey)this.inhand).use(this,Direction.EAST);
				}
				break;
			case "W":
				if (this.westLocked()) {
					this.inhand = new MasterKey();
					((MasterKey)this.inhand).use(this,Direction.WEST);
				}
				break;
			default:
				System.out.println("Invalid direction");
				break;
		}
	}

	public boolean northLocked(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
		if (x == 0) {
			return false;
		}
		return (cells[x][y].isLocked(Direction.NORTH)) && ((cells[x][y] instanceof BuildingCell) || ((cells[x][y] instanceof StreetCell) && cells[x-1][y] instanceof BuildingCell));
	}

	public boolean southLocked(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
		if (x == board.getSize() - 1) {
			return false;
		}
		return (cells[x][y].isLocked(Direction.SOUTH)) && ((cells[x][y] instanceof BuildingCell) || ((cells[x][y] instanceof StreetCell) && cells[x+1][y] instanceof BuildingCell));
	}

	public boolean eastLocked(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
		if (y == board.getSize() - 1) {
			return false;
		}
		return (cells[x][y].isLocked(Direction.EAST)) && ((cells[x][y] instanceof BuildingCell) || ((cells[x][y] instanceof StreetCell) && cells[x][y+1] instanceof BuildingCell));
	}

	public boolean westLocked(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
		if (y == 0) {
			return false;
		}
		return (cells[x][y].isLocked(Direction.WEST)) && ((cells[x][y] instanceof BuildingCell) || ((cells[x][y] instanceof StreetCell) && cells[x][y-1] instanceof BuildingCell));
	}


	public void equip() {
		Scanner in = new Scanner(System.in);
		System.out.println("You are holding : " + this.inhand);
	
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
	


	public void move(){
		Cell[][] cells = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
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

	public void moveNorth() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
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

	public void moveSouth() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
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

	public void moveEast() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
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

	public void moveWest() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
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
	public boolean isDead() {
		if (this.Lifepoints == 0) {
			return true;
		} else {
			return false;
		}
	}
	public void isattacked(int Damage) {
		this.Lifepoints = this.Lifepoints - Damage;   
		if (this.Lifepoints<=0) {
			this.Lifepoints = 0;}
		isDead();
   
	}
   

}
