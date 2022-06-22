package towerdefense;

public class Tesla extends Building{
	public int getUpgradeCost() {
		return 5 *level;
	}
	public int getUpgradeCostHard() {
		return 8 *level;
	}
	public void powerUp() {
		power += 3;
	}
	public void powerDown() {
		power -= 3;
	}
}
