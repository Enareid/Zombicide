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
    protected List<Loot> loots;

    /**
     * Builds a new cell.
     */
    public Cell() {
        this.players = new ArrayList<>();
        this.zombies = new ArrayList<>();
        this.canAttack = true;
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
    public List<Loot> getLoots() {
        return this.loots;
    }

    /**
     * Sets the player in the cell.
     * @param player The player to set.
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
    public void addLoot(Loot loot) {
        this.loots.add(loot);
    }

    /**
     * Removes a player from the cell.
     */
    public void removePlayer(Player player) throws Exception {
        if (!this.players.remove(player)){
            throw new Exception("Player not in List");
        }

    }

    /**
     * Removes a zombie form the cell.
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
     */
    public void removeLoot(Loot loot) throws Exception {
        if (this.loots.contains(loot)) {
            this.loots.remove(loot);
        } else {
            throw new Exception("The loot is not in the cell.");
        }
    }

}
