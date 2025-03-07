package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import game.Equipements.Weapon;
import game.Equipements.Weapons.Axe;

public class AxeTest extends WeaponTest{

    protected Equipement createEquipement(){
        return new Axe();
    }
    protected Equipement Axe;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.Axe = createEquipement();
    }

    @Test
    public void testToString() {
        assertEquals("Axe", Axe.toString());
    }
    
}
