package src.game;

public class Board {
    protected Cell[][] cells;

    /**
     * Build an empty board
     */
    public Board(int width, int height) {
        this.cells = new Cell[width][height];
    }

    /**
     * Returns the cell at the given coordinates. 
     * @param x The x coordinate of the cell.
     * @param y The y coordinate of the cell.
     * @return The cell at the given coordinates.
     */
    public Cell getCell(int x, int y) {
        return this.cells[x][y];
    }

    /**
     * Sets the cell at the given coordinates.
     */
    public void setCell(int x, int y, Cell cell) {
        this.cells[x][y] = cell;
    }

    /**
     * Initialize the board with some rules and random cells.
     */
    public void initBoard(){
        // TODO
    }
}
