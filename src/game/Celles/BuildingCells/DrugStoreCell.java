package game.Celles.BuildingCells;

import game.Celles.BuildingCell;

public class DrugStoreCell extends BuildingCell{

    /**
     * Builds a new drug store cell. 
     */
    public DrugStoreCell() {
        super();
    }

    public String toString(){
        String str="D";
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
