package game;

import game.Celles.BuildingCell;
import game.Celles.StreetCell;

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

    /**
     * Print the board
     * @return the board
     */
    // j'ai tout fait avec des instanceof buildingCell : dans le cas ou on aurait un moyen de les différencier avec les streetCell, on pourrait vérifier un attribut de cell ou autre
    public String toString(){
        //première ligne de "-"
        String str="-".repeat(height*3+height+1);        
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
                str+="-".repeat(height*3+height);
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
                    // cas ou on est sur une case != Streetcell
                    else{
                        str+="-".repeat(4);
                    }
                }
                }    
        }
        return str;
    }



}

