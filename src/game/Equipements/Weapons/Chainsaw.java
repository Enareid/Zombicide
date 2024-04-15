package game.Equipements.Weapons;
import game.Equipements.Weapon;

public class Chainsaw extends Weapon{
  
   /**
    * Builds a new Chainsaw.
    */
    public Chainsaw(){
      super(5, 3,0, 0, 2);
      this.canOpenDoor = true;
      this.isWeapon = true;
    }

    /**
     * Returns the string representation of the Chainsaw.
     * @return the string representation of the Chainsaw.
     */
    public String toString() {
      return "Chainsaw";
    }
    
}
