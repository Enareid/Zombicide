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
            str+="Z"+this.zombies.size();
        }
        if(str.length()>1){
            str+="\n";
        }
        if(!this.players.isEmpty()){
            str+="P"+this.players.size();
        }
        return str;
    }
}
