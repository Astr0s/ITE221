import java.util.Scanner;
public class Game_Start {
	
	private static int Randomizer(int x, int y) {
		int min = x;
		int max = y;
		
		double random = (min + Math.random() * (max + 1 - min));
		random = Math.floor(random);
		return (int) random;
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		Treasure[] startingHand = new Treasure[8];
		Treasure[] playerHand = new Treasure[5];
		
		for(int i = 0; i < 8; i++) {
			startingHand[i] = Card_Constructor.TreasureCards[Randomizer(0, 37)];
		System.out.print("\n-=" + i + "=- " + startingHand[i]);
		}
		
		System.out.print("\n\nPick five cards: \n");
		for(int v = 0; v < 5; v++) {
			int number = console.nextInt();
			playerHand[v] = startingHand[number];
		}
		
		Race race = null;
		Class Class = null;
		int bonusStat = 0;
		int lvlStat = 1;
		
		for(int b = 0; b < 5; b++) {
			
			/*if (playerHand[b].specialCondition.equals("Turns you into an elf!")) race = new Race("Elf");
			else if (playerHand[b].specialCondition.equals("Turns you into a hafling!")) race = new Race("Hafling");
			else if (playerHand[b].specialCondition.equals("Turns you into a dwarf!")) race = new Race("Dwarf");
			else if (playerHand[b].specialCondition.equals("Makes you a warrior!")) Class = new Class("Warrior");
			else if (playerHand[b].specialCondition.equals("Makes you a wizard!")) Class = new Class("Wizard");
			else if (playerHand[b].specialCondition.equals("Makes you a thief!")) Class = new Class("Thief");
			else if (playerHand[b].specialCondition.equals("Makes you a cliric!")) Class = new Class("Cliric");*/
			//if (playerHand[b].specialCondition.equals("Level Up!")) lvlStat++;
			
			bonusStat += playerHand[b].bonus;
			System.out.print(playerHand[b]);
			
		}
		
		Hero Player = new Hero(Class, race, bonusStat, lvlStat);
		
		System.out.print("\n\n"+Player);
		
	}

	

}
