package src.game;

public class Board {
    protected Cell[][] cells;

    /**
     * Build an empty board
     */
    public Board(int width, int height) {
        this.cells = new Cell[width][height];
    }
}
