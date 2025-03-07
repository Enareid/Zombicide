package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.Boards.ClassicalBoard;
import game.Entities.Player;
import game.Entities.Zombie;
import game.Entities.Players.*;
import game.Equipements.Items.MasterKey;

public class Game {
    
    /** Board of the game */
    private Board board;
    /** True if the game is finished, false else */
    private boolean isOver = false;

    static MasterKey mk = new MasterKey();

    private int size;
    private int nbPlayers;

    /**
     * Builds a new Game.
     */
    public Game(int size, int nbPlayers) {
        this.size = size;
        this.nbPlayers = nbPlayers;
    }

    /**
     * Initializes the game.
     */
    public void init(){
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < nbPlayers ; i++){
            int Random = (int)(Math.random() * 4);
            switch(Random){
                case 0:
                    Player f = new Fighter(null, null);
                    players.add(f);
                    f.setEquipment(mk);
                    break;
                case 1:
                    Player l = new Lucky(null, null);
                    players.add(l);
                    l.setEquipment(mk);
                    break;
                case 2:
                    Player s = new Snooper(null, null);
                    players.add(s);
                    s.setEquipment(mk);
                    break;
                case 3:
                    Player h = new Healer(null, null);
                    players.add(h);
                    h.setEquipment(mk);
                    break;
        }
        }
        try{
            Board board = new ClassicalBoard(size, players);
            board.generateEquipement();
            this.board = board;
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    /**
     * Plays the game.
     */
    public void play(){
        int nbRounds = 1;
        this.init();
        while(!isOver){
            System.out.println("Round "+nbRounds + "\n");
            for (Player player : board.getPlayers()) {
                player.setActionPoints(player.getDynamiqueActionPoints());
            }
            for (int i = 0; i < nbZombieToSpawn(); i++) {
                board.spawnZombie();
            }
            for (Zombie zombie : board.getZombies()) {
                zombie.action();
            }
            if(board.getPlayers().size() != 0){
                for (Player player : board.getPlayers()) {
                    player.randomAction();
                }
            }
            System.out.println(board.toString() + "\n");
            if(board.getPlayers().size() == 0){
                isOver = true;
                System.out.println("Game Over ! Vous avez survécu "+nbRounds+" rounds");
            }
            if(board.getZombies().size() == 0){
                isOver = true;
                System.out.println("Victoire ! Vous avez gagné en "+nbRounds+" rounds");
            }
            nbRounds++;
        }
    }

    /**
     * Returns the number of zombies to spawn.
     * 
     * @return the number of zombies to spawn
     */
    public double nbZombieToSpawn(){
        int totalExperience = 0;
        for (Player player : board.getPlayers()) {
            totalExperience += player.getExpertiseLevel();
        }
        double averageExperience = totalExperience / board.getPlayers().size();
        if(averageExperience == 0){
            return 1;
        }
        return Math.ceil(averageExperience / 3);
    }
}
