package game.Equipements;

import game.Equipement;
import game.Entities.Player;
import game.Entities.Zombie;

/** The Weapon class extends Equipement class */
public abstract class Weapon extends Equipement{

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
     * Emulate a dice.
     * 
     * @return a random number between 1 and 6
     */
    public int dice(){
        return (int)(Math.random() * 6 + 1);
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
     * Use the weapon.
     * 
     * @param player the player using the weapon
     * @param zombie the zombie being attacked
     */
    public void use(Player player, Zombie zombie){
        if (this.damage<=zombie.getResistance()){
            System.out.println(zombie+" cannot be damaged by "+this);
        }
        else if (this.dice() >= this.seuil){
            zombie.takeDamage(damage);
            System.out.println("You hit the zombie");
        }
        else{
            System.out.println("You missed your shot");
        }
        System.out.println(zombie.getLifepoints());
    }
}
