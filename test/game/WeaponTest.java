package game;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import game.Boards.ClassicalBoard;
import game.Entities.Player;
import game.Entities.Players.Fighter;
import game.Entities.Zombies.Runner;
import game.Equipements.Items.MasterKey;
import game.Equipements.Weapons.Gun;


public class WeaponTest extends EquipementTest{

    protected Equipement createEquipement(){
        return new Gun();
    }
    
    protected Equipement equipement;

    @BeforeEach 
    public void before() throws Exception{
        super.before();
        this.equipement = createEquipement();
    }
    
}
