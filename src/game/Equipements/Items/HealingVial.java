package game.Equipements.Items;
import game.Equipement;
import game.Entities.Player;

/** The HealingVial class extends Equipement class */
public class HealingVial extends Equipement{
    
    /**
     * Builds a new HealingVial.
     */
    public HealingVial(){
        super();
    }

    /**
     * Uses the HealingVial.
     * 
     * @param player the player using the HealingVial
     */
    public void use(Player player){
        player.setLifepoints(player.getLifepoints()+1);
        
    }

    /**
     * Returns the string representation of the HealingVial.
     * @return the string representation of the HealingVial.
     */
    public String toString() {
        return "HealingVial";
    }
    
}
