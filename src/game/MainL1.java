package game;

import game.Boards.ClassicalBoard;
import game.Entities.*;
import game.Entities.Players.*;

import game.Equipements.Items.InfraredGlasses;
import game.Equipements.Weapons.*;
import game.Equipements.Items.MasterKey;

import java.util.*;

public class MainL1 {

    public static void main(String[] args){
        int nbEssais = 0;
        while(nbEssais < 4){
            try {
                List<Player> players = new ArrayList<Player>();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Entrez la taille du plateau:");
                int size = scanner.nextInt();
                nbEssais++;
                Player p1 = new Fighter(null, null);
                players.add(p1);
                Board board = new ClassicalBoard(size, players);
                board.spawnZombie();
                Equipement IG = new InfraredGlasses();
                Equipement axe = new Axe();
                Equipement gun = new Gun();
                Equipement rifle = new Rifle();
                Equipement Chainsaw = new Chainsaw();
                Equipement Crowbar = new Crowbar();
                Equipement Fiole = new InfraredGlasses();
                MasterKey mk = new MasterKey();
                p1.setEquipment(gun);
                p1.setInHand(gun);
                
                System.out.println(board.toString());

                for (int i = 0; i < 10; i++) {
                    for (Zombie zombie : board.getZombies()) {
                        zombie.action();
                        System.out.println(p1.getLifepoints());
                    }
                    p1.action();            
                }
                scanner.close();
                break;
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
