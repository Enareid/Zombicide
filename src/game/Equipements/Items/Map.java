package game.Equipements.Items;
import game.Equipement;
import game.Entities.Player;


 public class Map extends Equipement{

    /**
     * Builds a new Map.
     */
    public Map(){
        super();
    }

    /**
     * Uses the Map.
     * 
     * @param player the player using the Map
     */
    public void use(Player player){
        player.getBoard().toString();
    }

    /**
     * Returns the string representation of the Map.
     * @return the string representation of the Map.
     */
    public String toString() {
        return "Map";
    }
}
