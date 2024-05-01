package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import game.Equipements.Weapon;
import game.Equipements.Weapons.Gun;

public class GunTest extends WeaponTest{

    protected Equipement createEquipement(){
        return new Gun();
    }
    private Equipement gun;

    @BeforeEach 
    public void before() throws Exception{
        super.before();
        this.gun = createEquipement();
    }

    @Test 
    public void testToString(){
        assertEquals("Gun", gun.toString());
    }
    
}
