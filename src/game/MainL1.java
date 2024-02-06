package game;
import java.util.Scanner;

import game.Boards.ClassicalBoard;
import game.Boards.TrainingBoard;

public class MainL1 {
    
    public static void main(String[] args){
        try {
            
            Board board = new ClassicalBoard(10,10);
            System.out.println(board);

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
