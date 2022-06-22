package towerdefense;

public abstract class Enemy {
	
	private String name;
	private int life;
	private int reward;
	private int level;
	
	//concrete method
	public void setName(String name) {
		this.name = name;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return this.name;
	}
	public int getLife() {
		return this.life;
	}
	public int getReward() {
		return this.reward;
	}
	public int getLevel() {
		return this.level;
	}
	
	//abstract method
	public abstract void useSkill(Game game, Map map);
}
