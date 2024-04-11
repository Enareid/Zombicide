package game.Equipements.Weapons;

import game.Equipements.Weapon;

public class Axe extends Weapon{

  public Axe(){
    super(4, 2,0, 0, 0);
    this.canOpenDoor = true;
    this.isWeapon = true;
  }

  public String toString() {
    return "Axe";
  }
    
}
