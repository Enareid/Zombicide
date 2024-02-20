package game.Entities;
import game.Equipement;
import game.Cell;
import game.Entity;
import java.util.*;

public abstract class Player extends Entity{
    protected List<Equipement> bag;

    /**
     * Builds a new player.
     */
    public Player(int Lifepoints, Cell cell){
        super(Lifepoints,cell);
    }
    
}
