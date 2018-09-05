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
		Treasure helm = null;
		Treasure firstHand = null;
		Treasure secondHand = null;
		Treasure bothHands = null;
		Treasure armor = null;
		Treasure shoes = null;
		
		
		for(int a = 0; a < 8; a++) {
			startingHand[a] = Card_Constructor.TreasureCards[Randomizer(0, 37)];
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
		//think about how to make a card picking into a method to reuse the code later
		for(int c = 0; c < 5; c++) {
			
			if (inPlay[c].specialCondition != null) {
				if ( inPlay[c].specialCondition.equals("Race Card")) raceCards[c] = inPlay[c];
				else if (inPlay[c].typeOfTreasure.equals("Class Card")) classCards[c] = inPlay[c];
				else if (inPlay[c].typeOfTreasure.equals("Helm")) { //think about how to optimize this shit, seriously this looks like a mess
					if (helm == null) {
						helm = inPlay[c];
					}
					else {
						System.out.println("Do you want to change your " + helm.name + " with bonus of " + helm.bonus 
								+ " to " + inPlay[c].name + " with a bonus of " + inPlay[c].bonus + "? Yes/No.");
						String answer = consoleStr.nextLine();
						if (answer.equals("Yes")) {
							System.out.print("You changed your" + helm.name + " to " + inPlay[c].name);
							helm = inPlay[c];
							inPlay[c] = null; //google fucking remove method, this is embarrassing
							answer = ""; //not sure about this one, do i need to empty it?
						}
					}
				}
				
				else if (inPlay[c].typeOfTreasure.equals("Armor")) {
					if (armor == null) armor = inPlay[c];
					else {
						System.out.println("Do you want to change your " + armor.name + " with bonus of " + armor.bonus 
								+ " to " + inPlay[c].name + " with a bonus of " + inPlay[c].bonus + "? Yes/No.");
						String answer = consoleStr.nextLine();
						if (answer.equals("Yes")) {
							System.out.print("You changed your" + armor.name + " to " + inPlay[c].name);
							armor = inPlay[c];
							inPlay[c] = null;
							answer = "";
						}
					}
				}
				
				else if (inPlay[c].typeOfTreasure.equals("Shoes")) {
					if (shoes == null) shoes = inPlay[c];
					else {
						System.out.println("Do you want to change your " + shoes.name + " with bonus of " + shoes.bonus 
							 + " to " + inPlay[c].name + " with a bonus of " + inPlay[c].bonus + "? Yes/No.");
						String answer = consoleStr.nextLine();
						if (answer.equals("Yes")) {
							System.out.print("You changed your" + shoes.name + " to " + inPlay[c].name);
							shoes = inPlay[c];
							inPlay[c] = null;
							answer = "";
						}
					}
				}
				
				else if (inPlay[c].typeOfTreasure.equals("1 Hand")) {
					if (firstHand == null) firstHand = inPlay[c];
					else if (secondHand == null) secondHand = inPlay[c];
					else {
						System.out.println("Your hands are full, in which hand do you want to change your weapon? First hand or second hand?");
						String answer = consoleStr.nextLine();
						if (answer.equals("First hand")) {
							System.out.println("Do you want to change your " + firstHand.name + " with bonus of " + firstHand.bonus 
									 + " to " + inPlay[c].name + " with a bonus of " + inPlay[c].bonus + "? Yes/No.");
								String answer2 = consoleStr.nextLine();
								if (answer2.equals("Yes")) {
									System.out.print("You changed your" + firstHand.name + " to " + inPlay[c].name);
									firstHand = inPlay[c];
									inPlay[c] = null;
									answer2 = "";
								}
						}
						else if (answer.equals("Second hand")) {
							System.out.println("Do you want to change your " + secondHand.name + " with bonus of " + secondHand.bonus 
									 + " to " + inPlay[c].name + " with a bonus of " + inPlay[c].bonus + "? Yes/No.");
								String answer2 = consoleStr.nextLine();
								if (answer2.equals("Yes")) {
									System.out.print("You changed your" + secondHand.name + " to " + inPlay[c].name);
									secondHand = inPlay[c];
									inPlay[c] = null;
									answer2 = "";
								}
						}
					
					}
				}
				
				else if (inPlay[c].typeOfTreasure.equals("2 Hand")) {
					if (firstHand == null && secondHand == null) bothHands = inPlay[c];
					else if (firstHand != null && secondHand != null) { //think about how to ask about a particular hand rather than splitting this if into two
						System.out.print("You hands are full, do you want to replace your weapon with " + inPlay[c].name + "? Yes/No");
						String answer = consoleStr.nextLine();
						if (answer.equals("Yes")) {
							System.out.print("You changed your" + " to " + inPlay[c].name);
							bothHands = inPlay[c];
							inPlay[c] = null;
							answer = "";
						}
					}
				}

				
				
				else if (inPlay[c].typeOfTreasure.equals("Consumable")) inHand[c] = inPlay[c];
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
			System.out.println("\nDo you want to activate card, that will make your race " + raceCards[d].typeOfTreasure + "? Yes/No");
			String answer = consoleStr.nextLine();
			if (answer.equals("Yes")) {
				Race = new Race(raceCards[d].typeOfTreasure);
				break;
			}
			}
		}
		
		
		//bonusStat += helm.bonus + armor.bonus + shoes.bonus; //add ifs later so it wont give nullpointer error
		Hero Player = new Hero(Class, Race, bonusStat, lvlStat);
		
		System.out.print("\n\n"+Player);
		if (helm != null) System.out.print("\n"+helm);
		if (armor != null) System.out.print("\n"+armor);
		if (shoes != null) System.out.print("\n"+shoes);
		if (firstHand != null) System.out.print("\n"+firstHand);
		if (secondHand != null) System.out.print("\n"+secondHand);
		if (bothHands != null) System.out.print("\n"+bothHands);

	}
}


