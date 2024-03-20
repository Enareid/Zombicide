package game.Equipements;

import game.Equipement;

public abstract class Weapon extends Equipement{

    protected int seuil;
    protected int damage;
    protected int range;
    protected int attempts;
    
    public Weapon(int seuil, int damage, int range, int attempts){
        super();
        this.seuil = seuil;
        this.damage = damage;
        this.range = range;
        this.attempts = attempts;
    }
    
}
