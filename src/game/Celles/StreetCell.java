package src.game.Celles;

import src.game.Cell;

public class StreetCell extends Cell{
    protected boolean canSpawn;

    /**
     * Builds a new street cell. 
     */
    public StreetCell() {
        super();
        this.canSpawn = true;
    }
    
}
