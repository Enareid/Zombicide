package game.Entities.Players;

import game.Board;
import game.Cell;
import game.Entities.Player;

/** The Snooper class extends Player class */
public class Snooper extends Player{

    /**
     * Builds a new Snooper.
     * 
     * @param Lifepoints the lifepoints of the Snooper
     * @param cell the cell where the Snooper will spawn
     * @param board the board where the Snooper will spawn
     */
    public Snooper(int Lifepoints, Cell cell,Board board){
        super(Lifepoints,cell, board);
    }
    
    /**
     * Returns the string representation of the Snooper.
     * @return the string representation of the Snooper.
     */
    public String toString() {
        return "Snooper";
    }
}
