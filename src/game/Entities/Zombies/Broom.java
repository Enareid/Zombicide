package game.Entities.Zombies;
import game.Cell;
import game.Board;
import game.Entities.Zombie;

public class Broom extends Zombie{
    
    public Broom(Cell cell, Board board){
        super(4, 2, board, 1, true, cell);
    }
}
