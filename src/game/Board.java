package game;


import java.util.Random;
import game.Celles.BuildingCell;
import game.Celles.StreetCell;
import game.Celles.BuildingCells.ContinentalCell;
import game.Celles.BuildingCells.DrugStoreCell;

public class Board {

    protected Cell[][] cells;
    private int width;
    private int height; 


    /**
     * Build an empty board
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                this.cells[x][y] = new BuildingCell();
            }
        }
        initBoard();
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

    public void fillBoard(int x1, int y1, int x2, int y2) {
        if ((x2 - x1) >= 4 && (y2 - y1) >= 4) {
            Random rand = new Random();
            int newX = rand.nextInt(x1+2 , x2-1);
            int newY = rand.nextInt(y1+2 , y2-1);
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

    public void initBoard(){
        fillBoard(0,0,height-1,width-1);
        Random rand = new Random();
        int randomX1 = rand.nextInt(width);
        int randomY1 = rand.nextInt(height);
        int randomX2 = rand.nextInt(width);
        int randomY2 = rand.nextInt(height);
        while (((randomX1 == randomX2) && (randomY1 == randomY2)) || ((this.cells[randomX1][randomY1] instanceof StreetCell) || (this.cells[randomX2][randomY2] instanceof StreetCell))){
            randomX2 = rand.nextInt(width);
            randomY2 = rand.nextInt(height);
        }
        this.cells[randomX1][randomY1] = new ContinentalCell(10);
        this.cells[randomX2][randomY2] = new DrugStoreCell();
    }


    /**
     * Print the board
     * @return the board
     */
    // j'ai tout fait avec des instanceof buildingCell : dans le cas ou on aurait un moyen de les différencier avec les streetCell,
    // on pourrait vérifier un attribut de cell ou autre
    public String toString(){
        //première ligne de "-"
        String str="-".repeat(width*3+width+1);        
        for (int i=0; i<height; i++){
            // on itére deux fois pour avoir les deux lignes de chaque cases
            for(int k=0;k<2;k++){
                //je commence par faire un \n et ajouter la première "porte" aka bordure du plateau
                str+="\n|";
                for (int j=0; j<width; j++){
                    //ajout des infos de la case
                    str+=this.cells[i][j].toString().substring(k*3,3+k*3);
                    // pour éviter les arrayindexOUB on ajoute une bordure si la case est la dernière
                    if(j==width-1){
                        str+="|";
                    }

                    else{ 
                        // sinon si la case est une S, on veut ne pas mettre de porte si la case suivante est une S aussi
                        if(!(this.cells[i][j] instanceof BuildingCell)){
                            if (this.cells[i][j+1] instanceof BuildingCell){
                                str+="|";
                            }
                            // cas j+1 = streetCell
                            else{
                                str+=" ";
                            }
                        }
                        //cas case!= Streetcell : il y a forcément une porte après
                        else{
                            str+="|";
                        }
                    }
                }
            }
            // ajout de la troisième ligne en dessous des cases qui représente les portes
            str+="\n-";
            //cas pour éviter les ArrayindexOUB : ligne de "-"
            if(i==height-1){
                str+="-".repeat(width*3+width);
            }
            // si on a une case streetCell et que celle d'en dessous l'est aussi alors on laisse des espaces et pas de bordures
            else{
                for (int j=0; j<width; j++){
                    if(!(this.cells[i][j] instanceof BuildingCell)){
                        if(!(this.cells[i+1][j] instanceof BuildingCell)){
                            str+="   -";
                        }
                        else{
                            str+="-".repeat(4);
                        } 
                    }
                    // cas où on est sur une case != Streetcell
                    else{
                        str+="-".repeat(4);
                    }
                }
                }    
        }
        return str;
    }



}

