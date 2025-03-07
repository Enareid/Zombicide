package game.Cells;

import game.*;

/** The StreetCell class extends Cell class */
public class StreetCell extends Cell{

    /** If the cell can spawn a zombie */
    protected boolean canSpawn;


    /**
     * Builds a new street cell.
     * 
     * @param x The x coordinate of the cell.
     * @param y The y coordinate of the cell.
     */
    public StreetCell(int x, int y) {
        super(x,y);
        this.canSpawn = false;
    }

    /**
     * Returns if the cell can spawn a zombie.
     * @return if the cell can spawn a zombie.
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
     * Returns a copy of the cell.
     */
    public Cell createCopy(){
        Cell cell = new StreetCell(this.coord[0],this.coord[1]);
        return cell;
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
        else {
            str+="  ";
        }
        str+=" ";
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