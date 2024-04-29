package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.Boards.ClassicalBoard;
import game.Entities.Player;
import game.Entities.Zombie;
import game.Entities.Players.Fighter;

public class Game {
    
    private Board board;
    private boolean isOver = false;

    public Game() {
    }

    public void init(){
        List<Player> players = new ArrayList<Player>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez la taille du plateau:");
        int size = scanner.nextInt();
        Player p1 = new Fighter(null, null);
        players.add(p1);
        try{
            Board board = new ClassicalBoard(size, players);
            this.board = board;
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void play(){
        this.init();
        board.spawnZombie();
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
