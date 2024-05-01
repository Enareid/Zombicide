package game.Equipements;

import game.Equipement;
import game.Entities.Player;
import game.Entities.Zombie;
import game.Entities.Players.Lucky;

/** The Weapon class extends Equipement class */
public class Weapon extends Equipement{

    /** The seuil who weapon succes his attack */
    protected int seuil;
    /** The damage of the weapon */
    protected int damage;
    /** The minimum range of the weapon */
    protected int minrange;
    /** The maximum range of the weapon */
    protected int maxrange;
    /** The number of times the weapon can be used */
    protected int attempts;
    
    /**
     * Builds a new Weapon.
     * 
     * @param seuil the seuil of the weapon
     * @param damage the damage of the weapon
     * @param minrange the minimum range of the weapon
     * @param maxrange the maximum range of the weapon
     * @param attempts the number of times the weapon can be used
     */
    public Weapon(int seuil, int damage, int minrange, int maxrange, int attempts){
        super();
        this.seuil = seuil;
        this.damage = damage;
        this.minrange = minrange;
        this.maxrange = maxrange;
        this.attempts = attempts;
    }

    /**
     * Returns the seuil of the weapon.
     * 
     * @return the seuil of the weapon
     */
    public int getSeuil(){
        return this.seuil;
    }

    /**
     * Set the seuil of the weapon.
     * 
     * @param seuil the seuil of the weapon
     */
    public void setSeuil(int seuil){
        this.seuil = seuil;
    }

    /**
     * Returns the damage of the weapon.
     * 
     * @return the damage of the weapon
     */
    public int getDamage(){
        return this.damage;
    }

    /**
     * Set the damage of the weapon.
     * 
     * @param damage the damage of the weapon
     */
    public void setDamage(int damage){
        this.damage = damage;
    }

    /**
     * Returns the number of dice to roll for the weapon.
     * 
     * @return the number of dice to roll for the weapon
     */
    public int getAttempts(){
        return this.attempts;
    }

    /**
     * Set the number of dice to roll for the weapon.
     * 
     * @param attempts the number of dice to roll for the weapon
     */
    public void setAttempts(int attempts){
        this.attempts = attempts;
    }

    /**
     * Returns range of the weapon.
     * 
     * @return range of the weapon
     */
    public int[] getRange(){
        int[] res= new int[2];
        res[0]=this.minrange;
        res[1]=this.maxrange;
        return res;
    }

    /**
     * Set the range of the weapon.
     * 
     * @param minrange the minimum range of the weapon
     * @param maxrange the maximum range of the weapon
     */
    public void setRange(int minrange, int maxrange){
        this.minrange = minrange;
        this.maxrange = maxrange;
    }

    /**
     * Use the weapon.
     * 
     * @param player the player using the weapon
     * @param zombie the zombie being attacked
     */
    public void use(Player player, Zombie zombie){
        int dice = 0;
        for (int i = 0; i < this.attempts; i++){
            dice += player.dice();
        }
        if (player instanceof Lucky){
            dice += player.dice();
        }
        if (this.damage<=zombie.getResistance()){
            System.out.println(zombie+" cannot be damaged by "+this);
        }
        else if (dice >= this.seuil){
            zombie.takeDamage(damage);
            System.out.println("You hit the zombie " + zombie);
        }
        else{
            System.out.println("You missed your shot");
        }
    }
}
