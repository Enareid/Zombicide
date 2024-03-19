import static org.junit.Assert.*;
import org.junit.Test;

public class EquipementTest {

    @Test
    public void testEquipementInitialization() {
        Equipement equipement = new Equipement();
        assertFalse(equipement.isUsed());
    }

    @Test
    public void testEquipement() {
        Equipement equipement = new Equipement();
        assertFalse(equipement.isUsed());
        
        equipement.use();
        assertTrue(equipement.isUsed());
    }
}