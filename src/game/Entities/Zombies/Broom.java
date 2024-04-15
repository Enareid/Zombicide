package game.Entities.Zombies;
import game.Cell;
import game.Board;
import game.Entities.Zombie;

public class Broom extends Zombie{
    
    /**
     * Builds a new Broom.
     * 
     * @param cell the cell where the Broom will spawn
     * @param board the board where the Broom will spawn
     */
    public Broom(Cell cell, Board board){
        super(4, 2, board, 1, true, cell,1);
    }

    /**
     * Returns the string representation of the Broom.
     * @return the string representation of the Broom.
     */
    public String toString(){
        return "Broom has "+this.getLifepoints()+" Lifepoints";
    }
}
