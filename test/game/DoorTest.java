package game;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class DoorTest {

    private Door door;

    @BeforeEach
    public void before(){
        this.door = new Door(Direction.UP);
    }

    @Test
    public void testIsLocked(){
        assertTrue(this.door.isLocked());
    }
}
