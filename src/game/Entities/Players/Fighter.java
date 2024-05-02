package game.Entities.Players;

import game.Board;
import game.Cell;
import game.Entities.Player;

/** The Fighter class extends Player class */
public class Fighter extends Player{
    
    /**
     * Builds a new Fighter.
     * 
     * @param cell the cell where the Fighter will spawn
     * @param board the board where the Fighter will spawn
     */
    public Fighter(Cell cell,Board board){
        super(cell,board);
    }

    /**
     * Emulate a dice.
     * 
     * @return a random number between 1 and 6
     */
    public int dice(){
        return (int)(Math.random() * 6 + 1) + 1;
    }

    /**
     * Returns the string representation of the Fighter.
     * @return the string representation of the Fighter.
     */
    public String ToString() {
		return "Fighter (you)" + " | Position : (" + this.getCell().getCoord()[1] + "," + this.getCell().getCoord()[0] + ")" + " | Life points : " + this.getLifepoints() + " | Action points : " + this.getActionPoints() + " | Expertise level : " + this.getExpertiseLevel() + " | Equipements : " + this.getEquipments() + " | In hand : " + this.getInHand();
    }

    /**
     * Returns the string representation of the Fighter.
     * @return the string representation of the Fighter.
     */
    public String toString() {
		  return "Fighter" + " | Life points : " + this.getLifepoints() + " | Action points : " + this.getActionPoints() + " | Expertise level : " + this.getExpertiseLevel() + " | Equipements : " + this.getEquipments() + " | In hand : " + this.getInHand();
    }
}
