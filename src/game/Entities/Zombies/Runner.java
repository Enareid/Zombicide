package game.Entities.Zombies;

import game.Cell;
import game.Entities.Zombie;
import game.Board;

/** The Runner class extends zombie class */
public class Runner extends Zombie{

    /**
     * Builds a new Runner.
     * 
     * @param cell the cell where the Runner will spawn
     * @param board the board where the Runner will spawn
     */
    public Runner(Cell cell, Board board){
        super(2, 1, board, 2, false, cell ,0);
    }
    
    /**
     * Returns the string representation of the Runner.
     * @return the string representation of the Runner.
     */
    public String toString(){
        return "Runner has "+this.getLifepoints()+" Lifepoints";
    }
}
