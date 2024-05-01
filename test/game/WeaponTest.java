package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Equipements.Weapon;

public class WeaponTest extends EquipementTest{

    protected Equipement createEquipement(){
        return new Weapon(4, 2,0, 0, 0);
    }
    private Equipement Weapon;

    @BeforeEach 
    public void before() throws Exception{
        super.before();
        this.Weapon = createEquipement();
    }
    
    @Test 
    public void testSetSeuil() {
        ((Weapon)Weapon).setSeuil(5);
        assertEquals(5, ((Weapon)Weapon).getSeuil());
    }

    @Test
    public void testSetDamage() {
        ((Weapon)Weapon).setDamage(4);
        assertEquals(4, ((Weapon)Weapon).getDamage());
    }

    @Test
    public void testSetRange() {
        ((Weapon)Weapon).setRange(1, 3);
        assertEquals(1, ((Weapon)Weapon).getRange()[0]);
        assertEquals(3, ((Weapon)Weapon).getRange()[1]);
    }

    @Test
    public void testSetAttempts() {
        ((Weapon)Weapon).setAttempts(2);
        assertEquals(2, ((Weapon)Weapon).getAttempts());
    }

}
