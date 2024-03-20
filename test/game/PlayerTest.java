package game;

import static org.junit.Assert.*;
import org.junit.Test;
import game.Entities.Player;
import game.Entities.Players.*;
public class PlayerTest {

    @Test
    public void testPlayerInitialization() {
        Cell cell = new Cell(10, 5); 
        Player player = new Fighter(5, cell); 

        assertEquals(5, player.getLifeLevel());
        assertEquals(cell, player.getCell()); 
        assertEquals(0, player.getExpertiseLevel()); 
        assertEquals(3, player.getActionPoints()); ; 
        assertEquals(0, player.getEquipments().size());
    }

}