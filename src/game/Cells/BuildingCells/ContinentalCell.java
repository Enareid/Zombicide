package game.Cells.BuildingCells;

import game.Cell;
import game.Cells.BuildingCell;
import game.Entities.Player;

public class ContinentalCell extends BuildingCell{

    /** The number of life points restored */
    protected int lifePointsRestored;

    /**
     * Builds a new continental cell.
     * 
     * @param lifePointsRestored the number of life points restored.
     * @param x The x coordinate of the cell.
     * @param y The y coordinate of the cell.
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
        for (Player player : this.players) {
            if(player.getLifepoints() < player.getMaxLifeLevel()){
                player.setLifepoints(player.getLifepoints() + this.lifePointsRestored);
            }
        }
    }

    /**
     * Creates a copy of the cell.
     * @return a copy of the cell.
     */
    public Cell createCopy(){
        Cell cell = new ContinentalCell(this.lifePointsRestored,this.coord[0],this.coord[1]);
        return cell;
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
