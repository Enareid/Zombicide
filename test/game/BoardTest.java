package game;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import game.Boards.*;
import game.Cells.BuildingCell;
import game.Entities.Player;
import game.Entities.Players.Fighter;
import game.Entities.Zombie;
import game.Entities.Zombies.Walker;

import static org.junit.jupiter.api.Assertions.*;


public abstract class BoardTest {

    protected abstract Board createBoard(int size, List<Player> players);
    protected Board board;
    protected Player player;
    protected List<Player> players;

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
    public void testGetMaxNoiseLevelWhenNoNoise(){
        assertEquals(0, this.board.getMaxNoise().noiseLevel);
    }

    @Test 
    public void testGetMaxNoiseLevelWhenNoise(){
        Cell cell = this.board.getCell(0, 0);
        cell.setNoiseLevel(5);;
        assertEquals(5, this.board.getMaxNoise().noiseLevel);
    }

    @Test 
    public void testGetMaxNoiseLevelWhenNoiseOnMultipleCells(){
        Cell cell = this.board.getCell(0, 0);
        cell.setNoiseLevel(5);
        cell = this.board.getCell(0, 1);
        cell.setNoiseLevel(3);
        assertEquals(5, this.board.getMaxNoise().noiseLevel);
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

    @Test 
    public void testGetZombiesWhenNoZombies(){
        assertEquals(0, this.board.getZombies().size());
    }

    @Test 
    public void testAddZombie(){
        assertEquals(0, this.board.getZombies().size());
        Zombie zombie = new Walker(this.board.getCell(0, 0), this.board);
        this.board.addZombie(zombie);
        assertEquals(1, this.board.getZombies().size());
    }

    @Test 
    public void testRemoveZombieWhenZombieInBoard(){
        assertEquals(0, this.board.getZombies().size());
        Zombie zombie = new Walker(this.board.getCell(0, 0), this.board);
        this.board.addZombie(zombie);
        assertEquals(1, this.board.getZombies().size());
        this.board.removeZombie(zombie);
        assertEquals(0, this.board.getZombies().size());
    }

    @Test 
    public void testRemoveZombieWhenZombieNotInBoard(){
        assertEquals(0, this.board.getZombies().size());
        Zombie zombie = new Walker(this.board.getCell(0, 0), this.board);
        this.board.addZombie(zombie);
        assertEquals(1, this.board.getZombies().size());
        Zombie zombie2 = new Walker(this.board.getCell(0, 1), this.board);
        this.board.removeZombie(zombie2);
        assertEquals(1, this.board.getZombies().size());
    }

    @Test 
    public void testRemoveZombieWhenNotZombiesInBoard(){
        assertEquals(0, this.board.getZombies().size());
        Zombie zombie = new Walker(this.board.getCell(0, 0), this.board);
        this.board.removeZombie(zombie);
        assertEquals(0, this.board.getZombies().size());
    }

    @Test 
    public void testGetPlayersWhenPlayersInBoard(){
        assertEquals(1, this.board.getPlayers().size());
    }

    @Test 
    public void testGetPlayersWhenNoPlayersInBoard(){
        assertEquals(1, this.board.getPlayers().size());
        this.board.getPlayers().remove(0);
        assertEquals(0, this.board.getPlayers().size());
    }

    @Test 
    public void testAddPlayerWhenPlayerNotInBoard(){
        assertEquals(1, this.board.getPlayers().size());
        Player player = new Fighter(this.board.getCell(0, 0), this.board);
        this.board.addPlayer(player);
        assertEquals(2, this.board.getPlayers().size());
    }

    @Test 
    public void testGetPlayersWhenMultiplePlayersInBoard(){
        assertEquals(1, this.board.getPlayers().size());
        Player player = new Fighter(this.board.getCell(0, 0), this.board);
        this.board.addPlayer(player);
        assertEquals(2, this.board.getPlayers().size());
    }
}