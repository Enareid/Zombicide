package game.Equipements.Weapons;

import game.Equipements.Weapon;

public class Rifle extends Weapon{
    
      public Rifle(){
        super(4, 1,1,3, 2);
        this.isWeapon = true;
      }

      public String toString() {
        return "Rifle";
      }
}
