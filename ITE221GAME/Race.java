
public class Race{
	String race;
	String raceBonus;
	
	public Race (String Race) {
	if (Race.equals("Halfling")) {
		this.race = Race;
		raceBonus = "Sell items at NPC for double the price, if failed to escape, may throw one card to try again";
	}
	else if (Race.equals("Dwarf")) {
		this.race = Race;
		raceBonus = "You can hold six cards in hand";
	}
	
	else if (Race.equals("Elf")) {
		this.race = Race;
		raceBonus = "+1 to escape, get additional level if beat two monsters in a row";
	}
	
	else {
		this.race = "Human";
		raceBonus = "None, you're boring";
	}
		
}
	public String toString() {
		return race + "\nYour race bonus is: " + raceBonus;
	}
	
}