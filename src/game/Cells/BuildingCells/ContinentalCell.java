package game.Cells.BuildingCells;

import game.Cells.BuildingCell;

public class ContinentalCell extends BuildingCell{

    /** The number of life points restored */
    protected int lifePointsRestored;

    /**
     * Builds a new continental cell.
     * @param lifePointsRestored the number of life points restored.
     */
    public ContinentalCell(int lifePointsRestored,int x, int y) {
        super(x,y);
        this.lifePointsRestored = lifePointsRestored;
        this.canAttack = false;
    }

    /**
     * Regenerates the player's life points.
     */
    public void regen() {
        // TODO
    }


    /**
     * Returns the string representation of the cell.
     * @return the string representation of the cell.
     */
    public String toString(){
        String str="C";
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
