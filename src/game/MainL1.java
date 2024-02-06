package game;

import game.Boards.ClassicalBoard;

public class MainL1 {
    
    public static void main(String[] args){
        try {
            
            Board board = new ClassicalBoard(10);
            System.out.println(board);

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
