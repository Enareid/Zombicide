package game.Entities.Players;

import game.Board;
import game.Cell;
import game.Entities.Player;

/** The Lucky class extends Player class */
public class Lucky extends Player{

    /**
     * Builds a new Lucky.
     * 
     * @param Lifepoints the lifepoints of the Lucky
     * @param cell the cell where the Lucky will spawn
     * @param board the board where the Lucky will spawn
     */
    public Lucky(int Lifepoints, Cell cell,Board board){
        super(Lifepoints,cell, board);
    }
    
    /**
     * Returns the string representation of the Lucky.
     * @return the string representation of the Lucky.
     */
    public String toString() {
        return "Lucky";
    }
}
