package game.Cells;

import java.util.*;
import game.*;

public class BuildingCell extends Cell{

    /** The doors of the building */
    protected Map<Door,Direction> doors;

    /**
     * Builds a new building cell.
     */
    public BuildingCell(int x, int y) {
        super(x,y);
        this.doors = new HashMap<>();
    }

    /**
     * Returns the string representation of the cell.
     * @return the string representation of the cell.
     */
    public String toString(){
        String str="B";
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
