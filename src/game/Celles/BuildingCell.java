package src.game.Celles;

import src.game.Cell;

public class BuildingCell extends Cell{
    protected List<Door> doors;

    /**
     * Builds a new building cell. 
     */
    public BuildingCell() {
        super();
        this.doors = new ArrayList<Door>();
    }
}
