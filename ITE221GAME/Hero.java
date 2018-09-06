
public class Hero {
	int lvl;
	int bonus;
	Class Class;
	Race Race;
	String handItems[] = new String[5];
	String offHandItems[] = new String[20];
	
	public Hero () {
		lvl = 1;
		bonus = 0;
		Class = null;
		Race = null;
		handItems[0] = "";
		offHandItems[0] = "";
	}

	
	public Hero (Class HeroClass) {
		lvl = 1;
		bonus = 0;
		Class = HeroClass;
		Race = null;
		handItems[0] = "";
		offHandItems[0] = "";
	}
	
	public Hero (Race HeroRace) {
		lvl = 1;
		bonus = 0;
		Class = null;
		Race = HeroRace;
		handItems[0] = "";
		offHandItems[0] = "";
	}
	
	public Hero (Class HeroClass, Race HeroRace) {
		lvl = 1;
		bonus = 0;
		Class = HeroClass;
		Race = HeroRace;
		handItems[0] = "";
		offHandItems[0] = "";
	}
	
	public Hero (Class HeroClass, Race HeroRace, int bonusStat, int lvlStat) {
		lvl = lvlStat;
		bonus = bonusStat;
		Class = HeroClass;
		Race = HeroRace;
		handItems[0] = "";
		offHandItems[0] = "";
	}
	
	public Hero (Race HeroRace, int bonusStat, int lvlStat) {
		lvl = lvlStat;
		bonus = bonusStat;
		Class = null;
		Race = HeroRace;
		handItems[0] = "";
		offHandItems[0] = "";
	}
	
	public Hero (Class HeroClass, int bonusStat, int lvlStat) {
		lvl = lvlStat;
		bonus = bonusStat;
		Class = HeroClass;
		Race = null;
		handItems[0] = "";
		offHandItems[0] = "";
	}
	
	public Hero (int bonusStat, int lvlStat) {
		lvl = lvlStat;
		bonus = bonusStat;
		Class = null;
		Race = null;
		handItems[0] = "";
		offHandItems[0] = "";
	}
	
	public String toString() {
		return "Your level is: " + lvl
				+ "\nYour bonus is: " + bonus
				+ "\nYour class is: " + Class
				+ "\nYour race is: " + Race
				+ "\n# of Items in your hand: " + handItems
				+ "\n# of Items off hands: " + offHandItems;
	}
	
}
