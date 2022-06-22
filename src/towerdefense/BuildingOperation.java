package towerdefense;

import java.util.ArrayList;
import java.lang.Math;

public class BuildingOperation implements Operation{
	

	public void build(String Bn, String location, Game game, Map map) {
		Building[] buildings = map.getBuildings();
		ArrayList<Integer> buildingList = map.getBuildingList();
		int loc = Integer.parseInt(location);
		int cost;
		int money = game.getTotalMoney();
		if(buildings[loc-1]==null) {
			if(Bn.equals("B1")) {
				Building mortar = new Mortar();
				setMortar(mortar);
				cost = mortar.getCost();
				if(money>=cost) {
					buildings[loc-1] = mortar;
					buildingList.add(loc);
					game.setTotalMoney(money-cost);
					map.setBuildings(buildings);
					map.setBuildingList(buildingList);
				}
				else System.out.println("餘額不足");
			}
			if(Bn.equals("B2")) {
				Building tesla = new Tesla();
				setTesla(tesla);
				cost = tesla.getCost();
				if(money>=cost) {
					buildings[loc-1] = tesla; 
					buildingList.add(loc);
					game.setTotalMoney(money-cost);
					map.setBuildings(buildings);
					map.setBuildingList(buildingList);
				}
				else System.out.println("餘額不足");
			}
			if(Bn.equals("B3")) {
				Building xbow = new XBow();
				setXBow(xbow);
				cost = xbow.getCost();
				if(money>=cost) {
					buildings[loc-1] = xbow;
					buildingList.add(loc);
					game.setTotalMoney(money-cost);
					map.setBuildings(buildings);
					map.setBuildingList(buildingList);
				}
				else System.out.println("餘額不足");
			}
		}
		else System.out.println("此地已有防禦建築，請勿再建築");
	}
	public void upgrade(String location, String times, Game game, Map map) {
		Building[] buildings = map.getBuildings();
		int loc = Integer.parseInt(location);
		int time = Integer.parseInt(times);
		if(buildings[loc-1]!=null) {
			for(int t=1;t<=time;t++) {
				int upgradeCost;
				if(game.isHard()) upgradeCost = buildings[loc-1].getUpgradeCostHard();
				else upgradeCost = buildings[loc-1].getUpgradeCost();
				int money = game.getTotalMoney();
				if(money>=upgradeCost) {
					game.setTotalMoney(money-upgradeCost);
					buildings[loc-1].levelUp();
					buildings[loc-1].powerUp();
					map.setBuildings(buildings);
				}
				else {
					System.out.println("第"+t+"次升級失敗，餘額不足");
				}
			}
		}
		else System.out.println("此地無防禦建築");
	}
	public void destroy(String location, Map map) {
		Building[] buildings = map.getBuildings();
		ArrayList<Integer> buildingList = map.getBuildingList();
		int loc = Integer.parseInt(location);
		if(buildings[loc-1]!=null) {
			buildings[loc-1]=null;
			buildingList.remove(buildingList.indexOf(loc));
			map.setBuildings(buildings);
			map.setBuildingList(buildingList);
		}
		else System.out.println("此地無防禦建築");
	}
	public void attack(Game game, Map map) {
		Building[] buildings = map.getBuildings();
		Enemy[] enemies = map.getEnemies();
		ArrayList<Integer> buildingList = map.getBuildingList();
		for(int i=0; i<buildingList.size(); i++) {
			int loc = buildingList.get(i)-1;
			Building building = buildings[loc];
			int[] range = building.getRange();
			if(game.isHard() && building.getName().equals("Tesla")) {
				for(int p=loc+range[1]; p>=loc-range[1]; p--) {
					enemies[p].setLife(enemies[p].getLife()-building.getPower());
					if(enemies[p].getLife()<=0) {
						game.setTotalMoney(game.getTotalMoney()+enemies[p].getReward());
						enemies[p]=null;
					}
				}
			}
			else {
				int targetIndex = -1;
				for(int p=9; p>=0; p--) {
					if(enemies[p]!=null) {
						if(Math.abs(p-loc)>=range[0] && Math.abs(p-loc)<=range[1]) {
							targetIndex = p;  //get the position index of the target enemy
							break;
						}
					}
				}
				if(targetIndex!=-1) {
					Enemy target = enemies[targetIndex];
					int life = target.getLife();
					target.setLife(life-building.getPower());
					if(target.getLife()<=0) {
						if(game.isHard() && target.getName().equals("Dragon")) {
							target.useSkill(game, map);
							for(int p=9; p>=0; p--) {
								if(enemies[p]!=null) {
									enemies[p].setLife(enemies[p].getLife()+5*target.getLevel());
								}
							}
						}
						game.setTotalMoney(game.getTotalMoney()+target.getReward());
						enemies[targetIndex]=null;
					}
				}
			}
		}
		map.setEnemies(enemies);
	}
	public void setMortar(Building building) {
		building.setName("Mortar");
		building.setPower(25);
		building.setLevel(1);
		building.setCost(20);
		building.setRange(2, 6);
	}
	public void setTesla(Building building) {
		building.setName("Tesla");
		building.setPower(10);
		building.setLevel(1);
		building.setCost(15);
		building.setRange(0, 1);
	}
	public void setXBow(Building building) {
		building.setName("X-Bow");
		building.setPower(15);
		building.setLevel(1);
		building.setCost(25);
		building.setRange(3, 5);
	}
	
}
