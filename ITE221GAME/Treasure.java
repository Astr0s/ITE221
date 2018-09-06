
public class Treasure extends Card_Constructor{
	String name;
	int bonus;
	int price;
	String raceRestrict;
	String classRestriction;
	String typeOfTreasure; //1 handed weapon, 2 handed weapon, helmet, armor, shoes, regular, class, race
	String specialCondition;
	
	public Treasure (String Name, int bns, int prce, String raceRest, String clssRest, String tpOfTres, String spclCond) {
		this.name = Name;
		this.bonus = bns;
		this.price = prce;
		this.raceRestrict = raceRest;
		this.classRestriction = clssRest;
		this.typeOfTreasure = tpOfTres;
		this.specialCondition = spclCond;
	}
	
	public String toString() {
		return "\n[Treasure] " + name + "\nB:" + bonus + " $:" + price 
								+ "\nRace Restrict: " + raceRestrict + " Clss Restrict:  " + classRestriction
								+ "\nType: " + typeOfTreasure + " Special Condition: " + specialCondition;
	}
}
