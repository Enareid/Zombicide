package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Boards.ClassicalBoard;
import game.Entities.Player;
import game.Entities.Players.Snooper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class SnooperTest {

    private Snooper snooper;
    private Board board;
    private Cell cell;

    @BeforeEach
    public void before() throws Exception {
        List<Player> players = new ArrayList<>();
        this.board = new ClassicalBoard(5,players);
        this.cell = new Cell(0, 0);
        snooper = new Snooper(this.cell, this.board);
    }

    @Test
    public void testGetFreeSnoopWhenIsTheRightFreeSnoop() {
        assertEquals(1, snooper.getFreeSnoop());
    }

    @Test
    public void testGetFreeSnoopWhenIsNotTheRightFreeSnoop() {
        assertNotEquals(0, snooper.getFreeSnoop());
    }

    @Test
    public void testSetFreeSnoop() {
        assertEquals(1, snooper.getFreeSnoop());
        snooper.setFreeSnoop(0);
        assertEquals(0, snooper.getFreeSnoop());
    }

    @Test
    public void testToString() {
        assertEquals("Snooper" + " | Life points : " + snooper.getLifepoints() + " | Action points : " + snooper.getActionPoints() + " | Expertise level : " + snooper.getExpertiseLevel() + " | Free snoop : " + snooper.getFreeSnoop() + " | Equipements : " + snooper.getEquipments() + " | In hand : " + snooper.getInHand(), snooper.toString());
    }

    @Test
    public void testToString2() {
        assertEquals("Snooper (you)" + " | Life points : " + snooper.getLifepoints() + " | Action points : " + snooper.getActionPoints() + " | Expertise level : " + snooper.getExpertiseLevel() + " | Free snoop : " + snooper.getFreeSnoop() + " | Equipements : " + snooper.getEquipments() + " | In hand : " + snooper.getInHand(), snooper.ToString());
    }
    
}
