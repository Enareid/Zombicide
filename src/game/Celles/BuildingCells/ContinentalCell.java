package src.game.Celles.BuildingCells;

import src.game.Celles.BuildingCell;

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
}
