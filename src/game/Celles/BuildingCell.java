package src.game.Celles;

import java.util.*;
import src.game.*;

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
