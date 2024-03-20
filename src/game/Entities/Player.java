package game.Entities;
import game.Equipement;
import game.Board;
import game.Cell;
import game.Entity;
import java.util.*;

public abstract class Player extends Entity{
    protected List<Equipement> bag;
		protected Equipement inhand;
    private int actionPoints;
	private int expertiseLevel;
	protected Board board;
    static final int MAX_LIFE_LEVEL = 5;
	private Cell cell;


    /**
     * Builds a new player.
	 * 
	 * @param Lifepoints the lifepoints of the player.
	 * @param cell the cell of the player.
     */
    public Player(int Lifepoints, Cell cell, Board board){
        super(Lifepoints,cell);
        this.expertiseLevel = 0;
        this.actionPoints = 3;
        this.bag = new ArrayList<Equipement>();
				this.inhand = null;
				this.cell = cell;
    }
    
	/**
	 * Gets the action points of the player.
	 * @return the action points of the player.
	 */
    public int getActionPoints() {
		return this.actionPoints;
	}

	/**
	 * Gets the cell of the player.
	 * 
	 * @return the cell of the player.
	 */
	public Cell getCell() {
		return this.cell;
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
	 * Sets the board for the player.
	 * 
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	/**
	 * Sets the cell of the player.
	 * 
	 * @param cell the cell of the player.
	 */
	public void setCell(Cell cell) {
		this.cell = cell;
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

	public void useInHand(Object target) {
		if (this.inhand != null) {
			this.inhand.use(target);
		}
	}

	/**
	 * Get the maximum life level of the player.
	 * @return the maximum life level of the player.
	 */
    public int getMaxLifeLevel() {
		return MAX_LIFE_LEVEL;
	}

}
