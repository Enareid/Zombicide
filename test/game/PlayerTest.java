package game;
import java.util.*;
import org.junit.jupiter.api.*;
import game.Boards.*;
import game.Entities.Player;
import game.Equipements.Weapons.Axe;
import game.Equipements.Weapons.Gun;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest{

    private Player player;
    private Board board;
    private Cell cell;

    @BeforeEach
    public void before() throws Exception {
        List<Player> players = new ArrayList<>();
        this.board = new ClassicalBoard(5,players);
        this.cell = new Cell(0, 0);
        player = new Player(this.cell, this.board);
    }

    @Test
    public void testGetExpertiseLevelWhenIsTheRightExpertiseLevel() {
        assertEquals(0, player.getExpertiseLevel());
    }

    @Test
    public void testGetExpertiseLevelWhenIsNotTheRightExpertiseLevel() {
        assertNotEquals(1, player.getExpertiseLevel());
    }

    @Test
    public void testSetExpertiseLevel() {
        assertEquals(0, player.getExpertiseLevel());
        player.setExpertiseLevel(1);
        assertEquals(1, player.getExpertiseLevel());
    }

    @Test
    public void testGetEquipementWhenNoEquipement() {
        assertEquals(0, player.getEquipments().size());
    }

    @Test
    public void testGetEquipmentsWhenOneEquipement(){
        Equipement equipement = new Gun();
        player.setEquipment(equipement);
        assertEquals(1, player.getEquipments().size());
        assertEquals(equipement, player.getEquipments().get(0));
    }

    @Test
    public void testRemoveEquipmentWhenNoEquipement(){
        assertEquals(0, player.getEquipments().size());
        player.removeEquipement(new Gun());
        assertEquals(0, player.getEquipments().size());
    }

    @Test
    public void testRemoveEquipmentWhenOneEquipement(){
        Equipement equipement = new Gun();
        player.setEquipment(equipement);
        assertEquals(1, player.getEquipments().size());
        player.removeEquipement(equipement);
        assertEquals(0, player.getEquipments().size());
    }

    @Test
    public void testRemoveEquipmentWhenEquipmentAlreadyRemoved(){
        Equipement equipement = new Gun();
        player.setEquipment(equipement);
        assertEquals(1, player.getEquipments().size());
        player.removeEquipement(equipement);
        assertEquals(0, player.getEquipments().size());
        player.removeEquipement(equipement);
        assertEquals(0, player.getEquipments().size());
    }

    @Test 
    public void testGetInHandWhenIsTheRightInHand() {
        assertTrue(player.getInHand().toString().equals("Gun"));
    }

    @Test
    public void testGetInHandWhenIsNotTheRightInHand() {
        assertFalse(player.getInHand().toString().equals("Axe"));
    }

    @Test
    public void testGetMaxLifeLevel() {
        assertEquals(5, player.getMaxLifeLevel());
    }

    @Test 
    public void testGetDynamiqueActionPointsWhenIsTheRightDynamiqueActionPoints() {
        assertEquals(3, player.getDynamiqueActionPoints());
    }

    @Test
    public void testGetDynamiqueActionPointsWhenIsNotTheRightDynamiqueActionPoints() {
        assertNotEquals(10, player.getDynamiqueActionPoints());
    }
}
