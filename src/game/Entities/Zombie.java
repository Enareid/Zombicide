package game.Entities;

import game.Cell;
import game.Entity;

public abstract class Zombie extends Entity {

    /**
     * Builds a new zombie.
     */
    public Zombie(int Lifepoints, Cell cell){
        super(Lifepoints,cell);
    }
    
}
