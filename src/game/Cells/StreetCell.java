package game.Cells;

import game.*;
import game.Entities.*;
import game.Entities.Zombies.Walker;


public class StreetCell extends Cell{

    /** If the cell can spawn a zombie */
    protected boolean canSpawn;


    /**
     * Builds a new street cell.
     */
    public StreetCell(int x, int y) {
        super(x,y);
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
        this.zombies.add(new Walker());
    }

    /**
     * Returns the string representation of the cell.
     * @return the string representation of the cell.
     */
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
