package game.Entities.Players;

import game.Board;
import game.Cell;
import game.Entities.Player;

/** The Fighter class extends Player class */
public class Fighter extends Player{
    
    /**
     * Builds a new Fighter.
     * 
     * @param Lifepoints the lifepoints of the Fighter
     * @param cell the cell where the Fighter will spawn
     * @param board the board where the Fighter will spawn
     */
    public Fighter(int Lifepoints, Cell cell,Board board){
        super(Lifepoints,cell,board);
    }

    /**
     * Returns the string representation of the Fighter.
     * @return the string representation of the Fighter.
     */
    public String toString() {
        return "Fighter";
    }

    
}
