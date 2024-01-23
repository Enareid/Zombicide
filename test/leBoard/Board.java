package leBoard;

public class Board {
    private Room[][] rooms;
    private int width;
    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.rooms = new Room[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.rooms[x][y] = new Room();
            }
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
    
    public Room getRoom(int x, int y) {
        // return the Room object at the specified position
        return this.rooms[x][y];
    }


}