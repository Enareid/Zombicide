package game.Equipements.Weapons;
import game.Equipements.Weapon;

public class Chainsaw extends Weapon{
  
    public Chainsaw(){
      super(5, 3,0, 0, 2);
      this.canOpenDoor = true;
      this.isWeapon = true;
    }

    public String toString() {
      return "Chainsaw";
    }
    
}
