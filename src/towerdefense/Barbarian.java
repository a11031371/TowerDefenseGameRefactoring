package towerdefense;

public class Barbarian extends Enemy{
	public void useSkill(Game game, Map map) {
		Building[] buildings = map.getBuildings();
		System.out.println("敵方使使出野蠻人的咆哮，您的 X-Bow 降低 5 點攻擊力，等級降低 1 級");
		for(int i=9; i>=0; i--) {
			if(buildings[i].getName().equals("X-Bow")) {
				buildings[i].levelDown();
				buildings[i].powerDown();
			}
		}
	}
}
