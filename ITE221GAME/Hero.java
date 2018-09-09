
public class Hero {
	int lvl;
	int bonus;
	Class Class;
	Race Race;
	
	public Hero () {
		lvl = 1;
		bonus = 0;
		Class = null;
		Race = null;
		
	}

	
	public Hero (Class HeroClass) {
		lvl = 1;
		bonus = 0;
		Class = HeroClass;
		Race = null;
		
	}
	
	public Hero (Race HeroRace) {
		lvl = 1;
		bonus = 0;
		Class = null;
		Race = HeroRace;

	}
	
	public Hero (Class HeroClass, Race HeroRace) {
		lvl = 1;
		bonus = 0;
		Class = HeroClass;
		Race = HeroRace;
	
	}
	
	public Hero (Class HeroClass, Race HeroRace, int bonusStat, int lvlStat) {
		lvl = lvlStat;
		bonus = bonusStat;
		Class = HeroClass;
		Race = HeroRace;
		
	}
	
	public Hero (Race HeroRace, int bonusStat, int lvlStat) {
		lvl = lvlStat;
		bonus = bonusStat;
		Class = null;
		Race = HeroRace;
		
	}
	
	public Hero (Class HeroClass, int bonusStat, int lvlStat) {
		lvl = lvlStat;
		bonus = bonusStat;
		Class = HeroClass;
		Race = null;
		
	}
	
	public Hero (int bonusStat, int lvlStat) {
		lvl = lvlStat;
		bonus = bonusStat;
		Class = null;
		Race = null;
		
	}
	
	public String toString() {
		return "Your level is: " + lvl
				+ "\nYour bonus is: " + bonus
				+ "\nYour class is: " + Class
				+ "\nYour race is: " + Race;
	}
}
