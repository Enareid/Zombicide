package game.Entities;

import game.Cell;
import game.Entity;

public abstract class Zombie extends Entity {

    protected int Damage;
    protected int actionPoint;

    /**
     * Builds a new zombie.
     */
    public Zombie(int Lifepoints, Cell cell){
        super(Lifepoints,cell);
    }
    public int getDamage() {
		return this.Damage;
	}
    
}
