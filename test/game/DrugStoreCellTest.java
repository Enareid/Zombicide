package game;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import game.Cells.BuildingCells.DrugStoreCell;

public class DrugStoreCellTest extends BuildingCellTest{

    private Cell drugStoreCell;

    @BeforeEach
    public void before() {
        super.before();
        this.drugStoreCell = new DrugStoreCell(1, 0);
    }

    @Test
    public void testCreateCopy() {
        Cell cell = this.drugStoreCell.createCopy();
        assertEquals(this.drugStoreCell.getCoord()[0], cell.getCoord()[0]);
        assertEquals(this.drugStoreCell.getCoord()[1], cell.getCoord()[1]);
    }

    @Test
    public void testToString() {
        assertEquals("D        ", this.drugStoreCell.toString());
    }
    
}
