package game.Entities.Zombies;

import game.Cell;
import game.Entities.Zombie;
import game.Board;


public class Runner extends Zombie{

    public Runner(Cell cell, Board board, String name,int resistance=0){
        super(2, 1, board, 2, false, cell ,name,resistance);
    }
    
}
