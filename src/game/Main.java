package game;

public class Main {

    public static void main(String[] args){
        try {
            int size = Integer.parseInt(args[0]);
            int nbPlayers = Integer.parseInt(args[1]);
            Game game = new Game(size, nbPlayers);
            game.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
