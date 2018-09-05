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
		Scanner consoleInt = new Scanner(System.in); //Ask ajan why cant single console do the thing
		Scanner consoleStr = new Scanner(System.in);

		
		Treasure[] startingHand = new Treasure[8];
		Treasure[] inPlay = new Treasure[20]; //Cards that give various bonuses/stats
		Treasure[] inHand = new Treasure[5]; //Cards that player can use e.g. potions spells 
		Treasure Helm = null;
		Treasure firstHand = null;
		Treasure secondHand = null;
		Treasure bothHands = null;
		Treasure armor = null;
		Treasure shoes = null;
		
		
		for(int a = 0; a < 8; a++) {
			startingHand[a] = Card_Constructor.TreasureCards[Randomizer(24, 37)];
		System.out.print("\n-=" + (a+1) + "=- " + startingHand[a]);
		}
		
		System.out.print("\n\nPick five cards: \n");
		for(int b = 0; b < 5; b++) {
			int number = consoleInt.nextInt();
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
				else if (inPlay[c].specialCondition.equals("Helm")) {
					if (Helm == null) {
						Helm = inPlay[c];
					}
				}
				else if (inPlay[c].specialCondition.equals("Class Card")) classCards[c] = inPlay[c];
				else if (inPlay[c].specialCondition.equals("Class Card")) classCards[c] = inPlay[c];
				else if (inPlay[c].specialCondition.equals("Class Card")) classCards[c] = inPlay[c];
				else if (inPlay[c].specialCondition.equals("Class Card")) classCards[c] = inPlay[c];

			}
			else bonusStat += inPlay[c].bonus;
			System.out.print("\n" + inPlay[c]);			
		}
		
		for(int f = 0; f < 5; f++) {
			if (classCards[f] != null) {
			System.out.println("\n\nDo you want to activate card, that will make your class a " + classCards[f].typeOfTreasure + "? Yes/No");
			String answer = consoleStr.nextLine();
			if (answer.equals("Yes")) {
				Class = new Class(classCards[f].typeOfTreasure);
				break;
			}
			}
		}
			
		for(int d = 0; d < 5; d++) {
			if (raceCards[d] != null) {
			System.out.print("\nDo you want to activate card, that will make your race " + raceCards[d].typeOfTreasure + "? Yes/No");
			String answer = consoleStr.nextLine();
			if (answer.equals("Yes")) {
				Race = new Race(raceCards[d].typeOfTreasure);
				break;
			}
			}
		}
		
		
		
		Hero Player = new Hero(Class, Race, bonusStat, lvlStat);
		
		System.out.print("\n\n"+Player);
		
	}

	

}


