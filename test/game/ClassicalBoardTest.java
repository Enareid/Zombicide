package game;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import game.Boards.*;
import game.Cells.BuildingCell;
import game.Entities.Player;
import game.Entities.Players.Fighter;

import static org.junit.jupiter.api.Assertions.*;

public class ClassicalBoardTest extends BoardTest{

    protected Board createBoard(int size, List<Player> players){
        try {
            return new ClassicalBoard(size, players);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


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
    public void testGetAndSetCell(){
        Cell cell = new BuildingCell(0,0);
        this.board.setCell(0, 0, cell);
        assertEquals(cell, this.board.getCell(0, 0));
    }
    
}
