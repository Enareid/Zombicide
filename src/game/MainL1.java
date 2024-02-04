package game;
import java.util.Scanner;

import game.Boards.ClassicalBoard;

public class MainL1 {
    
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez la largeur du plateau : ");
            int width = scanner.nextInt();

            System.out.print("Entrez la hauteur du plateau : ");
            int height = scanner.nextInt();

            Board board = new ClassicalBoard(width, height);
            System.out.println(board);

            scanner.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
