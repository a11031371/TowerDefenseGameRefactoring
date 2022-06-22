package towerdefense;

public class Game {
	private int round = 0;
	private int totalMoney = 20;
	private boolean isHard = false;
	public void startRound() {
		round++;
	}
	public void setTotalMoney(int money) {
		this.totalMoney = money;
	}
	public void hardMode(String cmd) {
		if(cmd.equals("new game hard"))
			this.isHard = true;
	}
	public int getRound() {
		return round;
	}
	public int getTotalMoney() {
		return totalMoney;
	}
    public boolean isHard() {
    	return this.isHard;
    }
    public boolean isOver(Map map) {
		return !(map.getEnemies()[9]==null);
	}
}
