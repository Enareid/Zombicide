package leBoard;

public class Player {
    private int x;
    private int y;
    private Board board;
    private Room currentRoom;

    public Player(Board board, int startingX, int startingY) {
        this.board = board;
        this.x = startingX;
        this.y = startingY;
        this.currentRoom = this.board.getRoom(startingX, startingY);
        this.currentRoom.setPlayer(this);
    }

    public void move(String direction) {
        switch (direction) {
            case "UP":
                if (this.y > 0) {
                    Room destinationRoom = this.board.getRoom(this.x, this.y - 1);
                    Door door = destinationRoom.getDoor(Direction.UP);
                    if (!door.isLocked()) {
                        this.y--;
                        this.currentRoom = destinationRoom;
                        this.currentRoom.setPlayer(this);
                    } else {
                        System.out.println("The door is locked!");
                    }
                }
                break;
            case "DOWN":
                if (this.y < this.board.getHeight() - 1) {
                    Room destinationRoom = this.board.getRoom(this.x, this.y + 1);
                    Door door = destinationRoom.getDoor(Direction.DOWN);
                    if (!door.isLocked()) {
                        this.y++;
                        this.currentRoom = destinationRoom;
                        this.currentRoom.setPlayer(this);
                    } else {
                        System.out.println("The door is locked!");
                    }
                }
                break;
            case "LEFT":
                if (this.x > 0) {
                    Room destinationRoom = this.board.getRoom(this.x - 1, this.y);
                    Door door = destinationRoom.getDoor(Direction.LEFT);
                    if (!door.isLocked()) {
                        this.x--;
                        this.currentRoom = destinationRoom;
                        this.currentRoom.setPlayer(this);
                    } else {
                        System.out.println("The door is locked!");
                    }
                }
                break;
            case "RIGHT":
                if (this.x < this.board.getWidth() - 1) {
                    Room destinationRoom = this.board.getRoom(this.x + 1, this.y);
                    Door door = destinationRoom.getDoor(Direction.RIGHT);
                    if (!door.isLocked()) {
                        this.x++;
                        this.currentRoom = destinationRoom;
                        this.currentRoom.setPlayer(this);
                    } else {
                        System.out.println("The door is locked!");
                    }
                }
                break;
            default:
                System.out.println("Invalid direction!");
        }
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}