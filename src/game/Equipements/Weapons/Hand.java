package game.Equipements.Weapons;
import game.Equipements.Weapon;

/** The Rifle class extends Weapon class */
public class Hand extends Weapon{
    
  /**
   * Builds a new Rifle.
   */
  public Hand(){
    super(6, 1,1,1, 1);
    this.isWeapon = true;
  }

  /**
   * Returns the string representation of the Rifle.
   * @return the string representation of the Rifle.
   */
  public String toString() {
    return "Rifle";
  }
}
