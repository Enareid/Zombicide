package leBoard;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private Player player;
    private List<Door> doors;

    public Room() {
        this.doors = new ArrayList<>();
        // create 4 doors by default
        this.doors.add(new Door(Direction.UP));
        this.doors.add(new Door(Direction.DOWN));
        this.doors.add(new Door(Direction.LEFT));
        this.doors.add(new Door(Direction.RIGHT));
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void addDoor(Door door) {
        this.doors.add(door);
    }

    public void removeDoor(Door door) {
        this.doors.remove(door);
    }

    public List<Door> getDoors() {
        return this.doors;
    }

    public Door getDoor(Direction direction) {
        for (Door door : this.doors) {
            if (door.getDirection() == direction) {
                return door;
            }
        }
        return null;
    }
}