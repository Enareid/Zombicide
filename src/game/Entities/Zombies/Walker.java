package game.Entities.Zombies;
import game.Cell;
import game.Entities.Zombie;
import game.Board;

public class Walker extends Zombie{

    public Walker(Cell cell, Board board){
        super(1, 1, board, 1, false, cell,0);
    }

    public String toString(){
        return "Walker has "+this.getLifepoints()+" Lifepoints";
    }
    
}