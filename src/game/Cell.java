package src.game;

import java.util.*;

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
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Returns the zombie in the cell.
     */
    public Zombie getZombie() {
        return this.zombie;
    }

    /**
     * Returns the loots in the cell.
     */
    public List<loot> getLoots() {
        return this.loots;
    }

    /**
     * Sets the player in the cell.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Sets the zombie in the cell. 
     */
    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }

    /**
     * Adds a loot in the cell
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
}
