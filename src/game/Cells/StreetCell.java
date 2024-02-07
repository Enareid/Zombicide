package game.Cells;

import game.*;
import game.Entities.*;


public class StreetCell extends Cell{
    protected boolean canSpawn;


    /**
     * Builds a new street cell.
     */
    public StreetCell() {
        super();
        this.canSpawn = false;
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

    public String toString(){
        String str="S";
        if(!this.zombies.isEmpty()){
            str+="z"+this.zombies.size();
        }
        if(!this.players.isEmpty()){
            str+="p"+this.players.size();
        }
        int lenstr = str.length();
        for(int i = 0; i < 9- lenstr; i++){
            str += " ";
        }
        return str;
    }

}
