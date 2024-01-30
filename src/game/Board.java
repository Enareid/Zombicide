package src.game;

import src.game.Celles.StreetCell;

public class Board {

    protected Cell[][] cells;
    private int width;
    private int height;
    private static final char street='|';
    private static final char building='B';

    /**
     * Build an empty board
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.cells[x][y] = new Cell();
            }
        }
    }

    public Cell[][] decoup(Cell[][] board,int x1, int x2,int y1, int y2){
        int length=x2-x1;
        int width=y2-y1;
        if (width<5 || length<5){
            
            return board;
        }
        else{
            int random1 = (int)(Math.random()*length);
            int random2 = (int)(Math.random()*width);
            for(int j=y1;j<width;j++){
                board[random1][j]=new StreetCell();
            }
            for(int i=x1;i<length;i++){
                this.cells[i][random2]=new StreetCell();
            }
            decoup(board, x1, x2, y1, y2);
            
        }
        return board;
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

}

