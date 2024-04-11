package game.Equipements;

import game.Equipement;
import game.Entities.Player;
import game.Entities.Zombie;

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


    public int dice(){
        return (int)(Math.random() * 6 + 1);
    }

    public int[] getrange(){
        int[] res= new int[2];
        res[0]=this.minrange;
        res[1]=this.maxrange;
        return res;
    }

    public void use(Player player, Zombie zombie){
        if (this.damage<=zombie.getresistance()){
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
