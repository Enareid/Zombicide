package game;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import game.Board;
import game.Boards.*;
import game.Cells.BuildingCell;
import game.Entities.Player;
import game.Entities.Players.*;
import game.Equipements.Weapons.*;

import java.util.*;

public class PlayerTest {

    private Board board;

    @BeforeEach
    public void before() throws Exception{
        List<Player> players = new ArrayList<Player>();
        Player player = new Fighter(5,null,null);
        players.add(player);
        this.board = new ClassicalBoard(5,players);
    }

    @Test
    public void testPlayerInitialization() throws Exception {
        Cell cell = new BuildingCell(10, 5); 
        Player player = new Fighter(5, cell,null);
        List<Player> players = new ArrayList<Player>();
        players.add(player);
        Board board= new ClassicalBoard(5, players);
        player.setBoard(board);

        assertEquals(5, player.getLifeLevel());
        assertEquals(0, player.getExpertiseLevel()); 
        assertEquals(3, player.getActionPoints());
        assertEquals(0, player.getEquipments().size());
        
    }

    @test
    public void lookaroundtest() throws Exception{
        Cell cell = new BuildingCell(10, 5); 
        Player player = new Fighter(5, cell,null);
        List<Player> players = new ArrayList<Player>();
        players.add(player);
        Board board= new ClassicalBoard(5, players);
        player.setBoard(board);
        board.getCell(0, 0).setPlayer(player);
        board.toString();
        assertEquals("You are in a building cell", player.lookaround());
    }

    @test
    public void canAttackZombieTestWhenTrue(){
        Equipement axe = new Axe();
        this.board.getPlayers().get(0).setEquipment(axe);
        this.board.getPlayers().get(0).setInHand(axe);
        for (Zombie zombie : this.board.getZombies()) {
            assertFalse(this.board.getPlayers().get(0).canAttackZombie(zombie));            
        }

        
    }


}