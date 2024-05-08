package game;

public class MainL1 {

    public static void main(String[] args){
        try {
            GameBis game = new GameBis();
            game.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
