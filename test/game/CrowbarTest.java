package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import game.Equipements.Weapon;
import game.Equipements.Weapons.Crowbar;

public class CrowbarTest extends WeaponTest{

    protected Equipement createEquipement(){
        return new Crowbar();
    }
    private Equipement crowbar;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.crowbar = createEquipement();
    }

    @Test
    public void testToString() {
        assertEquals("Crowbar", crowbar.toString());
    }
    
}
