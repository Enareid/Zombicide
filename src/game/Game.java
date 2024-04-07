package game;

import java.util.*;
import game.Entities.*;


public class Game {

    protected Board board;
    protected List<Player> players;
    protected List<Zombie> zombies;
    
    public Game(Board board){
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void oneTurn(){
        for (Zombie zombie : zombies) {
            break;
        }
    }

}
