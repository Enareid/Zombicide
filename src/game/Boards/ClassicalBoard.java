package game.Boards;

import java.util.Random;

import game.Board;
import game.Cells.StreetCell;
import game.Cells.BuildingCells.ContinentalCell;
import game.Cells.BuildingCells.DrugStoreCell;

public class ClassicalBoard extends Board{

    /**
     * Build an empty board
     * @param size the size of the board
     */
    public ClassicalBoard(int size) throws IllegalArgumentException{
        super(size);
    }

    /**
     * Add StreetCell on the Board
     * @param x1 the x coordinate of the first corner
     * @param y1 the y coordinate of the first corner
     * @param x2 the x coordinate of the second corner
     * @param y2 the y coordinate of the second corner
     */
    public void fillBoard(int x1, int y1, int x2, int y2, boolean firstCall) {
        if ((x2 - x1) >= 4 && (y2 - y1) >= 4) {
            Random rand= new Random();
            // nombre random entre 0 et x2-x1-2 inclus + ajout de x1+2 = nombre entre x1+2 et x2-1 exclus
            int newX = rand.nextInt((x2-x1-3))+x1+2;
            int newY= rand.nextInt((y2-y1-3))+y1+2;
            for (int y = y1; y <= y2; y++) {
                this.cells[newX][y] = new StreetCell(newX,y);
            }
            for (int x = x1; x <= x2; x++) {
                this.cells[x][newY]=new StreetCell(x,newY);
            }
            if (firstCall){
                StreetCell cell1 = (StreetCell)this.cells[newX][y1];
                StreetCell cell2 = (StreetCell)this.cells[newX][y2];
                cell1.allowSpawn();
                cell2.allowSpawn();
            }
            // récursivité
            // carré haut-gauche
            fillBoard(x1, y1, newX - 1, newY - 1, false);
            // carré haut-droite
            fillBoard(x1, newY + 1, newX - 1, y2, false);
            // carré bas-gauche
            fillBoard(newX + 1, y1, x2, newY - 1, false);
            // carré bas-droite
            fillBoard(newX + 1, newY + 1, x2, y2, false);

        }
    }

    /**
     * Initialize the board with StreetCell, ContinentalCell and DrugStoreCell
     */
    public void initBoard(){
        fillBoard(0,0,size-1,size-1, true);
        Random rand = new Random();
        int randomX1 = rand.nextInt(size);
        int randomY1 = rand.nextInt(size);
        int randomX2 = rand.nextInt(size);
        int randomY2 = rand.nextInt(size);
        while (((randomX1 == randomX2) && (randomY1 == randomY2)) || ((this.cells[randomX1][randomY1] instanceof StreetCell) || (this.cells[randomX2][randomY2] instanceof StreetCell))){
            randomX1 = rand.nextInt(size);
            randomY1 = rand.nextInt(size);
            randomX2 = rand.nextInt(size);
            randomY2 = rand.nextInt(size);

        }
        this.cells[randomX1][randomY1] = new ContinentalCell(10,randomX1,randomY1);
        this.cells[randomX2][randomY2] = new DrugStoreCell(randomX2,randomY2);
    }

}