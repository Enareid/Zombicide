package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import game.Equipements.Weapon;
import game.Equipements.Weapons.Chainsaw;

public class ChainsawTest extends WeaponTest{

    protected Equipement createEquipement(){
        return new Chainsaw();
    }
    private Equipement chainsaw;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.chainsaw = createEquipement();
    }

    @Test
    public void testToString() {
        assertEquals("Chainsaw", chainsaw.toString());
    }
    
}
