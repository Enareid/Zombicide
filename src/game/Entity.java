package game;

public abstract class Entity {

    protected int Lifepoints;
    protected Cell cell;

    /**
     * Builds a new entity.
     */
    public Entity(int Lifepoints, Cell cell){
        this.Lifepoints=Lifepoints;
        this.cell=cell;
    }

    public void moveNorth() throws Exception{
        if (this.cell.getcoord()[0]==0 || this.cell.getcoord()[0]==0){
            throw new Exception("C'est pas légal");
        }


    }
    public void moveSouth(){

    }
    public void moveEast(){

    }
    public void moveWest(){

    }
    
}
