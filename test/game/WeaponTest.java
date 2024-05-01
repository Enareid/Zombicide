package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Equipements.Weapon;

public class WeaponTest extends EquipementTest{

    protected Equipement createEquipement(){
        return new Weapon(4, 2,0, 0, 0);
    }
    private Equipement equipement;

    @BeforeEach 
    public void before() throws Exception{
        super.before();
        this.equipement = createEquipement();
    }

    @Test 
    public void testGetSeuil() {
        assertEquals(4, ((Weapon)equipement).getSeuil());
    }
    
    @Test 
    public void testSetSeuil() {
        ((Weapon)equipement).setSeuil(5);
        assertEquals(5, ((Weapon)equipement).getSeuil());
    }

    @Test 
    public void testGetDamage() {
        assertEquals(2, ((Weapon)equipement).getDamage());
    }

    @Test
    public void testSetDamage() {
        ((Weapon)equipement).setDamage(4);
        assertEquals(4, ((Weapon)equipement).getDamage());
    }

    @Test
    public void testGetMinrange() {
        assertEquals(0, ((Weapon)equipement).getRange()[0]);
    }

    @Test
    public void testGetMaxrange() {
        assertEquals(0, ((Weapon)equipement).getRange()[1]);
    }

    @Test
    public void testSetRange() {
        ((Weapon)equipement).setRange(1, 3);
        assertEquals(1, ((Weapon)equipement).getRange()[0]);
        assertEquals(3, ((Weapon)equipement).getRange()[1]);
    }

    @Test
    public void testGetAttempts() {
        assertEquals(0, ((Weapon)equipement).getAttempts());
    }

    @Test
    public void testSetAttempts() {
        ((Weapon)equipement).setAttempts(2);
        assertEquals(2, ((Weapon)equipement).getAttempts());
    }

}
