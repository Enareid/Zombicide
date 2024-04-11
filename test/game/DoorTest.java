package game;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class DoorTest {

    private Door door;

    @BeforeEach
    public void before(){
        this.door = new Door(Direction.NORTH);
    }

    @Test
    public void testIsLocked(){
        assertTrue(this.door.isLocked());
    }

    @Test
    public void testUnlock(){
        this.door.unlock();
        assertFalse(this.door.isLocked());
    }

    @Test
    public void testLock(){
        this.door.unlock();
        this.door.lock();
        assertTrue(this.door.isLocked());
    }

    @Test
    public void testGetDirection(){
        assertEquals(Direction.NORTH, this.door.getDirection());
    }
}
