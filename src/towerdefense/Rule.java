package towerdefense;

public class Rule{
	public static void rule(){
		System.out.println("*************************************************歡迎來到簡易塔防遊戲**************************************************");
		System.out.println(" ");
		System.out.println("遊戲說明： 面對敵人的步步逼近，您必須阻止他們到達目的地，利用您所擁有的防禦建築打倒他們!");
		System.out.println("戰場為2*10的棋盤格，上排提供您建築防禦工事，下排則為敵人進攻路線，每回合將產生新敵人於下排");
		System.out.println("第一格，您必須讓敵人無法到達目的地(下排第10格)並撐過更多回合，若敵人到達目的地則遊戲結束");
		System.out.println(" ");
		System.out.println("本遊戲設有兩種難度:normal(基本)，hard(困難)");
		System.out.println("困難模式說明:在困難模式下，敵人不會坐以待斃，他們將會以自身的力量進行反撲(敵人的反撲皆在該回合攻擊階段後)");
		System.out.println("1.哥布林的詭計:每 5 回合，若您的場上有 Goblin，您將被扣除 20% 的金錢");
		System.out.println("2.野蠻人的咆哮:每 10 回合，若您的場上有 Barbarian，您的 X-Bow 將受到野蠻人的虛弱效果，power-5");
		System.out.println("3.飛龍之力:當場上的飛龍死亡時，將觸發飛龍之力，增加全場敵人(5*自身等級)的血量");
		System.out.println(" ");
		System.out.println("每回合皆有三階段:");
		System.out.println("1.建築階段：您可以根據目前持有的金錢購買、升級或消除建築");    
		System.out.println("  建築指令: 建築:build [防禦建築編號] [位置] (ex:build B1 3)");    
		System.out.println("         升級:upgrade [位置] [升級次數] (ex:upgrade 5 1)");                
		System.out.println("         消除:destroy [位置] (ex:destroy 8)");
		System.out.println("2.敵人階段：敵人將前進一格，且新敵人等級隨回合數增加");
		System.out.println("  *新敵人將以 Goblin-Goblin-Barbarian-Barbarian-Dragon 為循環產生");
		System.out.println("3.攻擊階段：依據您建築的位置與特性攻擊敵人");
        System.out.println(" ");
		System.out.println("防禦建築列表(若為困難模式則 Tesla 的升級花費為 8*level):");
        System.out.println(" ---------------------------------------------------------------------------------------");
		System.out.println("｜ Number ｜ Building ｜ Cost ｜ Power｜ Atk Times ｜ Range ｜ Upgrade Cost ｜ Upgrade Power ｜");
		System.out.println(" ---------------------------------------------------------------------------------------");
		System.out.println("｜   B1   ｜  Mortar  ｜  20  ｜  25  ｜     1     ｜  2-6  ｜   10*level   ｜   power+=5    ｜");
		System.out.println("｜   B2   ｜  Tesla   ｜  15  ｜  10  ｜     1     ｜  0-1  ｜    5*level   ｜   power+=3    ｜");
		System.out.println("｜   B3   ｜  X-Bow   ｜  25  ｜  15  ｜     2     ｜  3-5  ｜   15*level   ｜   power+=5    ｜");
		System.out.println(" ---------------------------------------------------------------------------------------");
		System.out.println("敵人列表:");
		System.out.println(" ------------------------------------");
		System.out.println("｜   Enemy    ｜    Life   ｜  Reward  ｜");
		System.out.println(" ------------------------------------");
		System.out.println("｜   Goblin   ｜  15*level ｜ 10*level ｜");
		System.out.println("｜  Barbarian ｜  30*level ｜ 15*level ｜");
		System.out.println("｜   Dragon   ｜  50*level ｜ 20*level ｜");
		System.out.println(" ------------------------------------");
		System.out.println(" ");
		System.out.println("注意事項:");
		System.out.println("1.請輸入 new game [難度] 來選擇遊戲模式 (ex:new game normal)");
		System.out.println("2.遊戲開始時您將有 20 元");
		System.out.println("3.若在建築階段欲停止遊戲，請輸入 exit");
		System.out.println("4.每回合建築階段建築結束時，請輸入 skip 以結束建築階段");
		System.out.println("5.防禦建築將會依照您建築的先後順序進行攻擊"); 
		System.out.println("6.防禦建築將優先攻擊範圍內編號最大(最右邊)的敵人");
		System.out.println("7.困難模式下 Tesla 的攻擊為範圍攻擊(範圍內的敵人皆受攻擊)");
		System.out.println("8.若遊戲進行中，您需獲得資訊，請在建築階段輸入 help me");
		System.out.println(" ");
		System.out.println("*******************************************請詳細閱讀再進行遊戲，祝遊戲愉快********************************************");
	}
	
}