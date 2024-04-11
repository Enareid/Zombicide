package game.Entities.Zombies;
import game.Cell;
import game.Board;
import game.Entities.Zombie;

public class Broom extends Zombie{
    
    public Broom(Cell cell, Board board, String name){
        super(4, 2, board, 1, true, cell, name);
    }
}
