/**
 * The `game.Entities` package contains classes that represent various entities in the game.
 * These entities include characters, objects, and other elements that interact within the game world.
 */
package game.Entities;

import java.util.Random;

import game.Board;
import game.Cell;
import game.Direction;
import game.Entity;
import game.Cells.BuildingCell;
import game.Cells.StreetCell;

/** The Zombie class extends Entity class */
public class Zombie extends Entity {

	/** The Damage points of the zombie */
    protected int Damage;
	/** The action points of the zombie */
    protected int actionPoint;
	/** If the zombie have a superArmor */
    protected boolean superArmor;
	/** The resistance points of the zombie */
	protected int resistance;

    /**
     * Builds a new zombie.
     * 
     * @param Lifepoints the lifepoints of the zombie.
	 * @param Damage the Damage points of the zombie.
	 * @param board the board of the zombie.
	 * @param actionPoint the action points of the zombie.
	 * @param superArmor if the zombie have a superArmor.
     * @param cell the cell of the zombie.
	 * @param resistance the resistance points of the zombie.
     */
    public Zombie(int Lifepoints, int Damage, Board board, int actionPoint, Boolean superArmor, Cell cell,int resistance){
        super(Lifepoints, cell, board, actionPoint);
				this.resistance=resistance;
				this.Damage=Damage;
				this.superArmor=superArmor;
    }

	/**
	 * Returns the resistance of the zombie.
	 *
	 * @return the resistance of the zombie
	 */
	public int getResistance(){
		return this.resistance;
	}

	/**
	 * Reduces the zombie's lifepoints by the specified amount of damage.
	 *
	 * @param damage the amount of damage to be taken by the zombie
	 */
	public void takeDamage(int damage) {
		this.Lifepoints -= damage;
	}

	/**
 	 * Moves the zombie one cell to the north on the game board.
 	 * If the zombie is already at the top row, the move is not performed.
 	 */
    public void moveNorth() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
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

	/**
	 * Moves the zombie one cell to the south on the game board.
	 * If the zombie is already at the bottom of the board, the move is not performed.
	 */
	public void moveSouth() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
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

	/**
	 * Moves the zombie one cell to the east on the game board.
	 * If the zombie is already at the rightmost column, it does not move.
	 */
	public void moveEast() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
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

	/**
	 * Moves the zombie one cell to the west on the game board.
	 * If the zombie is already at the leftmost column, the move is not performed.
	 */
	public void moveWest() {
		Cell[][] coord = board.getCells();
		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
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
	/**
	 * Moves the zombie towards the nearest player on the game board.
	 * The zombie can move in four directions: north, south, east, and west.
	 * The movement is determined by the positions of the zombie and the nearest player,
	 * as well as the availability of cells in the corresponding directions.
	 */
	public void moveTowardsPlayer(){
		Cell[][] cells = board.getCells();
		Player nearestPlayer = getNearestPlayer();
		if (nearestPlayer == null) {
			return;
		}

		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		int xPlayer = nearestPlayer.getCell().getCoord()[0];
		int yPlayer = nearestPlayer.getCell().getCoord()[1];
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

	/**
	 * Moves the zombie towards the cell with the highest noise level on the game board.
	 */
	public void moveTowardsNoise(){
		Cell[][] cells = board.getCells();
		Cell maxNoiseCell = board.getMaxNoise();

		int x = this.cell.getCoord()[0];
		int y = this.cell.getCoord()[1];
		int xMaxNoiseCell = maxNoiseCell.getCoord()[0];
		int yMaxNoiseCell = maxNoiseCell.getCoord()[1];
		boolean canMoveNorth = (x > 0) && ((cells[x-1][y] instanceof StreetCell) || ((cells[x-1][y] instanceof BuildingCell) && !(cells[x-1][y].isLocked(Direction.SOUTH))));
		boolean canMoveSouth = (x < board.getSize() - 1) && ((cells[x+1][y] instanceof StreetCell) || ((cells[x+1][y] instanceof BuildingCell) && !(cells[x+1][y].isLocked(Direction.NORTH))));
		boolean canMoveEast = (y < board.getSize() - 1) && ((cells[x][y+1] instanceof StreetCell) || ((cells[x][y+1] instanceof BuildingCell) && !(cells[x][y+1].isLocked(Direction.WEST))));
		boolean canMoveWest = (y > 0) && ((cells[x][y-1] instanceof StreetCell) || ((cells[x][y-1] instanceof BuildingCell) && !(cells[x][y-1].isLocked(Direction.EAST))));

		if (x < xMaxNoiseCell && canMoveSouth) {
			moveSouth();
		} else if (x > xMaxNoiseCell && canMoveNorth) {
			moveNorth();
		} else if (y < yMaxNoiseCell && canMoveEast) {
			moveEast();
		} else if (y > yMaxNoiseCell && canMoveWest) {
			moveWest();
		}
	}

	public void move(){
		if(this.board.getMaxNoise().getNoiseLevel() != 0){
			this.moveTowardsNoise();
		}
		else{
			this.moveTowardsPlayer();
		}
	}

	/**
	 * Returns the nearest player to the zombie.
	 *
	 * @return the nearest player to the zombie, or null if no players are present on the board.
	 */
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

	/**
 	* Attacks the nearest player and reduces their life points by the zombie's damage.
	*
	* @param player the player to be attacked by the zombie.
 	*/
     public void attack(Player player){
		player.setLifepoints(player.getLifepoints() - this.Damage);
     }

	 /**
	  * Performs the zombie's action.
	  */
	 public void action(){
		for(int i = 0; i < this.actionPoints; i++){
			if(this.getCell().getPlayers().size() != 0){
				int randomNum = new Random().nextInt(this.getCell().getPlayers().size());
				Player randomPlayer = this.getCell().getPlayers().get(randomNum); 
				this.attack(randomPlayer);
			}
			else{
				this.move();
			}
		}
	}
}