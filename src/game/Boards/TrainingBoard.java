package game.Boards;
import java.util.*;

import game.Entities.Player;

public class TrainingBoard extends ClassicalBoard{

    /**
     * Build an empty board 5x5
     * 
     * @param players the players in the board
     * @throws Exception if the size is less than 5
     */
    public TrainingBoard(List<Player> players) throws Exception {
        super(5, players);
    }
}
