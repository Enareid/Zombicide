package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Entities.Player;
import game.Equipements.Items.InfraredGlasses;

public class InfraredGlassesTest extends EquipementTest{

    protected Equipement createEquipement(){
        return new InfraredGlasses();
    }
    private Equipement infraredGlasses;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.infraredGlasses = createEquipement();
    }

    @Test
    public void testToString(){
        assertEquals("InfraredGlasses", infraredGlasses.toString());
    }
    
}
