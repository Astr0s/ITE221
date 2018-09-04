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
		Treasure[] inPlay = new Treasure[20]; //Cards that give various bonuses/stats e.g. class cards, race cards
		Treasure[] inHand = new Treasure[5]; //Cards that player can use e.g. potions spells 
	
		
		for(int a = 0; a < 8; a++) {
			startingHand[a] = Card_Constructor.TreasureCards[Randomizer(0, 37)];
		System.out.print("\n-=" + (a+1) + "=- " + startingHand[a]);
		}
		
		System.out.print("\n\nPick five cards: \n");
		for(int b = 0; b < 5; b++) {
			int number = console.nextInt();
			inPlay[b] = startingHand[number-1]; //-1 because it shows an array elements with +1 counter
		}
		
		Treasure[] raceCards = new Treasure[5]; //Equal to amount of allowed cards in players hand in case player is dumb and lucky and chooses 5 race cards
		Treasure[] classCards = new Treasure[5]; //Same
		
		
		Race Race = new Race("Human");
		Class Class = new Class("No Class");
		int bonusStat = 0;
		int lvlStat = 1;
		
		for(int c = 0; c < 5; c++) {
			
			if (inPlay[c].specialCondition != null) {
				if ( inPlay[c].specialCondition.equals("Race Card")) raceCards[c] = inPlay[c];
				else if (inPlay[c].specialCondition.equals("Class Card")) classCards[c] = inPlay[c];
			}
			else bonusStat += inPlay[c].bonus;
			System.out.print("\n" + inPlay[c]);			
		}
		
		for(int d = 0; d < 5; d++) {
			if (raceCards[d].typeOfTreasure != null) {
			System.out.print("\nDo you want to activate card, that will make your race " + raceCards[d].typeOfTreasure + "? Yes/No");
			String answer = console.nextLine();
			if (answer.equals("Yes")) {
				Race = new Race(raceCards[d].typeOfTreasure);
				break;
			}
			}
		}
		
		for(int f = 0; f < 5; f++) {
			System.out.print("\nDo you want to activate card, that will make your class " + classCards[f].typeOfTreasure + "? Yes/No");
			String answer = console.nextLine();
			if (answer.equals("Yes")) {
				Class = new Class(classCards[f].typeOfTreasure);
				break;
			}
		}
		
		
		Hero Player = new Hero(Class, Race, bonusStat, lvlStat);
		
		System.out.print("\n\n"+Player);
		
	}

	

}
