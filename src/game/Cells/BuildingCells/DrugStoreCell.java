package game.Cells.BuildingCells;

import game.Cells.BuildingCell;

public class DrugStoreCell extends BuildingCell{

    /**
     * Builds a new drug store cell.
     * 
     * @param x The x coordinate of the cell.
     * @param y The y coordinate of the cell.
     */
    public DrugStoreCell(int x, int y) {
        super(x,y);
    }

    /**
     * Returns the string representation of the cell.
     * @return the string representation of the cell.
     */
    public String toString(){
        String str="D";
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
