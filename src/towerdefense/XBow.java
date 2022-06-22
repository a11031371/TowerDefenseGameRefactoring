package towerdefense;

public class XBow extends Building{
	public int getUpgradeCost() {
		return 15 *level;
	}
	public int getUpgradeCostHard() {
		return 15 *level;
	}
	public void powerUp() {
		power += 5;
	}
	public void powerDown() {
		power -= 5;
	}
}
