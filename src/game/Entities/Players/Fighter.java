package game.Entities.Players;

import game.Board;
import game.Cell;
import game.Entities.Player;

public class Fighter extends Player{
    
    public Fighter(int Lifepoints, Cell cell,Board board){
        super(Lifepoints,cell,board);
    }

    public String toString() {
        return "Fighter";
    }

    
}
