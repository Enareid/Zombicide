package game;

public abstract class Entity {

    protected int Lifepoints;
    protected Cell cell;

    /**
     * Builds a new entity.
     * @param Lifepoints the lifepoints of the entity.
     * @param cell the cell of the entity.
     */
    public Entity(int Lifepoints, Cell cell){
        this.Lifepoints=Lifepoints;
        this.cell=cell;
    }
    
}
