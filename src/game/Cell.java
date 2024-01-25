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
    
}
