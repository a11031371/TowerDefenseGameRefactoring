package towerdefense;

import java.util.ArrayList;

public class Map {
	
	private Building[] buildings = new Building[10];
	private Enemy[] enemies = new Enemy[10];
	private ArrayList<Integer> buildingList = new ArrayList<Integer>();
	
	
	public void setBuildings(Building[] buildings) {
		this.buildings = buildings;
	}
	public void setEnemies(Enemy[] enemies) {
		this.enemies = enemies;
	}
	public Building[] getBuildings() {
		return buildings;
	}
	public Enemy[] getEnemies() {
		return enemies;
	}
	public void setBuildingList(ArrayList<Integer> buildingList) {
		this.buildingList = buildingList;
	}
	public ArrayList<Integer> getBuildingList() {
		return buildingList;
	}
    

	public void printMap() {
		System.out.println("     1          2           3          4          5          6          7          8          9          10  ");                                                                                                           
		System.out.println(" ------------------------------------------------------------------------------------------------------------- ");
		for(int i=0;i<10;i++){
			if(this.buildings[i]==null) System.out.print("|          ");
			else System.out.printf("|"+"%10s",this.buildings[i].getName());
		}
		System.out.println("|");
		for(int i=0;i<10;i++){
			if(this.buildings[i]==null) System.out.print("|          ");
			else System.out.printf("|power:"+"%4s",this.buildings[i].getPower());
		}
		System.out.println("|");
		for(int i=0;i<10;i++){
			if(this.buildings[i]==null) System.out.print("|          ");
			else System.out.printf("|level:"+"%4s",this.buildings[i].getLevel());
		}
		System.out.println("|");
		System.out.println(" ------------------------------------------------------------------------------------------------------------- ");
		for(int j=0;j<10;j++){
			if(this.enemies[j]==null) System.out.print("|          ");
			else System.out.printf("|"+"%10s",this.enemies[j].getName());
		}
		System.out.println("|");
		for(int j=0;j<10;j++){
			if(this.enemies[j]==null) {
				if(j<9) System.out.print("|          ");
				else System.out.print("|    END   ");		
			}
			else System.out.printf("|life:"+"%5s",this.enemies[j].getLife());
		}
		System.out.println("|");
		for(int j=0;j<10;j++){
			if(this.enemies[j]==null) System.out.print("|          ");
			else System.out.printf("|level:"+"%4s",this.enemies[j].getLevel());
		}
		System.out.println("|");
		System.out.println(" ------------------------------------------------------------------------------------------------------------- ");
	}
}
