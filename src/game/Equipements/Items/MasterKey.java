package game.Equipements.Items;

import game.Door;
import game.Equipement;
import game.Direction;
import game.Entities.Player;
import java.util.*;
import game.Cell;

public class MasterKey extends Equipement{

    public MasterKey(){
        super();
        this.canOpenDoor = true;
    }

    public void use(Player player, Direction direction){
        Cell cell = player.getCell();
        cell.getdoor().get(direction).unlock();
        if (direction == Direction.NORTH){
            Cell cell2 = player.getBoard().getCell(cell.getcoord()[0]-1,cell.getcoord()[1]);
            cell2.getdoor().get(Direction.SOUTH).unlock();
        }
        if (direction == Direction.SOUTH){
            Cell cell2 = player.getBoard().getCell(cell.getcoord()[0]+1,cell.getcoord()[1]);
            cell2.getdoor().get(Direction.NORTH).unlock();
        }
        if (direction == Direction.EAST){
            Cell cell2 = player.getBoard().getCell(cell.getcoord()[0],cell.getcoord()[1]+1);
            cell2.getdoor().get(Direction.WEST).unlock();
        }
        if (direction == Direction.WEST){
            Cell cell2 = player.getBoard().getCell(cell.getcoord()[0],cell.getcoord()[1]-1);
            cell2.getdoor().get(Direction.EAST).unlock();
        }
    }

    public String toString() {
        return "MasterKey";
    }

}
