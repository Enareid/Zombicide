package game.Entities.Zombies;

import game.Cell;
import game.Entities.Zombie;
import game.Board;

public class Walker extends Zombie{

    public Walker(Cell cell, Board board){
        super(1, 1, board, 1, false, cell);
    }
    
}