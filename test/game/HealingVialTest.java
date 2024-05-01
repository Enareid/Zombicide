package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Entities.Player;
import game.Equipements.Items.HealingVial;

public class HealingVialTest extends EquipementTest{
    
    protected Equipement createEquipement(){
        return new HealingVial();
    }
    private Equipement healingVial;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.healingVial = createEquipement();
    }

    @Test
    public void testUse() throws Exception{
        player.setLifepoints(1);
        healingVial.use(player);
        assertEquals(2, player.getLifepoints());
    }

    @Test
    public void testToString() {
        assertEquals("HealingVial", healingVial.toString());
    }
}
