package game.Entities;

import game.Board;
import game.Cell;
import game.Entity;

public abstract class Zombie extends Entity {

    protected int Damage;
    protected int actionPoint;

    /**
     * Builds a new zombie.
     * 
     * @param Lifepoints the lifepoints of the zombie.
     * @param cell the cell of the zombie.
     */
    public Zombie(int Lifepoints, int Damage, int actionPoint,  Cell cell){
        super(Lifepoints,cell);
    }
    
}
