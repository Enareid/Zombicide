package game.Entities.Players;

import game.Board;
import game.Cell;
import game.Entities.Player;

/** The Lucky class extends Player class */
public class Lucky extends Player{

    /**
     * Builds a new Lucky.
     * 
     * @param cell the cell where the Lucky will spawn
     * @param board the board where the Lucky will spawn
     */
    public Lucky(Cell cell,Board board){
        super(cell, board);
    }
    
    /**
     * Returns the string representation of the Lucky.
     * @return the string representation of the Lucky.
     */
    public String ToString() {
		return "Lucky (you)" + " | Life points : " + this.getLifepoints() + " | Action points : " + this.getActionPoints() + " | Expertise level : " + this.getExpertiseLevel() + " | Equipements : " + this.getEquipments() + " | In hand : " + this.getInHand();
    }

    /**
     * Returns the string representation of the Lucky.
     * @return the string representation of the Lucky.
     */
    public String toString() {
		return "Lucky" + " | Life points : " + this.getLifepoints() + " | Action points : " + this.getActionPoints() + " | Expertise level : " + this.getExpertiseLevel() + " | Equipements : " + this.getEquipments() + " | In hand : " + this.getInHand();
    }
}
