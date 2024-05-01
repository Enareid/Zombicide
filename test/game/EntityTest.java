package game;
import java.util.*;
import org.junit.jupiter.api.*;
import game.Boards.*;
import game.Entities.Player;
import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {

    private Entity entity;
    private Board board;
    private Cell cell;

    @BeforeEach
    public void before() throws Exception {
        List<Player> players = new ArrayList<>();
        this.board = new ClassicalBoard(5,players);
        this.cell = new Cell(0, 0);
        entity = new Entity(10, this.cell, this.board, 5);
    }

    @Test 
    public void testGetCellWhenIsTheRightCell() {
        assertEquals(this.cell, entity.getCell());
    }

    @Test 
    public void testGetCellWhenIsNotTheRightCell() {
        Cell cell2 = new Cell(1, 1);
        assertNotEquals(cell2, entity.getCell());
    }

    @Test 
    public void testSetCellWithNewCell() {
        assertEquals(this.cell, entity.getCell());
        Cell cell2 = new Cell(1, 1);
        entity.setCell(cell2);
        assertEquals(cell2, entity.getCell());
    }

    @Test 
    public void testSetCellWithSameCell() {
        assertEquals(this.cell, entity.getCell());
        entity.setCell(this.cell);
        assertEquals(this.cell, entity.getCell());
    }

    @Test
    public void testGetLifepointsWhenIsTheRightLifePoints() {
        assertEquals(10, entity.getLifepoints());
    }

    @Test 
    public void testGetLifepointsWhenIsNotTheRightLifePoints() {
        assertNotEquals(5, entity.getLifepoints());
    }

    @Test
    public void testSetLifepoints() {
        assertEquals(10, entity.getLifepoints());
        entity.setLifepoints(5);
        assertEquals(5, entity.getLifepoints());
    }

    @Test 
    public void testGetActionPointsWhenIsTheRightActionPoints() {
        assertEquals(5, entity.getActionPoints());
    }

    @Test
    public void testGetActionPointsWhenIsNotTheRightActionPoints() {
        assertNotEquals(10, entity.getActionPoints());
    }

    @Test
    public void testSetActionPoints() {
        assertEquals(5, entity.getActionPoints());
        entity.setActionPoints(10);
        assertEquals(10, entity.getActionPoints());
    }

    @Test 
    public void testGetBoardWhenIsTheRightBoard() {
        assertEquals(this.board, entity.getBoard());
    }

    @Test
    public void testGetBoardWhenIsNotTheRightBoard() throws Exception{
        List<Player> players = new ArrayList<>();
        Board board2 = new ClassicalBoard(5,players);
        assertNotEquals(board2, entity.getBoard());
    }

    @Test
    public void testSetBoardWithNewBoard() throws Exception{
        assertEquals(this.board, entity.getBoard());
        List<Player> players = new ArrayList<>();
        Board board2 = new ClassicalBoard(5,players);
        entity.setBoard(board2);
        assertEquals(board2, entity.getBoard());
    }

    @Test
    public void testSetBoardWithSameBoard() {
        assertEquals(this.board, entity.getBoard());
        entity.setBoard(this.board);
        assertEquals(this.board, entity.getBoard());
    }

    @Test
    public void testIsDeadWhenEntityIsDead() {
        entity.setLifepoints(0);
        assertTrue(entity.isDead());
    }

    @Test
    public void testIsDeadWhenEntityIsNotDead() {
        assertFalse(entity.isDead());
    }

    @Test 
    public void testIsDeadWithNegativeLifePoints() {
        entity.setLifepoints(-1);
        assertTrue(entity.isDead());
    }

    @Test 
    public void testCalculateDistanceWithTwoDifferentCellsOnSameLine() {
        Cell cell2 = new Cell(0, 1);
        assertEquals(1, entity.calculateDistance(cell2, this.cell));
    }

    @Test
    public void testCalculateDistanceWithTwoDifferentCellsOnSameColumn() {
        Cell cell2 = new Cell(1, 0);
        assertEquals(1, entity.calculateDistance(cell2, this.cell));
    }

    @Test
    public void testCalculateDistanceWithTwoDifferentCellsOnDiagonal() {
        Cell cell2 = new Cell(1, 1);
        assertEquals(Math.sqrt(2), entity.calculateDistance(cell2, this.cell));
    }

    @Test
    public void testCalculateDistanceWithTwoDifferentCellsOnDifferentLineAndColumn() {
        Cell cell2 = new Cell(2, 3);
        assertEquals(Math.sqrt(13), entity.calculateDistance(cell2, this.cell));
    }

    @Test
    public void testCalculateDistanceWithTwoSameCells() {
        assertEquals(0, entity.calculateDistance(this.cell, this.cell));
    }
}