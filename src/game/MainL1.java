package game;

public class MainL1 {

    public static void main(String[] args){
        try {
            Game game = new Game();
            game.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
