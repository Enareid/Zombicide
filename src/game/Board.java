package game;

import game.Cells.BuildingCell;
import game.Cells.StreetCell;

import java.util.*;
import game.Entities.*;

public abstract class Board {

    /** The cells of the board */
    protected Cell[][] cells;
    /** The size of the board */
    protected int size;
    /** The Player in the board */
    protected List<Player> players;


    /**
     * Build an empty board
     * @param size the size of the board
     * @throws Exception 
     */
    public Board(int size, List<Player> players) throws Exception{
        if (size < 5) {
            throw new IllegalArgumentException("The size of the board must be at least 5");
        }
        this.size = size;
        this.cells = new Cell[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                this.cells[x][y] = new BuildingCell(x,y);
            }
        }
        this.players = players;
        initBoard(players);
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
     * Définit la cellule aux coordonnées spécifiées.
     *
     * @param x    La coordonnée x de la cellule.
     * @param y    La coordonnée y de la cellule.
     * @param cell La cellule à définir.
     */
    public void setCell(int x, int y, Cell cell) {
        this.cells[x][y] = cell;
    }

    protected void fillBoard(int x1, int y1, int x2, int y2, boolean firstCall, List<Player> players) throws Exception {
    }

    protected void initBoard(List<Player> players) throws Exception {
    }


/**
     * Print the board
     * @return the board
     */
    // j'ai tout fait avec des instanceof buildingCell : dans le cas ou on aurait un moyen de les différencier avec les streetCell,
    // on pourrait vérifier un attribut de cell ou autre
    public String toString(){
        //première ligne de "·---·"
        String str="·---".repeat(size);
        str += "·";
        for (int i=0; i<size; i++){
            // on itére deux fois pour avoir les deux lignes de chaque cases,
            // la ligne des info de la case & zombie(s)
            // et la ligne des survivants
            for(int k=0;k<2;k++){
                //je commence par faire un \n et ajouter la première "porte" aka bordure du plateau
                str+="\n|";
                for (int j=0; j<size; j++){
                    //ajout des infos de la case
                    str+=this.cells[i][j].toString().substring(k*3,3+k*3);
                    // pour éviter les arrayindexOUB on ajoute une bordure si la case est la dernière
                    if(j==size-1){
                        str+="|";
                    }

                    else{
                        // sinon si la case est une S, on veut ne pas mettre de porte si la case suivante est une S aussi
                        // on met une porte lorsque les deux portes associées du droite et gauche sont intactes
                        if ((this.cells[i][j].isPorteIntacte(Direction.RIGHT)) && (this.cells[i][j+1].isPorteIntacte(Direction.LEFT))
                        && !((this.cells[i][j] instanceof StreetCell) && (this.cells[i][j+1] instanceof StreetCell))){                   
                                str+="|";
                            }
                            // cas j = streetCell && j+1 = streetCell ou porte cassé
                            else{
                                str+=" ";
                            }
                        }
                    }
                }
            
            // ajout de la troisième ligne en dessous des cases qui représente les portes
            str+="\n";
            //cas pour éviter les ArrayindexOUB : ligne de "·---·"
            if(i==size-1){
                str+="·---".repeat(size);
                str+="·";
            }
            // si on a une case streetCell et que celle d'en dessous l'est aussi alors on laisse des espaces et pas de bordures
            else{
                for (int j=0; j<size; j++){
                    // on met une porte si les deux portes associées du bas et du haut sont intactes
                    if((this.cells[i][j].isPorteIntacte(Direction.DOWN)) && (this.cells[i+1][j].isPorteIntacte(Direction.UP))
                    && !((this.cells[i][j] instanceof StreetCell) && (this.cells[i+1][j] instanceof StreetCell))){
                            str+="·---";
                        }
                        // cas i = streetCell && i+1 = streetCell ou porte cassé
                        else{
                            str+="·   ";
                        }
                }
                str+="·";
                }
        }
        return str;
    }


    public void moveNorth(Player player){
        Cell cell = player.getCell();
        int x = cell.getcoord()[0];
        int y = cell.getcoord()[1];
        if (x > 0){
            if (this.cells[x][y].isPorteIntacte(Direction.UP) && this.cells[x-1][y].isPorteIntacte(Direction.DOWN)){
                try {
                    this.cells[x][y].removePlayer(player);
                    this.cells[x-1][y].setPlayer(player);
                    player.setCell(this.cells[x-1][y]);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void moveSouth(Player player){
        Cell cell = player.getCell();
        int x = cell.getcoord()[0];
        int y = cell.getcoord()[1];
        if (x < this.size-1){
            if (this.cells[x][y].isPorteIntacte(Direction.DOWN) && this.cells[x+1][y].isPorteIntacte(Direction.UP)){
                try {
                    this.cells[x][y].removePlayer(player);
                    this.cells[x+1][y].setPlayer(player);
                    player.setCell(this.cells[x+1][y]);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void moveEast(Player player){
        Cell cell = player.getCell();
        int x = cell.getcoord()[0];
        int y = cell.getcoord()[1];
        if (y < this.size-1){
            if (this.cells[x][y].isPorteIntacte(Direction.RIGHT) && this.cells[x][y+1].isPorteIntacte(Direction.LEFT)){
                try {
                    this.cells[x][y].removePlayer(player);
                    this.cells[x][y+1].setPlayer(player);
                    player.setCell(this.cells[x][y+1]);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void moveWest(Player player){
        Cell cell = player.getCell();
        int x = cell.getcoord()[0];
        int y = cell.getcoord()[1];
        if (y > 0){
            if (this.cells[x][y].isPorteIntacte(Direction.LEFT) && this.cells[x][y-1].isPorteIntacte(Direction.RIGHT)){
                try {
                    this.cells[x][y].removePlayer(player);
                    this.cells[x][y-1].setPlayer(player);
                    player.setCell(this.cells[x][y-1]);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }   

}

