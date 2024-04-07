package game;

import game.Boards.ClassicalBoard;
import game.Cells.BuildingCell;
import game.Cells.StreetCell;
import game.Entities.*;
import game.Entities.Players.*;

import game.Entities.Zombies.Walker;
import game.Equipements.Items.InfraredGlasses;
import game.Equipements.Weapons.Axe;

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
                Board board = new ClassicalBoard(size, players);
                for (int x = 0; x < size; x++) {
                    for (int y = 0; y < size; y++) {
                        if (board.getCell(x, y) instanceof StreetCell) {
                            ((StreetCell) board.getCell(x, y)).spawnZombie();
                        }
                    }
                }
                Player p1 = new Fighter(10, null,board);
                Player p2 = new Healer(10, null,board);
                Player p3 = new Lucky(10, null,board);
                Player p4 = new Snooper(10, null,board);
                Equipement axe = new Axe();
                Equipement Fiole = new InfraredGlasses();
                p1.setCell(board.getCell(2, 2));
                p2.setCell(board.getCell(2, 2));
                p3.setCell(board.getCell(2, 2));
                p4.setCell(board.getCell(2, 2));
                board.addPlayer(p1);
                ((StreetCell) board.getCell(2, 2)).setPlayer(p1);

                for (int i = 0; i < 10; i++) {
                    System.out.println(board.toString());
                    p1.move();
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
