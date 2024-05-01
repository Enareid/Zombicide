package game;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import game.Cells.BuildingCell;

public class BuildingCellTest extends CellTest{

    private Cell buildingCell;

    @BeforeEach
    public void before(){
        super.before();
        this.buildingCell = new BuildingCell(0,0);
    }
    
    @Test
    public void testCreateCopy(){
        Cell cell = this.buildingCell.createCopy();
        assertEquals(this.buildingCell.getCoord()[0], cell.getCoord()[0]);
        assertEquals(this.buildingCell.getCoord()[1], cell.getCoord()[1]);
    }

    @Test
    public void testToString(){
        assertEquals("B        ", this.buildingCell.toString());
    }
    
}
