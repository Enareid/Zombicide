package game.Entities.Zombies;
import game.Board;
import game.Cell;


import game.Entities.Zombie;

public class Abomination extends Zombie {
    
    /**
     * Builds a new Abomination.
     * 
     * @param cell the cell where the Abomination will spawn
     * @param board the board where the Abomination will spawn
     */
    public Abomination(Cell cell, Board board){
        super(6, 3, board, 1, true, cell,1);
    }

    /**
     * Returns the string representation of the Abomination.
     * @return the string representation of the Abomination.
     */
    public String toString(){
        return "Abomination has "+this.getLifepoints()+" Lifepoints";
    }
    
}
