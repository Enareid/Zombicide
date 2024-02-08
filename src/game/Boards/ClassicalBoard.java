package game.Boards;

import java.util.Random;

import game.Board;
import game.Cells.StreetCell;
import game.Cells.BuildingCells.ContinentalCell;
import game.Cells.BuildingCells.DrugStoreCell;

public class ClassicalBoard extends Board{

    /**
     * Build an empty board
     */
    public ClassicalBoard(int size) {
        super(size);
    }

    /**
     * Add StreetCell on the Board
     */
    public void fillBoard(int x1, int y1, int x2, int y2) {
        if ((x2 - x1) >= 4 && (y2 - y1) >= 4) {
            Random rand= new Random();
            // nombre random entre 0 et x2-x1-2 inclus + ajout de x1+2 = nombre entre x1+2 et x2-1 exclus
            int newX = rand.nextInt((x2-x1-3))+x1+2;
            int newY= rand.nextInt((y2-y1-3))+y1+2;
            for (int y = y1; y <= y2; y++) {
                this.cells[newX][y]=new StreetCell();
            }
            for (int x = x1; x <= x2; x++) {
                this.cells[x][newY]=new StreetCell();
            }
            // récursivité
            // carré haut-gauche
            fillBoard(x1, y1, newX - 1, newY - 1);
            // carré haut-droite
            fillBoard(x1, newY + 1, newX - 1, y2);
            // carré bas-gauche
            fillBoard(newX + 1, y1, x2, newY - 1);
            // carré bas-droite
            fillBoard(newX + 1, newY + 1, x2, y2);

        }
    }

    /**
     *
     */
    public void initBoard(){
        fillBoard(0,0,size-1,size-1);
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
        this.cells[randomX1][randomY1] = new ContinentalCell(10);
        this.cells[randomX2][randomY2] = new DrugStoreCell();
    }

}