package game;

import game.Cells.BuildingCell;

public abstract class Board {

    /** The cells of the board */
    protected Cell[][] cells;
    /** The size of the board */
    protected int size;


    /**
     * Build an empty board
     * @param size the size of the board
     */
    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
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
     * Définit la cellule aux coordonnées spécifiées.
     *
     * @param x    La coordonnée x de la cellule.
     * @param y    La coordonnée y de la cellule.
     * @param cell La cellule à définir.
     */
    public void setCell(int x, int y, Cell cell) {
        this.cells[x][y] = cell;
    }

    protected void fillBoard(int x1, int y1, int x2, int y2) {
    }

    protected void initBoard(){
    }


    /**
     * Print the board
     * @return the board
     */
    // j'ai tout fait avec des instanceof buildingCell : dans le cas ou on aurait un moyen de les différencier avec les streetCell,
    // on pourrait vérifier un attribut de cell ou autre
    public String toString(){
        //première ligne de "-"
        String str="-".repeat(size*3+size+1);
        for (int i=0; i<size; i++){
            // on itére deux fois pour avoir les deux lignes de chaque cases
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
            if(i==size-1){
                str+="-".repeat(size*3+size);
            }
            // si on a une case streetCell et que celle d'en dessous l'est aussi alors on laisse des espaces et pas de bordures
            else{
                for (int j=0; j<size; j++){
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

