package game.Boards;

import java.util.Random;
import java.lang.Math;

import game.Board;
import game.Celles.StreetCell;
import game.Celles.BuildingCells.ContinentalCell;
import game.Celles.BuildingCells.DrugStoreCell;

public class ClassicalBoard extends Board {
    
    /**
     * Build an empty board
     */
    public ClassicalBoard(int width, int height) {
        super(width, height);
    }

    /**
     * Add StreetCell on the Board
     */
    public void fillBoard(int x1, int y1, int x2, int y2) {
        if ((x2 - x1) >= 4 && (y2 - y1) >= 4) {
            Random rand = new Random();
            int newX = rand.nextInt(x2 - x1 - 2) + x1 + 1;
            int newY = rand.nextInt(y2 - y1 - 2) + y1 + 1;
            for (int y = y1; y <= y2; y++) {
                this.cells[newX][y] = new StreetCell();
            }
            for (int x = x1; x <= x2; x++) {
                this.cells[x][newY] = new StreetCell();
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
     * Initialize the board with cells
     */
    public void initBoard(){
        fillBoard(0, 0, width - 1, height - 1); // Utilisez width et height pour les dimensions du tableau
        Random rand = new Random();
        int randomX1 = rand.nextInt(width);
        int randomY1 = rand.nextInt(height);
        int randomX2 = rand.nextInt(width);
        int randomY2 = rand.nextInt(height);
        while (this.cells[randomX1][randomY1] instanceof StreetCell || this.cells[randomX2][randomY2] instanceof StreetCell || (randomX1 == randomX2 && randomY1 == randomY2)){
            randomX1 = rand.nextInt(width);
            randomY1 = rand.nextInt(height);
            randomX2 = rand.nextInt(width);
            randomY2 = rand.nextInt(height);
        }
        this.cells[randomX1][randomY1] = new ContinentalCell(10);
        this.cells[randomX2][randomY2] = new DrugStoreCell();
    }    
}