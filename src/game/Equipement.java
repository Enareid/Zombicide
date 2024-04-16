package game;
import game.Entities.Player;

/** The Equipement class */
public abstract class Equipement{

	/** If weapon can open door or not */
	protected boolean canOpenDoor;
	/** If the equipement is a weapon */
	protected boolean isWeapon;

    /**
     * Builds a new Equipement.
     */
	public Equipement() {
		this.canOpenDoor = false;
		this.isWeapon = false;
	}

	/**
	 * Returns if the equipement can open a door.
	 * 
	 * @return if the equipement can open a door
	 */
	public boolean getCanOpenDoor() {
		return this.canOpenDoor;
	}

	/**
	 * Returns if the equipement is a weapon.
	 * 
	 * @return if the equipement is a weapon
	 */
	public boolean getIsWeapon() {
		return this.isWeapon;
	}

	/**
	 * Uses the equipement.
	 * 
	 * @param player the player using the equipement
	 * @param target the target of the equipement
	 */
	public void use(Player player, Object target) {}

	/**
	 * Uses the equipement.
	 * 
	 * @param player the player using the equipement
	 * @throws Exception
	 */
	public void use(Player player) throws Exception{}
}
