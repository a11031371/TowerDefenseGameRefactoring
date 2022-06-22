package towerdefense;

public abstract class Building {
	
	protected String name;
	protected int power;
	protected int level;
	protected int cost;
	protected int[] range = new int[2];
	
	//concrete method
	public void setName(String name) {
		this.name = name;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public void setRange(int low, int high) {
		this.range[0] = low;
		this.range[1] = high;
	}
	public String getName() {
		return this.name;
	}
	public int getPower() {
		return this.power;
	}
	public int getLevel() {
		return this.level;
	}
	public int getCost() {
		return this.cost;
	}
	public int[] getRange() {
		return this.range;
	}
	public void levelUp() {
		this.level ++;
	}
	public void levelDown() {
		this.level --;
	}
	//abstract method
	public abstract int getUpgradeCost();
	public abstract int getUpgradeCostHard();
	public abstract void powerUp();
	public abstract void powerDown();
	
}
