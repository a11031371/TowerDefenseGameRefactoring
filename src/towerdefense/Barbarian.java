package towerdefense;

public class Barbarian extends Enemy{
	public void useSkill(Game game, Map map) {
		Building[] buildings = map.getBuildings();
		System.out.println("�Ĥ�ϨϥX���Z�H���H���A�z�� X-Bow ���C 5 �I�����O�A���ŭ��C 1 ��");
		for(int i=9; i>=0; i--) {
			if(buildings[i].getName().equals("X-Bow")) {
				buildings[i].levelDown();
				buildings[i].powerDown();
			}
		}
	}
}
