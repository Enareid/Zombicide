package game.Entities.Zombies;
import game.Board;
import game.Cell;


import game.Entities.Zombie;

public class Abomination extends Zombie {
    
    public Abomination(Cell cell, Board board){
        super(6, 3, board, 1, true, cell,1);
    }

    public String toString(){
        return "Abomination has "+this.getLifepoints()+" Lifepoints";
    }
    
}
