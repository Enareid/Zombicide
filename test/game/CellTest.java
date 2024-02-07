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

    @BeforeEach
    public void before(){
        this.cell = new BuildingCell();
        this.player = new Player();
        this.zombie = new Zombie();
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

}
