package game;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import game.Cells.StreetCell;

public class StreetCellTest extends CellTest{

    private Cell streetCell;

    @BeforeEach
    public void before(){
        super.before();
        this.streetCell = new StreetCell(0,0);
    }
    
    @Test
    public void testCreateCopy(){
        Cell cell = this.streetCell.createCopy();
        assertEquals(this.streetCell.getCoord()[0], cell.getCoord()[0]);
        assertEquals(this.streetCell.getCoord()[1], cell.getCoord()[1]);
    }

    @Test
    public void testToString(){
        assertEquals("S        ", this.streetCell.toString());
    }
    
    @Test
    public void testGetCanSpawn(){
        assertFalse(((StreetCell)this.streetCell).getCanSpawn());
    }

    @Test
    public void testAllowSpawn(){
        ((StreetCell)this.streetCell).allowSpawn();
        assertTrue(((StreetCell)this.streetCell).getCanSpawn());
    }

    @Test
    public void testDisallowSpawn(){
        ((StreetCell)this.streetCell).allowSpawn();
        assertTrue(((StreetCell)this.streetCell).getCanSpawn());
        ((StreetCell)this.streetCell).disallowSpawn();
        assertFalse(((StreetCell)this.streetCell).getCanSpawn());
    }
    
}
