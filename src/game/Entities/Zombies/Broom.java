package game.Entities.Zombies;
import game.Cell;
import game.Entities.Zombie;

public class Broom extends Zombie{
    
    public Broom(int Lifepoints, Cell cell){
        super(4, 2, 1, true, cell);
    }
}
