package game;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import game.Entities.Players.*;
import game.Player;
public class PlayerTest {

    @Test
    public void testPlayerInitialization() {
        Cell cell = new Cell(10, 5); 
        Player player = new Fighter(5, cell); 

        assertEquals(5, player.getLifePoints());
        assertEquals(cell, player.getCell()); 
        assertEquals(0, player.getExpertiseLevel()); 
        assertEquals(3, player.getActionPoints()); ; 
        assertEquals(1, player.getEquipments().size());
    }

}