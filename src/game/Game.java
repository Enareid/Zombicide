package game;

import game.Entities.Player;
import game.Entities.Zombie;

public class Game {
    
    private Board board;
    private boolean isOver = false;

    public Game(Board board) {
        this.board = board;
    }

    public void play(){
        while(!isOver){
            for (Zombie zombie : board.getZombies()) {
                zombie.action();
            }
            for (Player player : board.getPlayers()) {
                player.action();
            }
            
        }
    }
}
