package game;

/** The Entity class */
public class Entity {

	/** The life points of this entity */
    protected int Lifepoints;
	/** The cell of this entity */
    protected Cell cell;
	/** The board of this entity */
    protected Board board;
	/** The action points of this entity */
    protected int actionPoints;

    /**
     * Builds a new entity.
     * @param Lifepoints the lifepoints of the entity.
     * @param cell the cell of the entity.
	 * @param board the board of the entity.
	 * @param actionPoints the action points of the entity.
     */
    public Entity(int Lifepoints, Cell cell, Board board, int actionPoints){
        this.Lifepoints=Lifepoints;
        this.cell=cell;
        this.board = board;
        this.actionPoints=actionPoints;
    }

    /**
	 * Gets the cell of the player.
	 * 
	 * @return the cell of the player.
	 */
	public Cell getCell() {
		return this.cell;
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
	 * Gets the lifepoints of the Entity.
	 * 
	 * @return the lifepoints of the Entity.
	 */
    public int getLifepoints() {
        return this.Lifepoints;
    }

	/**
     * Sets the lifepoints of the Entity.
	 * 
     * @param Lifepoints the lifepoints of the Entity.
     */
	public void setLifepoints(int Lifepoints) {
        this.Lifepoints = Lifepoints;
    }

	/**
	 * Gets the action points of the Entity.
	 * 
	 * @return the action points of the Entity.
	 */
	public int getActionPoints() {
		return this.actionPoints;
	}

	/**
	 * Sets the action points of the Entity.
	 * 
	 * @param actionPoints the action points of the Entity.
	 */
	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}

	/**
	 * Gets the board of the Entity.
	 * 
	 * @return the board of the Entity.
	 */
	public Board getBoard(){
		return this.board;
	}

	/**
     * Sets the board of the Entity.
     * 
     * @param board the board of the Entity.
     */
	public void setBoard(Board board) {
        this.board = board;
    }

	/**
	 * Give if the entity is dead.
	 * 
	 * @return True if the entity is dead, false otherwise.
	 */
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
