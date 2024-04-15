package game.Equipements.Weapons;

import game.Equipements.Weapon;

/** The Rifle class extends Weapon class */
public class Rifle extends Weapon{
    
  /**
   * Builds a new Rifle.
   */
  public Rifle(){
    super(4, 1,1,3, 2);
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
