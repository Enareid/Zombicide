package game;

public class Door {

    /** If the door is locked */
    private boolean isLocked;


    /**
     * Builds a new door.
     * @param direction the direction of the door.
     */
    public Door() {
        this.isLocked = true;
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

}