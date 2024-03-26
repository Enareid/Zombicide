package game;

import game.Entities.*;

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

    public void attack() {
        switch (this.toString()) {
            case "Fighter":
                System.out.println("Fighter !!");
                break;
    
        }
        System.out.println("OMG !!");
    }
    
}
