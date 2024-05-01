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
import game.Equipements.Items.MasterKey;
import game.Equipements.Weapons.Gun;

public abstract class EquipementTest {

    protected abstract Equipement createEquipement();
    protected Board board;
    protected Player player;
    protected Equipement equipement;

    @BeforeEach
    public void before() throws Exception{
        List<Player> players = new ArrayList<Player>();
        Player player = new Fighter(null,null);
        players.add(player);
        this.board = new ClassicalBoard(5,players);
        this.player=player;
        this.equipement = createEquipement();
    }

     @Test 
     public void testEquipementGetCanOpenDoorWhenFalse() {
        assertFalse(equipement.getCanOpenDoor());
     }

     @Test 
     public void testEquipementGetCanOpenDoorWhenTrue() {
        equipement.setCanOpenDoor(true);
        assertTrue(equipement.getCanOpenDoor());
     }

     @Test 
     public void testEquipementIsWeaponWhenFalse() {
        assertFalse(equipement.getIsWeapon());
     }

     @Test 
     public void testEquipementIsWeaponWhenTrue() {
        equipement.setIsWeapon(true);
        assertTrue(equipement.getIsWeapon());
     }
}