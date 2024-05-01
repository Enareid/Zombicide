package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import game.Equipements.Weapon;
import game.Equipements.Weapons.Hand;

public class HandTest extends WeaponTest{

    protected Equipement createEquipement(){
        return new Hand();
    }
    private Equipement hand;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.hand = createEquipement();
    }

    @Test
    public void testToString(){
        assertEquals("Hand", hand.toString());
    }
    
}
