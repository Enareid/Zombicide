package game.Boards;

import java.util.*;

import game.Board;
import game.Cells.StreetCell;
import game.Cells.BuildingCells.ContinentalCell;
import game.Cells.BuildingCells.DrugStoreCell;
import game.Entities.*;

public class ClassicalBoard extends Board{

    /**
     * Build an empty board
     * @param size the size of the board
     * @throws Exception 
     */
    public ClassicalBoard(int size, List<Player> players) throws Exception{
        super(size, players);
    }

    /**
     * Add StreetCell on the Board
     * @param x1 the x coordinate of the first corner
     * @param y1 the y coordinate of the first corner
     * @param x2 the x coordinate of the second corner
     * @param y2 the y coordinate of the second corner
     * @throws Exception 
     */
    public void fillBoard(int x1, int y1, int x2, int y2, boolean firstCall, List<Player> players) throws Exception {
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
            // Ajout des zombie et des joueurs sur le borad
            if (firstCall){
                ((StreetCell) this.cells[newX][y1]).allowSpawn();
                ((StreetCell) this.cells[newX][y2]).allowSpawn();
                ((StreetCell) this.cells[x1][newY]).allowSpawn();
                ((StreetCell) this.cells[x2][newY]).allowSpawn();
                // prendre la case au centre des streetCell et y rajouter les joueurs
                for(int i = 0; i < players.size(); i++){
                    ((StreetCell) this.cells[newX][newY]).setPlayer(players.get(i));
                }
            }
            // récursivité
            // carré haut-gauche
            fillBoard(x1, y1, newX - 1, newY - 1, false, players);
            // carré haut-droite
            fillBoard(x1, newY + 1, newX - 1, y2, false, players);
            // carré bas-gauche
            fillBoard(newX + 1, y1, x2, newY - 1, false, players);
            // carré bas-droite
            fillBoard(newX + 1, newY + 1, x2, y2, false, players);

        }
    }

    /**
     * Initialize the board with StreetCell, ContinentalCell and DrugStoreCell
     * @throws Exception 
     */
    public void initBoard(List<Player> players) throws Exception{
        fillBoard(0,0,size-1,size-1, true, players);
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