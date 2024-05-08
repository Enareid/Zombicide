package game;

public class Main {

    public static void main(String[] args){
        try {
            Game game = new Game();
            int size = Integer.parseInt(args[0]);
            int nbPlayers = Integer.parseInt(args[1]);
            game.play(size, nbPlayers);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
