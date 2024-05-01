package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Entities.Player;
import game.Equipements.Items.MasterKey;

public class MasterKeyTest extends EquipementTest{
    
    protected Equipement createEquipement(){
        return new MasterKey();
    }
    private Equipement masterKey;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.masterKey = createEquipement();
    }

    @Test
    public void testToString() {
        assertEquals("MasterKey", masterKey.toString());
    }
    
}
