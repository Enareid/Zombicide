package game;

import static org.junit.Assert.*;
import org.junit.Test;

import game.Equipements.Items.MasterKey;

public class EquipementTest {

    @Test
    public void testEquipementInitialization() {
        Equipement equipement = new MasterKey();
    }

    @Test
    public void testEquipement() {
        MasterKey equipement = new MasterKey();
        Door door = new Door(Direction.NORTH);
        equipement.use(door);
    }
}