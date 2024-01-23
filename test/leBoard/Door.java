package leBoard;

public class Door {
    private boolean isLocked;
    private Direction direction;

    public Door(Direction direction) {
        this.isLocked = true;
        this.direction = direction;
    }

    public void lock() {
        this.isLocked = true;
    }

    public void unlock() {
        this.isLocked = false;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
