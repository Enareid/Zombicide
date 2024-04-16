package game.Equipements.Items;

import java.util.ArrayList;
import java.util.List;

import game.Board;
import game.Cell;
import game.Equipement;
import game.Boards.ClassicalBoard;
import game.Entities.Player;

/** The InfraredGlasses class extends Equipement class */
public class InfraredGlasses extends Equipement{

    /**
     * Builds a new InfraredGlasses.
     */
    public InfraredGlasses(){
        super();
    }

    /**
     * Uses the InfraredGlasses.
     * 
     * @param player the player using the InfraredGlasses
     * @throws Exception 
     */
    public void use(Player player) throws Exception{  
        List<Player> players = new ArrayList<Player>();
		Board board = new ClassicalBoard(player.getBoard().getSize(), players);
		board.setCells(player.getBoard().createFakeboard());
		int posx=player.getCell().getCoord()[0];
		int posy=player.getCell().getCoord()[1];
		for(int x=posx-1;x<posx+2;x++){
			for(int y=posy-1;y<posy+2;y++){
				if (x>=0 && x<board.getSize() && y>=0 && y<board.getSize()){
					board.setCell(x, y, player.getBoard().getCell(x, y));
					Cell cell = board.getCell(x, y);
					cell.openAllDoor();
				}
			}
		}
		System.out.println(board.toString()); 
    }

    /**
     * Returns the string representation of the InfraredGlasses.
     * @return the string representation of the InfraredGlasses.
     */
    public String toString() {
        return "InfraredGlasses";
    }
    
}
