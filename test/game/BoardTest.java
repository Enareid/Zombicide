package game;

import org.junit.jupiter.api.*;

import game.Boards.*;
import game.Cells.BuildingCell;
import game.*;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {

    private Board board;

    @BeforeEach
    public void before(){
        this.board = new ClassicalBoard(5);
    }

    @Test
    public void testGetAndSetCell(){
        Cell cell = new BuildingCell();
        this.board.setCell(0, 0, cell);
        assertEquals(cell, this.board.getCell(0, 0));
    }
}