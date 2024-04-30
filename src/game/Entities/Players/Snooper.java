package game.Entities.Players;

import game.Board;
import game.Cell;
import game.Entities.Player;

/** The Snooper class extends Player class */
public class Snooper extends Player{

    private int freeSnoop;

    /**
     * Builds a new Snooper.
     * 
     * @param cell the cell where the Snooper will spawn
     * @param board the board where the Snooper will spawn
     */
    public Snooper(Cell cell,Board board){
        super(cell, board);
        this.freeSnoop = 1;
    }

    /**
     * Gets the free snoop of the Snooper.
     * 
     * @return the free snoop of the Snooper.
     */
    public int getFreeSnoop() {
        return this.freeSnoop;
    }

    /**
     * Sets the free snoop of the Snooper.
     * 
     * @param freeSnoop the free snoop of the Snooper.
     */
    public void setFreeSnoop(int freeSnoop) {
        this.freeSnoop = freeSnoop;
    }
    
    /**
     * Returns the string representation of the Snooper.
     * @return the string representation of the Snooper.
     */
    public String ToString() {
		return "Snooper (you)" + " | Life points : " + this.getLifepoints() + " | Action points : " + this.getActionPoints() + " | Expertise level : " + this.getExpertiseLevel() + " | Free snoop : " + this.freeSnoop + " | Equipements : " + this.getEquipments() + " | In hand : " + this.getInHand();
    }

    /**
     * Returns the string representation of the Snooper.
     * @return the string representation of the Snooper.
     */
    public String toString() {
		return "Snooper" + " | Life points : " + this.getLifepoints() + " | Action points : " + this.getActionPoints() + " | Expertise level : " + this.getExpertiseLevel() + " | Free snoop : " + this.freeSnoop + " | Equipements : " + this.getEquipments() + " | In hand : " + this.getInHand();
    }
}
