package game.Boards;

import src.game.Board;
import src.game.Celles.*;

public class TrainingBoard extends Board{

    /**
     * Build an empty board 5x5
     */
    public TrainingBoard() {
        super(5, 5);
        this.initBoard();
    }

    /**
     * Initialize the board with cells
     */
    public void initBoard(){
        for(int i = 0; i < this.cells.length; i++){
            for(int j = 0; j < this.cells[i].length; j++){
                if(i == 3 || j == 3) {
                    this.cells[i][j] = new StreetCell();
                }
                else {
                    this.cells[i][j] = new BuildingCell();
                }
            }
        }
    }

    /**
     * Board to string
     */
    public String toString(){
        String str = "";
        for(int i = 0; i < this.cells.length; i++){
            for(int j = 0; j < this.cells[i].length; j++){
                if (this.cells[i][j] instanceof BuildingCell) {
                    str += "B";
                }
                else if (this.cells[i][j] instanceof StreetCell) {
                    str += "S";
                }
                else {
                    str += " ";
                }
            }
            str += "\n ";
        }
        return str;
    }

}
