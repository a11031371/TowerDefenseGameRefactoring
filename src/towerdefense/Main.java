package towerdefense;

public class Main{
	public static void main(String args[]){
		Game game = new Game();
		Map map = new Map();
		CommandDebugger cmdDebugger = new CommandDebugger();
		BuildingOperation buildingOperation = new BuildingOperation();
		EnemyOperation enemyOperation = new EnemyOperation();
		String cmd = "";
		System.out.println();
		Rule.rule();
		while(!cmdDebugger.checkNewGame(cmd)) {
			System.out.print("�п�ܼҦ��}�l�s�C��:");
			cmd = ConsoleIn.readLine();
			game.hardMode(cmd);
		}
		while(!game.isOver(map)) {
			while(!cmdDebugger.checkStartRound(cmd)) {
				System.out.print("�п�J start round �}�l�s�^�X:");
				cmd = ConsoleIn.readLine();
			}
			game.startRound();
			System.out.println("��"+ game.getRound() +"�^�X");
			while(true) {
				System.out.println(" ==========");
				System.out.println("�U�ؿv���q�U");
				System.out.println(" ==========");
				System.out.println("�ثe�֦�"+ game.getTotalMoney() +"��"); //money information
				System.out.print("�ؿv��m(�ӫؿv����):");
				for(int k=0; k<10; k++){
					if(map.getBuildings()[k]!= null) {
						System.out.print("("+(k+1)+","+map.getBuildings()[k].getName()+")");
					}
				}
				System.out.println();
				System.out.print("�ĤH��m:");
				for(int k=0; k<10; k++){
					if(map.getEnemies()[k]!= null){
						System.out.print("("+(k+1)+","+map.getEnemies()[k].getName()+") "); //enemies coordinates
					}
				}
				System.out.println();
				map.printMap();
				System.out.print("�п�J���O:");
				cmd = ConsoleIn.readLine();
				int space = cmd.indexOf(" ");
				if(space==-1) {
					if(cmd.equals("exit")){
						System.out.println("�C������");
						System.out.println("�z���L�F"+(game.getRound()-1)+"�^�X"); //game result
						System.exit(0);
					}
					if(cmd.equals("skip")){
						for(int g=0;g<30;g++){
							System.out.println(" ");
						}
						System.out.println(" ��"+game.getRound()+"�^�X");
						System.out.println(" ==========");
						System.out.println("�U�ĤH���q�U");
						System.out.println(" ==========");
						System.out.println("  �ĤH�e�i!!"); //skip and enter the next stage
						break;
					}
				}
				else {
					if(cmd.equals("help me")) Rule.rule();
					else {
						String[] instrArray = cmdDebugger.getInstruction(cmd,space);
						if(instrArray!=null) {
							if(instrArray[0].equals("build")) {
								buildingOperation.build(instrArray[1], instrArray[2], game, map);
							}
							else if(instrArray[0].equals("upgrade")) {
								buildingOperation.upgrade(instrArray[1], instrArray[2], game, map);
							}
							else if(instrArray[0].equals("destroy")) {
								buildingOperation.destroy(instrArray[1], map);
							}
							else System.out.println("��J���~�A�Э��s��J");
						}
						else System.out.println("��J���~�A�Э��s��J");
					}
				}
			}
			enemyOperation.enemyGoForward(map);
			Enemy enemy = enemyOperation.generateEnemy(game.getRound());
			enemyOperation.putOnMap(map, enemy);
			if(!game.isHard()) {
				enemyOperation.attack(game, map);
			}
			map.printMap();
			System.out.println("��"+ game.getRound() +"�^�X");
			System.out.println(" ==========");
			System.out.println("�U�������q�U");
			System.out.println(" ==========");
			System.out.println("  ���m�ؿv����!!");//�i�J�������q
			if(!game.isHard()) {
				buildingOperation.attack(game, map);
			}
			map.printMap();
		}
		System.out.println("�C������");
		System.out.println("�z���L�F"+(game.getRound()-1)+"�^�X"); //game result
	}
	
}