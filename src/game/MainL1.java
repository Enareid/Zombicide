package game;

import game.Boards.ClassicalBoard;
import java.util.Scanner;
import game.Cells.StreetCell;

public class MainL1 {

    public static void main(String[] args){
        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Entrez la taille du plateau:");
                int size = scanner.nextInt();
                Board board = new ClassicalBoard(size);
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
