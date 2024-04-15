package game.Equipements.Items;

import game.Equipement;
import game.Direction;
import game.Entities.Player;
import game.Cell;

/** The MasterKey class extends Equipement class */
public class MasterKey extends Equipement{

    /**
     * Builds a new MasterKey.
     */
    public MasterKey(){
        super();
        this.canOpenDoor = true;
    }

    /**
     * Unlocks the door in the direction of the player give.
     * 
     * @param player the player using the MasterKey
     * @param direction the direction of the MasterKey
     */
    public void use(Player player, Direction direction){
        Cell cell = player.getCell();
        cell.getDoor().get(direction).unlock();
        if (direction == Direction.NORTH){
            Cell cell2 = player.getBoard().getCell(cell.getCoord()[0]-1,cell.getCoord()[1]);
            cell2.getDoor().get(Direction.SOUTH).unlock();
        }
        if (direction == Direction.SOUTH){
            Cell cell2 = player.getBoard().getCell(cell.getCoord()[0]+1,cell.getCoord()[1]);
            cell2.getDoor().get(Direction.NORTH).unlock();
        }
        if (direction == Direction.EAST){
            Cell cell2 = player.getBoard().getCell(cell.getCoord()[0],cell.getCoord()[1]+1);
            cell2.getDoor().get(Direction.WEST).unlock();
        }
        if (direction == Direction.WEST){
            Cell cell2 = player.getBoard().getCell(cell.getCoord()[0],cell.getCoord()[1]-1);
            cell2.getDoor().get(Direction.EAST).unlock();
        }
    }

    /**
     * Returns the string representation of the MasterKey.
     * @return the string representation of the MasterKey.
     */
    public String toString() {
        return "MasterKey";
    }

}
