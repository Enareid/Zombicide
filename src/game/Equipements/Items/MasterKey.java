package game.Equipements.Items;

import game.Door;
import game.Equipement;

public class MasterKey extends Equipement{

    public MasterKey(){
        super();
    }

    public void use(Door door){
        door.unlock();
    }
}
