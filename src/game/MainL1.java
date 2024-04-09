package game;

import game.Boards.ClassicalBoard;
import game.Cells.BuildingCell;
import game.Cells.StreetCell;
import game.Entities.*;
import game.Entities.Players.*;

import game.Entities.Zombies.Walker;
import game.Equipements.Items.InfraredGlasses;
import game.Equipements.Weapons.Axe;
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
                Player p1 = new Fighter(10, null, null);
                players.add(p1);
                Board board = new ClassicalBoard(size, players);
                board.spawnZombie();
                Equipement axe = new Axe();
                Equipement Fiole = new InfraredGlasses();
                board.addPlayer(p1);
                MasterKey mk = new MasterKey();
                p1.setEquipment(mk);
                p1.setInHand(mk);
                
                System.out.println(board.toString());

                for (int i = 0; i < 10; i++) {
                    for (Zombie zombie : board.getZombies()) {
                        zombie.move();
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
