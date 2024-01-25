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
}
