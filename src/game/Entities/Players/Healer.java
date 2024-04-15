package game.Entities.Players;

import game.Board;
import game.Cell;
import game.Entities.Player;

public class Healer extends Player{

    /**
     * Builds a new Healer.
     * 
     * @param Lifepoints the lifepoints of the Healer
     * @param cell the cell where the Healer will spawn
     * @param board the board where the Healer will spawn
     */
    public Healer(int Lifepoints, Cell cell,Board board){
        super(Lifepoints,cell, board);
    }
    
    /**
     * Returns the string representation of the Healer.
     * @return the string representation of the Healer.
     */
    public String toString() {
        return "Healer";
    }
}
