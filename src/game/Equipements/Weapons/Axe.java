package game.Equipements.Weapons;

import game.Equipements.Weapon;

/** The Axe class extends Weapon class */
public class Axe extends Weapon{

  /**
   * Builds a new Axe.
   */
  public Axe(){
    super(4, 2,0, 0, 0);
    this.canOpenDoor = true;
    this.isWeapon = true;
  }

  /**
   * Returns the string representation of the Axe.
   * @return the string representation of the Axe.
   */
  public String toString() {
    return "Axe";
  }
    
}
