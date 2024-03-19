package game.Equipements.Items;

import game.Equipement;
import game.Entities.Player;

public class FirstAidKit extends Equipement {

    public FirstAidKit(){
        super();
    }

    public void use(Player receiver){
        receiver.setLifeLevel(receiver.getLifeLevel()+1);
        
    }
    
}
