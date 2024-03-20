package game.Equipements;

import game.Equipement;

public abstract class Weapon extends Equipement{

    protected int seuil;
    protected int damage;
    protected int minrange;
    protected int maxrange;
    protected int attempts;
    
    public Weapon(int seuil, int damage, int minrange, int maxrange, int attempts){
        super();
        this.seuil = seuil;
        this.damage = damage;
        this.minrange = minrange;
        this.maxrange = maxrange;
        this.attempts = attempts;
    }
    
}
