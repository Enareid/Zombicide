package game.Celles;

import game.*;
import game.Entities.*;


public class StreetCell extends Cell{
    protected boolean canSpawn;


    /**
     * Builds a new street cell. 
     */
    public StreetCell() {
        super();
        this.canSpawn = true;
    }

    /**
     * Returns if the cell can spawn a zombie. 
     * @return if the cell cans spawn a zombie. 
     */
    public boolean getCanSpawn() {
        return this.canSpawn;
    }

    /**
     * Allows the cell to spawn a zombie. 
     */
    public void allowSpawn() {
        this.canSpawn = true;
    }
    
    /**
     * Disallows the cell to spawn a zombie. 
     */
    public void disallowSpawn() {
        this.canSpawn = false;
    }

    /**
     * spawns a zombie in the cell.
     */
    public void spawnZombie() {
        this.zombies.add(new Zombie());
    }
    
}
