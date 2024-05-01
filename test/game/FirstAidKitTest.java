package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Entities.Player;
import game.Equipements.Items.FirstAidKit;

public class FirstAidKitTest extends EquipementTest{

    protected Equipement createEquipement(){
        return new FirstAidKit();
    }
    private Equipement firstAidKit;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.firstAidKit = createEquipement();
    }

    @Test 
    public void testUse() throws Exception{
        player.setLifepoints(1);
        firstAidKit.use(player);
        assertEquals(2, player.getLifepoints());
    }

    @Test
    public void testToString() {
        assertEquals("FirstAidKit", firstAidKit.toString());
    }
    
}
