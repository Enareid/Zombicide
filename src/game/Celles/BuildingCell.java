package game.Celles;

import java.util.*;
import game.*;

public class BuildingCell extends Cell{
    protected List<Door> doors;

    /**
     * Builds a new building cell. 
     */
    public BuildingCell() {
        super();
        this.doors = new ArrayList<Door>();
    }

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
