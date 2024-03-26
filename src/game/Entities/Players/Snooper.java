package game.Entities.Players;

import game.Board;
import game.Cell;
import game.Entities.Player;

public class Snooper extends Player{

    public Snooper(int Lifepoints, Cell cell,Board board){
        super(Lifepoints,cell, board);
    }
    
    public String toString() {
        return "Snooper";
    }
}
