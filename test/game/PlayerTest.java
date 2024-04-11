package game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import game.Boards.ClassicalBoard;
import game.Cells.BuildingCell;
import game.Entities.Player;
import game.Entities.Players.*;
public class PlayerTest {

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

    

}