package game.Cells;

import java.util.*;
import game.*;

public class BuildingCell extends Cell{

    /** The doors of the building */
    protected Map<Door,Direction> doors;

    /**
     * Builds a new building cell.
     */
    public BuildingCell() {
        super();
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
        if(!this.players.isEmpty()){
            if(str.length()==3){
                str+=" ";
            }
            str+="p"+this.players.size();
        }
        int lenstr = str.length();
        for(int i = 0; i < 6- lenstr; i++){
            str += " ";
        }
        return str;
    }
}
