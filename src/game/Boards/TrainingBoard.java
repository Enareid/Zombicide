package game.Boards;
import java.util.*;

import game.Entities.Player;

public class TrainingBoard extends ClassicalBoard{

    /**
     * Build an empty board 5x5
     * @throws Exception 
     */
    public TrainingBoard(List<Player> players) throws Exception {
        super(5, players);
    }
}
