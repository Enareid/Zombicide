package game;

import java.util.*;

import game.Entities.*;

public class Cell {
    protected Player player;
    protected Zombie zombie;
    protected boolean canAttack;
    protected List<Loot> loots;

    /**
     * Builds a new cell.
     */
    public Cell() {
        this.player = null;
        this.zombie = null;
        this.canAttack = true;
    }

    /**
     * Returns the player in the cell.
     * @return The player in the cell.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Returns the zombie in the cell.
     * @return The zombie in the cell.
     */
    public Zombie getZombie() {
        return this.zombie;
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
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Sets the zombie in the cell. 
     * @param zombie The zombie to set.
     */
    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
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
    public void removePlayer() {
        this.player = null;
    }

    /**
     * Removes a zombie form the cell. 
     */
    public void removeZombie() {
        this.zombie = null;
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
