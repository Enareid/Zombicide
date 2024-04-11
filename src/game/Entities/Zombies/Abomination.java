package game.Entities.Zombies;
import game.Board;
import game.Cell;


import game.Entities.Zombie;

public class Abomination extends Zombie {
    
    public Abomination(Cell cell, Board board, String name){
        super(6, 3, board, 1, true, cell, name);
    }
    
}
