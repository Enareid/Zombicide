package game.Equipements.Weapons;

import game.Equipements.Weapon;

public class Crowbar extends Weapon{
    
      public Crowbar(){
        super(4, 1,0, 0, 1);
        this.canOpenDoor = true;
        this.isWeapon = true;
      }

      public String toString() {
        return "Crowbar";
      }
}
