package game;

import org.junit.jupiter.api.*;

import game.Cells.BuildingCell;
import game.Entities.*;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private BuildingCell cell;
    private Player player;
    private Zombie zombie;
    private Equipement equipement;

    @BeforeEach
    public void before(){
        this.cell = new BuildingCell();
        this.player = new Player();
        this.zombie = new Zombie();
        this.equipement = new Equipement();
    }

    @Test
    public void testGetPlayersIsOk(){
            this.cell.setPlayer(this.player);
            assertEquals(this.player, this.cell.getPlayers().get(0));
    }

    @Test
    public void testGetPlayersEmptyCell(){
            assertEquals(0, this.cell.getPlayers().size());
    }

    @Test
    public void testGetZombie(){
            this.cell.setZombie(this.zombie);
            assertEquals(this.zombie, this.cell.getZombie().get(0));
    }

    @Test 
    public void testGetZombieEmptyCell(){
            assertEquals(0, this.cell.getZombie().size());
    }

    @Test
    public void testGetLoots(){
            this.cell.addEquipement(this.equipement);
            assertEquals(this.equipement, this.cell.getEquipements().get(0));
    }

    @Test 
    public void testGetLootsEmptyCell(){
            assertEquals(0, this.cell.getEquipements().size());
    }

    @Test
    public void testRemovePlayerIsOk(){
            this.cell.setPlayer(this.player);
            asserEquals(1, this.cell.getPlayers().size());
            this.cell.removePlayer(this.player);
            assertEquals(0, this.cell.getPlayers().size());
    }

    @Test
    public void testRemovePlayerEmptyCell(){
            asserEquals(0, this.cell.getPlayers().size());
            this.cell.removePlayer(this.player);
            assertThrows(Exception.class, () -> this.cell.removePlayer(this.player));
    }

    @Test
    public void testRemoveZombie(){
            this.cell.setZombie(this.zombie);
            asserEquals(1, this.cell.getZombie().size());
            this.cell.removeZombie(this.zombie);
            assertEquals(0, this.cell.getZombie().size());
    }

    @Test 
    public void testRemoveZombieEmptyCell(){
            asserEquals(0, this.cell.getZombie().size());
            this.cell.removeZombie(this.zombie);
            assertThrows(Exception.class, () -> this.cell.removeZombie(this.zombie));
    }

    @Test
    public void testRemoveLoot(){
            this.cell.addEquipement(this.equipement);
            asserEquals(1, this.cell.getEquipements().size());
            this.cell.removeEquipement(this.equipement);
            assertEquals(0, this.cell.getEquipements().size());
    }

    @Test 
    public void testRemoveLootEmptyCell(){
            asserEquals(0, this.cell.getEquipements().size());
            this.cell.removeEquipement(this.equipement);
            assertThrows(Exception.class, () -> this.cell.removeEquipement(this.equipement));
    }

    @Test
    public void testToString(){
        assertEquals("B     ", this.cell.toString());
    }

}
