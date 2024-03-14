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
    
}
