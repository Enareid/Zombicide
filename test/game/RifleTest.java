package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import game.Equipements.Weapon;
import game.Equipements.Weapons.Rifle;

public class RifleTest extends WeaponTest{

    protected Equipement createEquipement(){
        return new Rifle();
    }
    private Equipement rifle;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.rifle = createEquipement();
    }

    @Test
    public void testToString() {
        assertEquals("Rifle", rifle.toString());
    }
    
}
