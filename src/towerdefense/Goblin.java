package towerdefense;

public class Goblin extends Enemy{
	public void useSkill(Game game, Map map) {
		System.out.println("�Ĥ�ϥX�����L���ޭp�A�z�u�ѤU 80% ������");
		game.setTotalMoney((int)(game.getTotalMoney()*0.8));
	}
}
