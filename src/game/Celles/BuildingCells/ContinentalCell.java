package game.Celles.BuildingCells;

import game.Celles.BuildingCell;

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
}
