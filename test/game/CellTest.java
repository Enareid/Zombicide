package game;

import org.junit.jupiter.api.*;

import game.Boards.*;
import game.Cells.BuildingCell;
import game.Entities.*;
import game.*;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private BuildingCell cell;
    private Player player;
    private Zombie zombie;
    private Loot loot;

    @BeforeEach
    public void before(){
        this.cell = new BuildingCell();
        this.player = new Player();
        this.zombie = new Zombie();
        this.loot = new Loot();
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
            this.cell.addLoot(this.loot);
            assertEquals(this.loot, this.cell.getLoots().get(0));
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
            this.cell.addLoot(this.loot);
            this.cell.removeLoot(this.loot);
            assertEquals(0, this.cell.getLoots().size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
