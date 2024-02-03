package game;

import game.Celles.*;
import game.Entities.*;

public class MainL1 {
    
    public static void main(String[] args){
        try{
            Cell cell = new BuildingCell();
            cell.setZombie(new Zombie());
            cell.setPlayer(new Player());
            System.out.println(cell.toString());
            Board board=new Board(10,10);
            board.getCell(5, 5).setPlayer(null);
            board.getCell(5, 5).setZombie(null);
            board.getCell(4, 5).setPlayer(null);
            System.out.println(board);

        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
