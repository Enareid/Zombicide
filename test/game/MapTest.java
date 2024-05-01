package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Entities.Player;
import game.Equipements.Items.Map;

public class MapTest extends EquipementTest{

    protected Equipement createEquipement(){
        return new Map();
    }
    private Equipement map;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.map = createEquipement();
    }

    @Test 
    public void testToString(){
        assertEquals("Map", map.toString());
    }
    
}
