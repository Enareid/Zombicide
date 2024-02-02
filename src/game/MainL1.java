package game;

import game.Boards.*;
import game.Celles.*;
import game.Entities.*;

public class MainL1 {
    
    public static void main(String[] args){
        try{
            Cell cell = new BuildingCell();
            cell.setZombie(new Zombie());
            /* cell.setPlayer(new Player()); */
            System.out.println(cell.toString());
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
