package game.Equipements.Weapons;

import game.Equipements.Weapon;

public class Gun extends Weapon {
    
      public Gun(){
        super(4, 1,0, 1, 1);
        this.isWeapon = true;
      }
    
      public String toString() {
        return "Gun";
      }
}
