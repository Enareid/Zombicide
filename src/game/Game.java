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

    /**
     * Builds a new Game.
     */
    public Game() {
    }

    /**
     * Initializes the game.
     */
    public void init(){
        List<Player> players = new ArrayList<Player>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez la taille du plateau : ");
        int size = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Entrez le nombre de joueurs : ");
        int nbPlayers = scanner.nextInt();
        for (int i = 0; i < nbPlayers; i ++){
            scanner.nextLine();
            System.out.println("Choissisez votre classe : FIGHTER, LUCKY, SNOOPER, HEALER");
            String classe = scanner.nextLine();
            switch(classe){
                case "FIGHTER":
                    Player f = new Fighter(null, null);
                    players.add(f);
                    f.setEquipment(mk);
                    break;
                case "LUCKY":
                    Player l = new Lucky(null, null);
                    players.add(l);
                    l.setEquipment(mk);
                    break;
                case "SNOOPER":
                    Player s = new Snooper(null, null);
                    players.add(s);
                    s.setEquipment(mk);
                    break;
                case "HEALER":
                    Player h = new Healer(null, null);
                    players.add(h);
                    h.setEquipment(mk);
                    break;
                default:
                    System.out.println("Classe invalide");
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
        }
    }

    /**
     * Plays the game.
     */
    public void play(){
        int nbRounds = 1;
        this.init();
        while(!isOver){
            System.out.println("Round "+nbRounds);
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
                isOver = false;
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
