package game.Equipements.Weapons;

import game.Equipements.Weapon;

public class Gun extends Weapon {
    
  /**
   * Builds a new Gun.
   */
  public Gun(){
    super(4, 1,0, 1, 1);
    this.isWeapon = true;
  }
    
  /**
   * Returns the string representation of the Gun.
   * @return the string representation of the Gun.
   */
  public String toString() {
    return "Gun";
  }
}
