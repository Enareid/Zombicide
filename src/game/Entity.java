package game;

import game.Entities.*;

public abstract class Entity {

    protected int Lifepoints;
    protected Cell cell;
    protected Board board;
    protected int actionPoints;

    /**
     * Builds a new entity.
     * @param Lifepoints the lifepoints of the entity.
     * @param cell the cell of the entity.
     */
    public Entity(int Lifepoints, Cell cell, Board board, int actionPoints){
        this.Lifepoints=Lifepoints;
        this.cell=cell;
        this.board = board;
        this.actionPoints=actionPoints;
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

    public int getLifepoints() {
        return this.Lifepoints;
    }

	/**
	 * Gets the action points of the Entity.
	 * @return the action points of the Entity.
	 */
	public int getActionPoints() {
		return this.actionPoints;
	}

	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}

    public boolean isDead() {
        return this.Lifepoints <= 0;
    }

    	/**
	 * Calculates the distance between two cells.
	 * 
	 * @param cell1 The first cell.
	 * @param cell2 The second cell.
	 * @return The distance between the two cells.
	 */
	public double calculateDistance(Cell cell1, Cell cell2) {
		int x1 = cell1.getCoord()[0];
		int y1 = cell1.getCoord()[1];
		int x2 = cell2.getCoord()[0];
		int y2 = cell2.getCoord()[1];

		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
