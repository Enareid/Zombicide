package game.Entities.Zombies;

import game.Cell;
import game.Entities.Zombie;

public class Walker extends Zombie{

    private int Lifepoints;
    private Cell cell;

    public Walker(int Lifepoints, Cell cell){
        super(Lifepoints,cell);
    }
    
}
