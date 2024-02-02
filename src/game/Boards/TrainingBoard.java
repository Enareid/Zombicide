package game.Boards;
import game.Board;
import game.Celles.*;

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
                if(i == 2 || j == 2) {
                    this.cells[i][j] = new StreetCell();
                }
                else {
                    this.cells[i][j] = new BuildingCell();
                }
            }
        }
    }

}
