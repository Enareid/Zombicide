package game;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Boards.ClassicalBoard;
import game.Entities.Player;
import game.Entities.Players.Fighter;
import game.Entities.Zombies.Runner;
import game.Equipements.Weapon;
import game.Equipements.Items.MasterKey;
import game.Equipements.Weapons.Axe;

public class AxeTest extends WeaponTest{

    protected Equipement createEquipement(){
        return new Axe();
    }
    protected Equipement equipement;

    @BeforeEach
    public void before() throws Exception{
        super.before();
        this.equipement = createEquipement();
    }

    @Test
    public void testToString() {
        assertEquals("Axe", equipement.toString());
    }
    
}
