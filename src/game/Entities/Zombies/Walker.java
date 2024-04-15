package game.Entities.Zombies;
import game.Cell;
import game.Entities.Zombie;
import game.Board;

/** The Walker class extends zombie class */
public class Walker extends Zombie{

    /**
     * Builds a new Walker.
     * 
     * @param cell the cell where the Walker will spawn
     * @param board the board where the Walker will spawn
     */
    public Walker(Cell cell, Board board){
        super(1, 1, board, 1, false, cell,0);
    }

    /**
     * Returns the string representation of the Walker.
     * @return the string representation of the Walker.
     */
    public String toString(){
        return "Walker has "+this.getLifepoints()+" Lifepoints";
    }
    
}