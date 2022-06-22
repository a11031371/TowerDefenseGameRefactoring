package towerdefense;

public class Goblin extends Enemy{
	public void useSkill(Game game, Map map) {
		System.out.println("敵方使出哥布林的詭計，您只剩下 80% 的金幣");
		game.setTotalMoney((int)(game.getTotalMoney()*0.8));
	}
}
