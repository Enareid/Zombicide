package game;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import game.Cells.BuildingCells.ContinentalCell;

public class ContinentalCellTest extends BuildingCellTest{

    private Cell continentalCell;

    @BeforeEach
    public void before() {
        super.before();
        this.continentalCell = new ContinentalCell(1, 0, 0);
    }

    @Test
    public void testCreateCopy() {
        Cell cell = this.continentalCell.createCopy();
        assertEquals(this.continentalCell.getCoord()[0], cell.getCoord()[0]);
        assertEquals(this.continentalCell.getCoord()[1], cell.getCoord()[1]);
    }

    @Test
    public void testToString() {
        assertEquals("C        ", this.continentalCell.toString());
    }
}
