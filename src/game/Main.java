package game;

public class Main {

    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("Usage: java -jar game.jar <size> <nbPlayers>");
            System.exit(1);
        }
        if (Integer.parseInt(args[0]) < 5) {
            System.out.println("Size must be at least 5");
            System.exit(1);
        }
        if (Integer.parseInt(args[1]) < 1) {
            System.out.println("Number of players must be at least 1");
            System.exit(1);
        }
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
