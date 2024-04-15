package game.Equipements.Items;

import game.Equipement;
import game.Entities.Player;

public class FirstAidKit extends Equipement {

    /**
     * Builds a new FirstAidKit.
     */
    public FirstAidKit(){
        super();
    }

    /**
     * Uses the FirstAidKit.
     * 
     * @param receiver the player using the FirstAidKit
     */
    public void use(Player receiver){
        receiver.setLifepoints(receiver.getLifepoints()+1);
        
    }
    
    /**
     * Returns the string representation of the FirstAidKit.
     * @return the string representation of the FirstAidKit.
     */
    public String toString() {
        return "FirstAidKit";
    }
}
