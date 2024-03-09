package game.Entities;
import game.Equipement;
import game.Cell;
import game.Entity;
import java.util.*;

public abstract class Player extends Entity{
    protected List<Equipement> bag;
    private int actionPoints;
	private int expertiseLevel;
    static final int MAX_LIFE_LEVEL = 5;


    /**
     * Builds a new player.
     */
    public Player(int Lifepoints, Cell cell, int expertiseLevel, int actionPoints){
        super(Lifepoints,cell);
        this.expertiseLevel = expertiseLevel;
        this.actionPoints = actionPoints;
        this.bag = new ArrayList<>();
    }
    
    public int getActionPoints() {
		return actionPoints;
	}
    
	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}
    
	public int getExpertiseLevel() {
		return expertiseLevel;
	}

	public void setExpertiseLevel(int expertiseLevel) {
		this.expertiseLevel = expertiseLevel;
	}

    public int getLifeLevel() {
		return Lifepoints;
	}
   
	public void setLifeLevel(int Lifepoints) {
		this.Lifepoints = Lifepoints;
	}
    
	public List<Equipement> getEquipments() {
		return bag;
	}
    public void setEquipment(Equipement bag) {
		this.bag.add(bag);
	}
    public int getMaxLifeLevel() {
		return MAX_LIFE_LEVEL;
	}



}
