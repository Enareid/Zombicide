package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Boards.ClassicalBoard;
import game.Entities.Player;
import game.Entities.Players.Lucky;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class LuckyTest {

    private Lucky lucky;
    private Board board;
    private Cell cell;

    @BeforeEach
    public void before() throws Exception {
        List<Player> players = new ArrayList<>();
        this.board = new ClassicalBoard(5,players);
        this.cell = new Cell(0, 0);
        lucky = new Lucky(this.cell, this.board);
    }

    @Test
    public void testToString() {
        assertEquals("Lucky" + " | Life points : " + lucky.getLifepoints() + " | Action points : " + lucky.getActionPoints() + " | Expertise level : " + lucky.getExpertiseLevel() + " | Equipements : " + lucky.getEquipments() + " | In hand : " + lucky.getInHand(), lucky.toString());
    }

    @Test
    public void testToString2() {
        assertEquals("Lucky (you)" + " | Life points : " + lucky.getLifepoints() + " | Action points : " + lucky.getActionPoints() + " | Expertise level : " + lucky.getExpertiseLevel() + " | Equipements : " + lucky.getEquipments() + " | In hand : " + lucky.getInHand(), lucky.ToString());
    }
    
}
