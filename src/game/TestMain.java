package src.game;

public class TestMain { 
    public static void main(String[] args) {
        Board board = new Board(5, 5);
        board.initBoard();
        System.out.println(board);
    }
    
}
