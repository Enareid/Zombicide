package game;

import game.Boards.ClassicalBoard;
import java.util.Scanner;
import game.Cells.StreetCell;
import game.Entities.*;
import game.Entities.Players.Fighter;
import java.util.*;

public class MainL1 {

    public static void main(String[] args){
        while(true){
            try {
                List<Player> players = new ArrayList<Player>();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Entrez la taille du plateau:");
                int size = scanner.nextInt();
                Player player = new Fighter(10, null, 0, 0);
                players.add(player);
                Board board = new ClassicalBoard(size, players);
                for (int x = 0; x < size; x++) {
                    for (int y = 0; y < size; y++) {
                        if (board.getCell(x, y) instanceof StreetCell) {
                            ((StreetCell) board.getCell(x, y)).spawnZombie();
                        }
                    }
                }
                System.out.println(board);
                scanner.close();
                break;
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
