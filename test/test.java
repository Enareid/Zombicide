import leBoard.Board;
import leBoard.Player;
import leBoard.Room;

public class test {

    public static void main(String[] args) {

        Board board = new Board(10, 10);

        Player player = new Player(board, 5, 5);
        player.move("RIGHT");
    


    }

}