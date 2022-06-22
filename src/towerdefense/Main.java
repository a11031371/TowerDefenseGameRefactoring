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
			System.out.print("請選擇模式開始新遊戲:");
			cmd = ConsoleIn.readLine();
			game.hardMode(cmd);
		}
		while(!game.isOver(map)) {
			while(!cmdDebugger.checkStartRound(cmd)) {
				System.out.print("請輸入 start round 開始新回合:");
				cmd = ConsoleIn.readLine();
			}
			game.startRound();
			System.out.println("第"+ game.getRound() +"回合");
			while(true) {
				System.out.println(" ==========");
				System.out.println("｜建築階段｜");
				System.out.println(" ==========");
				System.out.println("目前擁有"+ game.getTotalMoney() +"元"); //money information
				System.out.print("建築位置(照建築順序):");
				for(int k=0; k<10; k++){
					if(map.getBuildings()[k]!= null) {
						System.out.print("("+(k+1)+","+map.getBuildings()[k].getName()+")");
					}
				}
				System.out.println();
				System.out.print("敵人位置:");
				for(int k=0; k<10; k++){
					if(map.getEnemies()[k]!= null){
						System.out.print("("+(k+1)+","+map.getEnemies()[k].getName()+") "); //enemies coordinates
					}
				}
				System.out.println();
				map.printMap();
				System.out.print("請輸入指令:");
				cmd = ConsoleIn.readLine();
				int space = cmd.indexOf(" ");
				if(space==-1) {
					if(cmd.equals("exit")){
						System.out.println("遊戲結束");
						System.out.println("您撐過了"+(game.getRound()-1)+"回合"); //game result
						System.exit(0);
					}
					if(cmd.equals("skip")){
						for(int g=0;g<30;g++){
							System.out.println(" ");
						}
						System.out.println(" 第"+game.getRound()+"回合");
						System.out.println(" ==========");
						System.out.println("｜敵人階段｜");
						System.out.println(" ==========");
						System.out.println("  敵人前進!!"); //skip and enter the next stage
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
							else System.out.println("輸入錯誤，請重新輸入");
						}
						else System.out.println("輸入錯誤，請重新輸入");
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
			System.out.println("第"+ game.getRound() +"回合");
			System.out.println(" ==========");
			System.out.println("｜攻擊階段｜");
			System.out.println(" ==========");
			System.out.println("  防禦建築攻擊!!");//進入攻擊階段
			if(!game.isHard()) {
				buildingOperation.attack(game, map);
			}
			map.printMap();
		}
		System.out.println("遊戲結束");
		System.out.println("您撐過了"+(game.getRound()-1)+"回合"); //game result
	}
	
}