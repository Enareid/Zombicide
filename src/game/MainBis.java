package game;

public class MainBis {

    public static void main(String[] args){
        try {
            GameBis game = new GameBis();
            game.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
