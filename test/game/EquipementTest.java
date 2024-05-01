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

public class EquipementTest {

    private Board board;
    private Player player;

    @BeforeEach
    public void before() throws Exception{
        List<Player> players = new ArrayList<Player>();
        Player player = new Fighter(null,null);
        players.add(player);
        this.board = new ClassicalBoard(5,players);
        this.player=player;
    }

    @Test
    public void testEquipementInitialization() {
        Equipement equipement = new MasterKey();
    }

    @Test
    public void testEquipement() {
        MasterKey equipement = new MasterKey();
        this.player.setEquipment(equipement);
        this.player.setInHand(equipement);
        assertTrue(this.player.getCell().isLocked(Direction.NORTH));
        equipement.use(player,Direction.NORTH);
        assertFalse(this.player.getCell().isLocked(Direction.NORTH));
    
     }

     @Test 
     public void testEquipementGetCanOpenDoorWhenFalse() {
        Gun equipement = new Gun();
        assertFalse(equipement.getCanOpenDoor());
     }

     @Test 
     public void testEquipementGetCanOpenDoorWhenTrue() {
        MasterKey equipement = new MasterKey();
        assertTrue(equipement.getCanOpenDoor());
     }
}