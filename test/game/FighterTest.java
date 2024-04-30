package game;

import org.junit.jupiter.api.*;

import game.PlayerTest;
import game.Boards.ClassicalBoard;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import game.Entities.Players.*;
import game.Equipements.Weapons.Gun;
import game.Entities.Player;


public class FighterTest extends PlayerTest{

    protected Player createPlayer(Board board, Cell cell){
        return new Fighter(cell, board);
    }

    @BeforeEach
    public void before() throws Exception{
        this.gun = new Gun();
        List<Player> players = new ArrayList<Player>();
        this.board = new ClassicalBoard(5, players);
        this.cell = this.board.getCell(0,0);
        this.player = createPlayer(this.board, this.cell);
        players.add(this.player);
    }

    @Test
    public void testPlayerInitialization() throws Exception {
    
        assertEquals(5, this.player.getLifepoints());
        assertEquals(0, this.player.getExpertiseLevel()); 
        assertEquals(3, this.player.getActionPoints());
        assertEquals(0, this.player.getEquipments().size());
        
    }
}
    