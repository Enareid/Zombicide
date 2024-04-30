package game;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import game.Boards.*;
import game.Cells.BuildingCell;
import game.Entities.Player;
import game.Entities.Players.Fighter;

import static org.junit.jupiter.api.Assertions.*;


public abstract class BoardTest {

    protected abstract Board createBoard(int size, List<Player> players);
    protected Board board;

    @BeforeEach
    public void before() throws Exception{
        List<Player> players = new ArrayList<Player>();
        Player player = new Fighter(null,null);
        players.add(player);
        this.board = createBoard(5,players);
    }

    @Test 
    public void testBoardInitialization(){
        assertEquals(5, this.board.getSize());
        assertEquals(0, this.board.getZombies().size());
        assertEquals(1, this.board.getPlayers().size());
    }

    @Test 
    public void testGetCells(){
        Cell[][] cells = this.board.getCells();
        assertEquals(5, cells.length);
        assertEquals(5, cells[0].length);
    }

    @Test 
    public void getMaxNoiseWhenNoNoise(){
        assertEquals(0, this.board.getMaxNoise().noiseLevel);
    }

    @Test 
    public void testGetSize(){
        assertEquals(5, this.board.getSize());
    }

    @Test
    public void testGetAndSetCell(){
        Cell cell = new BuildingCell(0,0);
        this.board.setCell(0, 0, cell);
        assertEquals(cell, this.board.getCell(0, 0));
    }
}