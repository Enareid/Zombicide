package game.Equipements.Items;
import game.Equipement;
import game.Entities.Player;

public class HealingVial extends Equipement{
    

    public void use(Player player){
        player.setLifeLevel(player.getLifeLevel()+1);
        
    }

    public String toString() {
        return "HealingVial";
    }
    
}
