package game.Equipements.Weapons;

import game.Equipements.Weapon;

/** The Crowbar class extends Weapon class */
public class Crowbar extends Weapon{
    
  /**
   * Builds a new Crowbar.
   */
  public Crowbar(){
    super(4, 1,0, 0, 1);
    this.canOpenDoor = true;
    this.isWeapon = true;
  }

  /**
   * Returns the string representation of the Crowbar.
   * @return the string representation of the Crowbar.
   */
  public String toString() {
    return "Crowbar";
  }
}
