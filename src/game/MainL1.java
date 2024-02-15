package game;

import game.Boards.ClassicalBoard;
import java.util.Scanner;

public class MainL1 {

    public static void main(String[] args){
        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Entrez la taille du plateau:");
                int size = scanner.nextInt();
                Board board = new ClassicalBoard(size);
                System.out.println(board);
                scanner.close();
                break;
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}