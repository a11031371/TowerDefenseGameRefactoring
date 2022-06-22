package towerdefense;

public class EnemyOperation implements Operation { 
	
	public void enemyGoForward(Map map) {
		for(int i=9; i>0; i--) {
			map.getEnemies()[i] = map.getEnemies()[i-1];
		}
	}
	
	public Enemy generateEnemy(int round) {
		int rnd = round %5;
		if(rnd==1||rnd==2){
			Enemy enemy = new Goblin();
			enemy.setName("Goblin");
			enemy.setLife(15*round);
			enemy.setReward(10*round);
			enemy.setLevel(round);
			return enemy;
		}
		else if(rnd==3||rnd==4){
			Enemy enemy = new Barbarian();
			enemy.setName("Barbarian");
			enemy.setLife(30*round);
			enemy.setReward(15*round);
			enemy.setLevel(round);
			return enemy;
		}
		else{
			Enemy enemy = new Dragon();
			enemy.setName("Dragon");
			enemy.setLife(50*round);
			enemy.setReward(20*round);
			enemy.setLevel(round);
			return enemy;
		}
	}
		
	public void putOnMap(Map map, Enemy enemy) {
		Enemy[] enemies = map.getEnemies();
		enemies[0]= enemy;
		map.setEnemies(enemies);
	}
	public void attack(Game game, Map map) {
		int round = game.getRound();
		if(round%5==0) {
			Enemy enemy = new Goblin();
			enemy.useSkill(game, map);
		}
	}
}
