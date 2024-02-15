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
    public void testGetPlayers(){
        try {
            this.cell.setPlayer(this.player);
            assertEquals(this.player, this.cell.getPlayers().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetZombie(){
        try {
            this.cell.setZombie(this.zombie);
            assertEquals(this.zombie, this.cell.getZombie().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLoots(){
        try {
            this.cell.addEquipement(this.equipement);
            assertEquals(this.equipement, this.cell.getEquipements().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemovePlayer(){
        try {
            this.cell.setPlayer(this.player);
            this.cell.removePlayer(this.player);
            assertEquals(0, this.cell.getPlayers().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveZombie(){
        try {
            this.cell.setZombie(this.zombie);
            this.cell.removeZombie(this.zombie);
            assertEquals(0, this.cell.getZombie().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveLoot(){
        try {
            this.cell.addEquipement(this.equipement);
            this.cell.removeEquipement(this.equipement);
            assertEquals(0, this.cell.getEquipements().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testToString(){
        assertEquals("B     ", this.cell.toString());
    }

}
