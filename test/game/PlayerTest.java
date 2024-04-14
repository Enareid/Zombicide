package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import game.Boards.*;

import game.Entities.Player;
import game.Entities.Zombie;
import game.Entities.Players.*;
import game.Entities.Zombies.Walker;
import game.Equipements.Weapons.*;


public abstract class PlayerTest{

    protected abstract Player createPlayer(Board board, Cell cell);
    protected Player player;
    protected Board board;
    protected Cell cell;
    protected Equipement gun;

    @BeforeEach
    public void before() throws Exception{
        List<Player> players = new ArrayList<Player>();
        players.add(this.player);
        this.board = new ClassicalBoard(5,players);
        this.board.spawnZombie();
        this.player = createPlayer(this.board, this.board.getCell(0,0));
    }

    @Test
    public void testPlayerInitialization() throws Exception {
    
        assertEquals(5, this.player.getLifeLevel());
        assertEquals(0, this.player.getExpertiseLevel()); 
        assertEquals(3, this.player.getActionPoints());
        assertEquals(0, this.player.getEquipments().size());
        
    }


    @Test
    public void testCanAttackZombieTestWhenOnSameCellTrue(){

        Equipement axe = new Axe();
        this.player.setEquipment(axe);
        this.player.setInHand(axe);
        for (Zombie zombie : this.board.getZombies()) {
            zombie.move();
            zombie.move();
            assertEquals(zombie.getCell(),player.getCell());
            assertTrue(this.player.canAttackZombie(zombie));
            


        }
    }

    @Test
    public void testCanAttackZombieTestWhenUsingRangeNoObstacles() throws Exception{
        this.player.setEquipment(gun);
        this.player.setInHand(gun);
        Zombie zomb = new Walker(this.board.getCell(1, 1), board);
        this.board.getCell(1,1).setZombie(zomb);
        assertFalse(this.player.canAttackZombie(zomb));
        for (Zombie zombie : this.board.getZombies()) {
            zombie.move();
            assertTrue(this.player.canAttackZombie(zombie));
            


        }
    }

    @Test 
    public void testListZombieCanBeAttackedWhenZombieNotInRange() throws Exception{
        this.player.setEquipment(gun);
        this.player.setInHand(gun);
        Zombie zomb = new Walker(this.board.getCell(1, 1), board);
        this.board.getCell(1,1).setZombie(zomb);
        List<Zombie> zombies = this.player.zombieCanBeAttack();
        assertEquals(0, zombies.size());
    }

    @Test void testListZombieCanBeAttackedWhenZombieIsInRange() throws Exception{
        this.player.setEquipment(gun);
        this.player.setInHand(gun);
        Zombie zomb = new Walker(this.board.getCell(2, 1), board);
        this.board.getCell(2,1).setZombie(zomb);
        List<Zombie> zombies = this.player.zombieCanBeAttack();
        assertEquals(0, zombies.size());
        zomb.move();
        zombies = this.player.zombieCanBeAttack();
        assertEquals(1, zombies.size());
    }



}