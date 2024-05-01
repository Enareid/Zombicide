package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Boards.ClassicalBoard;
import game.Entities.Player;
import game.Entities.Players.Healer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class HealerTest {

    private Healer healer;
    private Board board;
    private Cell cell;

    @BeforeEach
    public void before() throws Exception {
        List<Player> players = new ArrayList<>();
        this.board = new ClassicalBoard(5,players);
        this.cell = new Cell(0, 0);
        healer = new Healer(this.cell, this.board);
    }

    @Test
    public void testToString() {
        assertEquals("Healer" + " | Life points : " + healer.getLifepoints() + " | Action points : " + healer.getActionPoints() + " | Expertise level : " + healer.getExpertiseLevel() + " | Equipements : " + healer.getEquipments() + " | In hand : " + healer.getInHand(), healer.toString());
    }

    @Test
    public void testToString2() {
        assertEquals("Healer (you)" + " | Life points : " + healer.getLifepoints() + " | Action points : " + healer.getActionPoints() + " | Expertise level : " + healer.getExpertiseLevel() + " | Equipements : " + healer.getEquipments() + " | In hand : " + healer.getInHand(), healer.ToString());
    }
    
}
