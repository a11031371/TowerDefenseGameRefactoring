package towerdefense;

public class Mortar extends Building{
	public int getUpgradeCost() {
		return 10 *level;
	}
	public int getUpgradeCostHard() {
		return 10 *level;
	}
	public void powerUp() {
		power += 5;
	}
	public void powerDown() {
		power -= 5;
	}
}
