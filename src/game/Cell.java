package game;

import java.util.*;

import game.Entities.*;

public class Cell {

    /** The players in the cell */
    protected List<Player> players;
    /** The zombies in the cell */
    protected List<Zombie> zombies;
    /** If the player can attack in this cell */
    protected boolean canAttack;
    /** The loots in the cell */
    protected List<Equipement> equipements;
    protected List<Door> doors; // Liste des portes dans la cellule
    protected int[] coord;

    /**
     * Builds a new cell.
     */
    public Cell(int x,int y) {
        this.players = new ArrayList<>(); 
        this.zombies = new ArrayList<>(); 
        this.doors = new ArrayList<>();
        this.canAttack = true;
        this.coord=new int[2];
        this.coord[0]=x;
        this.coord[1]=y;
        for (Direction direction : Direction.values()) {
            this.doors.add(new Door(direction)); // Initialise toutes les portes
        }
    }
    
    /**
     * Returns the player in the cell.
     * @return The player in the cell.
     */
    public List<Player> getPlayers() {
        return this.players;
    }

    /**
     * Returns the zombie in the cell.
     * @return The zombie in the cell.
     */
    public List<Zombie> getZombie() {
        return this.zombies;
    }

    /**
     * Returns the loots in the cell.
     * @return The loots in the cell.
     */
    public List<Equipement> getEquipements() {
        return this.equipements;
    }

    /**
     * Sets the player in the cell.
     * @param player The player to set.
     * @throws Exception if the player is already in the cell.
     */
    public void setPlayer(Player player) throws Exception{
        if (!this.players.contains(player)){
            this.players.add(player);
        }
        else{
            throw new Exception("Player already present");
        }
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
     * Adds a loot in the cell
     * @param loot The loot to add.
     */
    public void addEquipement(Equipement equipement) {
        this.equipements.add(equipement);
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
     * Removes a loot from the list of loots in the cell if the loot is in the list.
     * else, throws an exception.
     * @param loot The loot to remove.
     * @throws Exception if the loot is not in the cell.
     */
    public void removeEquipement(Equipement equipement) throws Exception {
        if (this.equipements.contains(equipement)) {
            this.equipements.remove(equipement);
        } else {
            throw new Exception("The loot is not in the cell.");
        }
    }

     /**
     * Méthode pour casser une porte dans une direction donnée
     */
    public void casserPorte(Direction direction) {
        for (Door door : doors) {
            if (door.getDirection() == direction) {
                door.lock(); // Casse la porte en la verrouillant
                break;
            }
        }
    }

    /**
     * Méthode pour vérifier si une porte dans une direction donnée est intacte
     */
    public boolean isPorteIntacte(Direction direction) {
        for (Door door : doors) {
            if (door.getDirection() == direction) {
                return door.isLocked();
            }
        }
        return false;
    }
}




