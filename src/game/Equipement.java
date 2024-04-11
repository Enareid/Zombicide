package game;
import game.Entities.Player;


public abstract class Equipement{

	protected boolean canOpenDoor;
	protected boolean isWeapon;

    /**
     * Builds a new loot.
     */

	public Equipement() {
		this.canOpenDoor = false;
		this.isWeapon = false;
	}

	public void use(Player player, Object target) {
	}

	public boolean getCanOpenDoor() {
		return this.canOpenDoor;
	}

	public boolean getIsWeapon() {
		return this.isWeapon;
	}

}
