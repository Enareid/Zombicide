package game;
import game.Direction;

public class Door {

    /** If the door is locked */
    private boolean isLocked;
    /** The direction of the door */
    private Direction direction;

    /**
     * Builds a new door.
     * @param direction the direction of the door.
     */
    public Door(Direction direction) {
        this.isLocked = true;
        this.direction = direction;
    }

    /**
     * Locks the door.
     */
    public void lock() {
        this.isLocked = true;
    }

    /**
     * Unlocks the door.
     */
    public void unlock() {
        this.isLocked = false;
    }

    /**
     * Returns if the door is locked.
     * @return if the door is locked.
     */
    public boolean isLocked() {
        return this.isLocked;
    }

    /**
     * Returns the direction of the door.
     * @return the direction of the door.
     */
    public Direction getDirection() {
        return this.direction;
    }
}