package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Boards.ClassicalBoard;
import game.Entities.Player;
import game.Entities.Players.Fighter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class FighterTest {
    
    private Fighter fighter;
    private Board board;
    private Cell cell;

    @BeforeEach
    public void before() throws Exception {
        List<Player> players = new ArrayList<>();
        this.board = new ClassicalBoard(5,players);
        this.cell = new Cell(0, 0);
        fighter = new Fighter(this.cell, this.board);
    }

    @Test
    public void testDiceWhenIsTheRightDice() {
        assertTrue(fighter.dice() >= 2 && fighter.dice() <= 7);
    }

    @Test
    public void testDiceWhenIsNotTheRightDice() {
        assertFalse(fighter.dice() < 2 || fighter.dice() > 7);
    }

    @Test
    public void testToString() {
        assertEquals("Fighter" + " | Life points : " + fighter.getLifepoints() + " | Action points : " + fighter.getActionPoints() + " | Expertise level : " + fighter.getExpertiseLevel() + " | Equipements : " + fighter.getEquipments() + " | In hand : " + fighter.getInHand(), fighter.toString());
    }

    @Test
    public void testToString2() {
        assertEquals("Fighter (you)" + " | Life points : " + fighter.getLifepoints() + " | Action points : " + fighter.getActionPoints() + " | Expertise level : " + fighter.getExpertiseLevel() + " | Equipements : " + fighter.getEquipments() + " | In hand : " + fighter.getInHand(), fighter.ToString());
    }
}
