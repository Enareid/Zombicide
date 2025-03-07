package game;

import org.junit.jupiter.api.*;

import game.Cells.BuildingCell;
import game.Entities.*;
import game.Entities.Players.*;
import game.Entities.Zombies.*;
import game.Equipements.Items.MasterKey;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private Cell cell;
    private Player player;
    private Zombie zombie;
    private Equipement equipement;

    @BeforeEach
    public void before(){
        this.cell = new Cell(0,0);
        this.player = new Fighter(this.cell,null);
        this.zombie = new Walker(this.cell,null);
        this.equipement = new MasterKey();
    }

    @Test 
    public void testGetCoordinates(){
        assertEquals(0, this.cell.getCoord()[0]);
        assertEquals(0, this.cell.getCoord()[1]);
    }

    @Test 
    public void testGetCoordinatesWhenCellIsNotAtOrigin(){
        this.cell = new BuildingCell(1,1);
        assertEquals(1, this.cell.getCoord()[0]);
        assertEquals(1, this.cell.getCoord()[1]);
    }

    @Test
    public void testGetPlayersIsOk() throws Exception{
            this.cell.setPlayer(this.player);
            assertEquals(this.player, this.cell.getPlayers().get(0));
    }

    @Test
    public void testGetPlayersEmptyCell(){
            assertEquals(0, this.cell.getPlayers().size());
    }

    @Test 
    public void testRemovePlayerWhenPlayerIsOnCell() throws Exception{
            this.cell.setPlayer(this.player);
            assertEquals(1, this.cell.getPlayers().size());
            this.cell.removePlayer(this.player);
            assertEquals(0, this.cell.getPlayers().size());
    }

    @Test 
    public void testRemovePlayerWhenPlayerIsNotOnCell(){
            assertEquals(0, this.cell.getPlayers().size());
            assertThrows(Exception.class, () -> this.cell.removePlayer(this.player));
    }

    @Test 
    public void testRemovePlayersWhenPlayersOnCell() throws Exception{
            this.cell.setPlayer(this.player);
            assertEquals(1, this.cell.getPlayers().size());
            this.cell.removePlayers();
            assertEquals(0, this.cell.getPlayers().size());
    }

    @Test 
    public void testRemovePlayersWhenNoPlayersOnCell(){
            assertEquals(0, this.cell.getPlayers().size());
            this.cell.removePlayers();
            assertEquals(0, this.cell.getPlayers().size());
    }

    @Test 
    public void testRemovePlayersWhenMultiplePlayersOnCell() throws Exception{
            this.cell.setPlayer(this.player);
            Player player2 = new Fighter(this.cell,null);
            this.cell.setPlayer(player2);
            assertEquals(2, this.cell.getPlayers().size());
            this.cell.removePlayers();
            assertEquals(0, this.cell.getPlayers().size());
    }

    @Test
    public void testGetZombie() throws Exception{
            this.cell.setZombie(this.zombie);
            assertEquals(this.zombie, this.cell.getZombie().get(0));
    }

    @Test 
    public void testGetZombieEmptyCell(){
            assertEquals(0, this.cell.getZombie().size());
    }

    @Test 
    public void testRemoveZombieWhenZombieInTheCell() throws Exception{
            this.cell.setZombie(this.zombie);
            assertEquals(1, this.cell.getZombie().size());
            this.cell.removeZombie(this.zombie);
            assertEquals(0, this.cell.getZombie().size());
    }

    @Test 
    public void testRemoveZombieWhenZombieNotInTheCell(){
            assertEquals(0, this.cell.getZombie().size());
            assertThrows(Exception.class, () -> this.cell.removeZombie(this.zombie));
    }

    @Test
    public void testGetEquipement(){
            this.cell.addEquipement(this.equipement);
            assertEquals(this.equipement, this.cell.getEquipements().get(0));
    }

    @Test 
    public void testGetEquipementEmptyCell(){
            assertEquals(0, this.cell.getEquipements().size());
    }

    @Test
    public void testRemoveLoot() throws Exception{
            this.cell.addEquipement(this.equipement);
            assertEquals(1, this.cell.getEquipements().size());
            this.cell.removeEquipement(this.equipement);
            assertEquals(0, this.cell.getEquipements().size());
    }

    @Test 
    public void testRemoveLootEmptyCell(){
            assertEquals(0, this.cell.getEquipements().size());
            assertThrows(Exception.class, () -> this.cell.removeEquipement(this.equipement));
    }

    @Test 
    public void testGetDoorWhenDoorsInCell(){
        assertEquals(4, this.cell.getDoor().size());
    }

    @Test 
    public void testOpenDoorWhenDoorIsClosed() throws Exception{
        assertTrue(this.cell.isLocked(Direction.NORTH));
        this.cell.openDoor(Direction.NORTH);
        assertFalse(this.cell.isLocked(Direction.NORTH));
    }

    @Test 
    public void testOpenDoorWhenDoorIsOpen() throws Exception{
        this.cell.openDoor(Direction.NORTH);
        assertFalse(this.cell.isLocked(Direction.NORTH));
        this.cell.openDoor(Direction.NORTH);
        assertFalse(this.cell.isLocked(Direction.NORTH));
    }

    @Test 
    public void testOpenAllDoorsWhenAllDoorsIsClosed() throws Exception{
        assertTrue(this.cell.isLocked(Direction.NORTH));
        assertTrue(this.cell.isLocked(Direction.SOUTH));
        assertTrue(this.cell.isLocked(Direction.EAST));
        assertTrue(this.cell.isLocked(Direction.WEST));
        this.cell.openAllDoor();
        assertFalse(this.cell.isLocked(Direction.NORTH));
        assertFalse(this.cell.isLocked(Direction.SOUTH));
        assertFalse(this.cell.isLocked(Direction.EAST));
        assertFalse(this.cell.isLocked(Direction.WEST));
    }

    @Test 
    public void testOpenAllDoorsWhenAllDoorsIsOpen() throws Exception{
        this.cell.openAllDoor();
        assertFalse(this.cell.isLocked(Direction.NORTH));
        assertFalse(this.cell.isLocked(Direction.SOUTH));
        assertFalse(this.cell.isLocked(Direction.EAST));
        assertFalse(this.cell.isLocked(Direction.WEST));
        this.cell.openAllDoor();
        assertFalse(this.cell.isLocked(Direction.NORTH));
        assertFalse(this.cell.isLocked(Direction.SOUTH));
        assertFalse(this.cell.isLocked(Direction.EAST));
        assertFalse(this.cell.isLocked(Direction.WEST));
    }

    @Test 
    public void testGetNoiseLevelWhenNoiseLevelIsNull(){
        assertEquals(0, this.cell.getNoiseLevel());
    }

    @Test 
    public void testGetNoiseLevelWhenNoiseLevelIsNotNull(){
        this.cell.setNoiseLevel(5);
        assertEquals(5, this.cell.getNoiseLevel());
    }

    @Test 
    public void testCreateCopyWithEmptyCell(){
        Cell copy = this.cell.createCopy();
        assertEquals(this.cell.getCoord()[0], copy.getCoord()[0]);
        assertEquals(this.cell.getCoord()[1], copy.getCoord()[1]);
        assertEquals(this.cell.getDoor().size(), copy.getDoor().size());
        assertEquals(this.cell.getNoiseLevel(), copy.getNoiseLevel());
    }

    @Test 
    public void testCalculateDistanceWhenCellsAreOnSameLine(){
        Cell cell2 = new BuildingCell(0,1);
        assertEquals(1, this.cell.calculateDistance(cell2));
    }

    @Test 
    public void testCalculateDistanceWhenCellsAreOnSameColumn(){
        Cell cell2 = new BuildingCell(1,0);
        assertEquals(1, this.cell.calculateDistance(cell2));
    }

    @Test 
    public void testCalculateDistanceWhenCellsAreNotOnSameLineOrColumn(){
        Cell cell2 = new BuildingCell(1,1);
        assertEquals(2, this.cell.calculateDistance(cell2));
    }

    @Test 
    public void testCalculateDistanceWhenSameCell(){
        assertEquals(0, this.cell.calculateDistance(this.cell));
    }
}
