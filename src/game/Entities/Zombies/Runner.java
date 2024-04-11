package game.Entities.Zombies;

import game.Cell;
import game.Entities.Zombie;
import game.Board;


public class Runner extends Zombie{

    public Runner(Cell cell, Board board){
        super(2, 1, board, 2, false, cell ,0);
    }
    
    public String toString(){
        return "Runner has "+this.getLifepoints()+" Lifepoints";
    }
}
