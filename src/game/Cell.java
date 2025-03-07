package game;

import java.util.*;

import game.Entities.*;

/** The Cell class */
public class Cell {

    /** The players in the cell */
    protected List<Player> players;
    /** The zombies in the cell */
    protected List<Zombie> zombies;
    /** If the player can attack in this cell */
    protected boolean canAttack;
    /** The loots in the cell */
    protected List<Equipement> equipements;
    /** The doors of the cell */
    protected Map<Direction,Door> doors; // Liste des portes dans la cellule
    /** The coordinates of the cell */
    protected int[] coord;
    /** The noise level of this cell */
    protected int noiseLevel;

    /**
     * Builds a new cell.
     * 
     * @param x The x coordinate of the cell.
     * @param y The y coordinate of the cell.
     */
    public Cell(int x,int y) {
        this.players = new ArrayList<>(); 
        this.zombies = new ArrayList<>(); 
        this.doors = new HashMap<>();
        this.canAttack = true;
        this.coord=new int[2];
        this.coord[0]=x;
        this.coord[1]=y;
        this.noiseLevel = 0;
        this.equipements = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            this.doors.put(direction,new Door(direction)); // Initialise toutes les portes
        }
    }

    /**
     * Return the coordinates of the cell
     * 
     * @return the coordinates of the cell
     */
    public int[] getCoord(){
        return this.coord;
    }
    
    /**
     * Returns the player in the cell.
     * @return The player in the cell.
     */
    public List<Player> getPlayers() {
        return this.players;
    }

    /**
     * Sets the player in the cell.
     * @param player The player to set.
     * @throws Exception if the player is already in the cell.
     */
    public void setPlayer(Player player) throws Exception{
        if (!this.players.contains(player)){
            this.players.add(player);
            player.setCell(this);
        }
        else{
            throw new Exception("Player already present");
        }
    }

    /**
     * Removes a player from the cell.
     * @param player The player to remove.
     * @throws Exception if the player is not in the cell.
     */
    public void removePlayer(Player player) throws Exception {
        if (!this.players.remove(player)){
            throw new Exception("Player not in List");
        }
    }

    /**
     * Removes all the players in the cell
     */
    public void removePlayers(){
        this.players.clear();
    }

    /**
     * Returns the zombie in the cell.
     * @return The zombie in the cell.
     */
    public List<Zombie> getZombie() {
        return this.zombies;
    }

    /**
     * Sets the zombie in the cell.
     * @param zombie The zombie to set.
     * @throws Exception if the zombie is already in the cell.
     */
    public void setZombie(Zombie zombie)throws Exception{
        if (!this.zombies.contains(zombie)){
            this.zombies.add(zombie);
        }
        else{
            throw new Exception("Zombie already present");
        }
    }

    /**
     * Removes a zombie form the cell.
     * @param zombie The zombie to remove.
     * @throws Exception if the zombie is not in the cell.
     */
    public void removeZombie(Zombie zombie) throws Exception{
        if (!this.zombies.remove(zombie)){
            throw new Exception("Zombie not in List");
        }
    }

    /**
     * Returns the equipements in the cell.
     * @return The equipements in the cell.
     */
    public List<Equipement> getEquipements() {
        return this.equipements;
    }

    /**
     * Adds a equipement in the cell
     * @param equipement The equipement to add.
     */
    public void addEquipement(Equipement equipement) {
        this.equipements.add(equipement);
    }

    /**
     * Removes a equipement from the list of equipements in the cell if the equipement is in the list.
     * else, throws an exception.
     * @param equipement The equipement to remove.
     * @throws Exception if the equipement is not in the cell.
     */
    public void removeEquipement(Equipement equipement) throws Exception {
        if (this.equipements.contains(equipement)) {
            this.equipements.remove(equipement);
        } else {
            throw new Exception("The loot is not in the cell.");
        }
    }

    /**
     * Returns all the doors of the cell
     * 
     * @return the map of doors of this cell
     */
    public Map<Direction,Door> getDoor(){
        return this.doors;
    }

     /**
     * Opens a door in a given direction
     * 
     * @param direction the direction of the door to open
     */
    public void openDoor(Direction direction) {
        this.doors.get(direction).unlock(); // Casse la porte en l'ouvrant
    }

    /**
     * Opens all the doors of the cell
     */
    public void openAllDoor(){
        for (Door door : this.doors.values()) {
            door.unlock();
        }
    }

    /**
     * Give if door is locked
     * 
     * @param direction the direction of the door to test
     * @return true if the door is locked, false otherwise
     */
    public boolean isLocked(Direction direction) {
        return this.doors.get(direction).isLocked();
    }

    /**
     * Returns the noise level of this cell
     * 
     * @return the noise level of this cell
     */
    public int getNoiseLevel(){
        return this.noiseLevel;
    }

    /**
     * Sets the noise level of this cell
     * 
     * @param noiseLevel the noise level to set
     */
    public void setNoiseLevel(int noiseLevel){
        this.noiseLevel = noiseLevel;
    }

    /**
     * Create a copy of the cell
     */
    public Cell createCopy(){
        Cell cell = new Cell(this.coord[0],this.coord[1]);
        return cell;
    }

    /**
     * Returns the distance between two cells
     * 
     * @param cell the cell to calculate the distance with
     * @return the distance between the two cells
     */
    public int calculateDistance(Cell cell) {
        int x1 = this.coord[0];
        int y1 = this.coord[1];
        int x2 = cell.getCoord()[0];
        int y2 = cell.getCoord()[1];
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}




