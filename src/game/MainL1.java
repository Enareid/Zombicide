package game;

public class MainL1 {

    public static void main(String[] args){
        int nbEssais = 0;
        while(nbEssais < 4){
            try {
                Game game = new Game();
                game.play();
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
