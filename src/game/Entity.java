package game;

import game.Entities.*;

public abstract class Entity {

    protected int Lifepoints;
    protected Cell cell;
    protected Board board;

    /**
     * Builds a new entity.
     * @param Lifepoints the lifepoints of the entity.
     * @param cell the cell of the entity.
     */
    public Entity(int Lifepoints, Cell cell, Board board){
        this.Lifepoints=Lifepoints;
        this.cell=cell;
        this.board = board;
    }

    public void attack() {
        switch (this.toString()) {
            case "Fighter":
                System.out.println("Fighter !!");
                break;
    
        }
        System.out.println("OMG !!");
    }
    
    	/**
	 * Sets the cell of the player.
	 * 
	 * @param cell the cell of the player.
	 */
	public void setCell(Cell cell) {
		this.cell = cell;
	}
    
    	/**
	 * Gets the cell of the player.
	 * 
	 * @return the cell of the player.
	 */
	public Cell getCell() {
		return this.cell;
	}
}
