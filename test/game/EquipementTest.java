package game;

import static org.junit.Assert.*;
import org.junit.Test;

import game.Equipement;
import game.Equipements.Items.MasterKey;

public class EquipementTest {

    @Test
    public void testEquipementInitialization() {
        Equipement equipement = new MasterKey();
        assertFalse(equipement.isUsed());
    }

    @Test
    public void testEquipement() {
        Equipement equipement = new MasterKey();
        assertFalse(equipement.isUsed());
        
        equipement.use();
        assertTrue(equipement.isUsed());
    }
}