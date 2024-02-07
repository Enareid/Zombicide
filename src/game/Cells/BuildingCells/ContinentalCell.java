package game.Cells.BuildingCells;

import game.Cells.BuildingCell;

public class ContinentalCell extends BuildingCell{
    protected int lifePointsRestored;

    /**
     * Builds a new continental cell.
     */
    public ContinentalCell(int lifePointsRestored) {
        super();
        this.lifePointsRestored = lifePointsRestored;
        this.canAttack = false;
    }

    /**
     * Regenerates the player's life points.
     */
    public void regen() {
        // TODO
    }
    public String toString(){
        String str="C";
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
