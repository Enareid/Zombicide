package game.Equipements.Items;
import game.Equipement;
import game.Entities.Player;

public class HealingVial extends Equipement{
    

    public void use(Player player){
        player.setLifepoints(player.getLifepoints()+1);
        
    }

    public String toString() {
        return "HealingVial";
    }
    
}
