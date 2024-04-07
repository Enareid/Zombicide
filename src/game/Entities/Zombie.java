package game.Entities;

import game.Board;
import game.Cell;
import game.Direction;
import game.Entity;
import game.Cells.BuildingCell;
import game.Cells.StreetCell;

public abstract class Zombie extends Entity {

    protected int Damage;
    protected int actionPoint;
    protected boolean superArmor;

    /**
     * Builds a new zombie.
     * 
     * @param Lifepoints the lifepoints of the zombie.
     * @param cell the cell of the zombie.
     */
    public Zombie(int Lifepoints, int Damage, Board board, int actionPoint, boolean bool, Cell cell){
        super(Lifepoints,cell, board);
    }

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	public Cell getCell() {
		return this.cell;
	}


    public void moveNorth() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
		if (x > 0) {
			try{
				coord[x][y].removeZombie(this);
				coord[x-1][y].setZombie(this);
				this.setCell(coord[x-1][y]);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}

	public void moveSouth() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
		if (x < board.getSize() - 1) {
			try{
				coord[x][y].removeZombie(this);
				coord[x+1][y].setZombie(this);
				this.setCell(coord[x+1][y]);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}

	public void moveEast() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
		if (y < board.getSize() - 1) {
			try{
				coord[x][y].removeZombie(this);
				coord[x][y+1].setZombie(this);
				this.setCell(coord[x][y+1]);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}

	public void moveWest() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
		if (y > 0) {
			try{
				coord[x][y].removeZombie(this);
				coord[x][y-1].setZombie(this);
				this.setCell(coord[x][y-1]);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}

	public Player getNearestPlayer() {
		Player nearestPlayer = null;
		double minDistance = Double.MAX_VALUE;

		for (Player player : board.getPlayers()) {
			double distance = calculateDistance(player.getCell(), this.getCell());
			if (distance < minDistance) {
				minDistance = distance;
				nearestPlayer = player;
			}
		}

		return nearestPlayer;
	}

	private double calculateDistance(Cell cell1, Cell cell2) {
		int x1 = cell1.getcoord()[0];
		int y1 = cell1.getcoord()[1];
		int x2 = cell2.getcoord()[0];
		int y2 = cell2.getcoord()[1];

		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	public void move(){
		Cell[][] cells = board.getCells();
		Player nearestPlayer = getNearestPlayer();
		if (nearestPlayer == null) {
			return;
		}

		int x = this.cell.getcoord()[0];
		int y = this.cell.getcoord()[1];
		int xPlayer = nearestPlayer.getCell().getcoord()[0];
		int yPlayer = nearestPlayer.getCell().getcoord()[1];
		boolean canMoveNorth = (x > 0) && ((cells[x-1][y] instanceof StreetCell) || ((cells[x-1][y] instanceof BuildingCell) && !(cells[x-1][y].isLocked(Direction.SOUTH))));
		boolean canMoveSouth = (x < board.getSize() - 1) && ((cells[x+1][y] instanceof StreetCell) || ((cells[x+1][y] instanceof BuildingCell) && !(cells[x+1][y].isLocked(Direction.NORTH))));
		boolean canMoveEast = (y < board.getSize() - 1) && ((cells[x][y+1] instanceof StreetCell) || ((cells[x][y+1] instanceof BuildingCell) && !(cells[x][y+1].isLocked(Direction.WEST))));
		boolean canMoveWest = (y > 0) && ((cells[x][y-1] instanceof StreetCell) || ((cells[x][y-1] instanceof BuildingCell) && !(cells[x][y-1].isLocked(Direction.EAST))));

		if (x < xPlayer && canMoveSouth) {
			moveSouth();
		} else if (x > xPlayer && canMoveNorth) {
			moveNorth();
		} else if (y < yPlayer && canMoveEast) {
			moveEast();
		} else if (y > yPlayer && canMoveWest) {
			moveWest();
		}
	}

}