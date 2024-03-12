package game;

public abstract class Equipement{

    /**
     * Builds a new loot.
     */
    protected boolean isUsed ;
	
	public Equipement() {
		this.isUsed = false;
	}
	
	public boolean isUsed() {
		return this.isUsed;
	}
	public void use() {
		this.isUsed = true;
	}

}
