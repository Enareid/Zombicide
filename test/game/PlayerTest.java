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
import game.Equipements.Weapons.*;


public class PlayerTest {

    private Board board;
    private Player player;

    @BeforeEach
    public void before() throws Exception{
        List<Player> players = new ArrayList<Player>();
        Player player = new Fighter(5,null,null);
        players.add(player);
        this.board = new ClassicalBoard(5,players);
        this.board.spawnZombie();
        this.player=player;
    }

    @Test
    public void testPlayerInitialization() throws Exception {
    
        assertEquals(5, this.player.getLifeLevel());
        assertEquals(0, this.player.getExpertiseLevel()); 
        assertEquals(3, this.player.getActionPoints());
        assertEquals(0, this.player.getEquipments().size());
        
    }


    @Test
    public void canAttackZombieTestWhenOnSameCellTrue(){

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
    public void canAttackZombieTestWhenUsingRangeNoObstacles(){

        Equipement gun = new Gun();
        this.player.setEquipment(gun);
        this.player.setInHand(gun);
        for (Zombie zombie : this.board.getZombies()) {
            zombie.move();
            assertTrue(this.player.canAttackZombie(zombie));
            


        }
    }



}