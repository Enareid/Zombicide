package game.Entities.Players;

import game.Board;
import game.Cell;
import game.Entities.Player;

/** The Healer class extends Player class */
public class Healer extends Player{

    /**
     * Builds a new Healer.
     * 
     * @param cell the cell where the Healer will spawn
     * @param board the board where the Healer will spawn
     */
    public Healer(Cell cell,Board board){
        super(cell, board);
    }
    
    /**
     * Returns the string representation of the Healer.
     * @return the string representation of the Healer.
     */
    public String ToString() {
		return "Healer (you)" + " | Life points : " + this.getLifepoints() + " | Action points : " + this.getActionPoints() + " | Expertise level : " + this.getExpertiseLevel() + " | Equipements : " + this.getEquipments() + " | In hand : " + this.getInHand();

    }

    /**
     * Returns the string representation of the Healer.
     * @return the string representation of the Healer.
     */
    public String toString() {
		return "Healer" + " | Life points : " + this.getLifepoints() + " | Action points : " + this.getActionPoints() + " | Expertise level : " + this.getExpertiseLevel() + " | Equipements : " + this.getEquipments() + " | In hand : " + this.getInHand();

    }
}
