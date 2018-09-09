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

		
		Treasure[] startingHand = new Treasure[8]; //First 8 cards player has to choose his treasures from
		Treasure[] inPlay = new Treasure[20]; //Cards that give various bonuses/stats and cannot be used/consumed during play
		Treasure[] inHand = new Treasure[5]; //Cards that player can consume or use e.g. potions, spells 
		Treasure helm = null; //This is wear and weapon inventory, it's not really finished and should be rewritten into something better
		Treasure firstHand = null;
		Treasure secondHand = null;
		Treasure bothHands = null;
		Treasure armor = null;
		Treasure shoes = null;
		
		
		for(int a = 0; a < 8; a++) { //This picks out cards from an array of treasure into starting hand via randomizer method
			startingHand[a] = Card_Constructor.TreasureCards[Randomizer(0, 37)];
		System.out.print("\n-=" + (a+1) + "=- " + startingHand[a]);
		}
		
		System.out.print("\n\nPick five cards: \n"); //Player picks out 5 cards out of starting hand
		for(int b = 0; b < 5; b++) {
			int number = consoleInt.nextInt();
			inPlay[b] = startingHand[number-1]; //-1 because it shows an array elements with +1 counter
		}
		
		Treasure[] raceCards = new Treasure[5]; //Equal to amount of allowed cards in players hand in case player is dumb and lucky and chooses 5 race cards
		Treasure[] classCards = new Treasure[5]; //Same
		
		
		Race Race = new Race("Human"); //Class and race by default are human and no class
		Class Class = new Class("No Class");
		int bonusStat = 0;
		int lvlStat = 1;
		//think about how to make a card picking into a method to reuse the code later
		for(int c = 0; c < 5; c++) { //This sorts cards from those that player picked into various places, also probably can be made better
			
			if (inPlay[c].specialCondition != null) {
				if ( inPlay[c].specialCondition.equals("Race Card")) raceCards[c] = inPlay[c]; //adds card into a separate array, would be better if would be sorted the same as wear&weapons are 
				else if (inPlay[c].specialCondition.equals("Class Card")) classCards[c] = inPlay[c]; //same
				else if (inPlay[c].typeOfTreasure.equals("Helmet")) { 
					//think about how to optimize this shit, seriously this looks like a mess
					//this sorts picked cards into weapon&wear slots
					if (helm == null) { //if player does not have an item in the slot, it goes there automatically
						helm = inPlay[c];
						bonusStat += inPlay[c].bonus;
					}
					else { //if player has an item in the slot, game asks player if he wants to change it to a different item 
						System.out.println("Do you want to change your " + helm.name + " with bonus of " + helm.bonus 
								+ " to " + inPlay[c].name + " with a bonus of " + inPlay[c].bonus + "? Yes/No.");
						String answer = consoleStr.nextLine();
						if (answer.equals("Yes")) {
							System.out.print("You changed your" + helm.name + " to " + inPlay[c].name);
							helm = inPlay[c];
							bonusStat += inPlay[c].bonus;
							inPlay[c] = null; //google fucking remove method, this is embarrassing
							answer = ""; //not sure about this one, do i need to empty it?
						}
					}
				}
				//the rest of wear&armor checks are the same
				else if (inPlay[c].typeOfTreasure.equals("Armour")) {
					if (armor == null) {
						armor = inPlay[c];
						bonusStat += inPlay[c].bonus;

					}
					else {
						System.out.println("Do you want to change your " + armor.name + " with bonus of " + armor.bonus 
								+ " to " + inPlay[c].name + " with a bonus of " + inPlay[c].bonus + "? Yes/No.");
						String answer = consoleStr.nextLine();
						if (answer.equals("Yes")) {
							System.out.print("You changed your" + armor.name + " to " + inPlay[c].name);
							armor = inPlay[c];
							bonusStat += inPlay[c].bonus;
							inPlay[c] = null;
							answer = "";
						}
					}
				}
				
				else if (inPlay[c].typeOfTreasure.equals("Shoes")) {
					if (shoes == null) {
						shoes = inPlay[c];
						bonusStat += inPlay[c].bonus;
					}
					else {
						System.out.println("Do you want to change your " + shoes.name + " with bonus of " + shoes.bonus 
							 + " to " + inPlay[c].name + " with a bonus of " + inPlay[c].bonus + "? Yes/No.");
						String answer = consoleStr.nextLine();
						if (answer.equals("Yes")) {
							System.out.print("You changed your" + shoes.name + " to " + inPlay[c].name);
							shoes = inPlay[c];
							bonusStat += inPlay[c].bonus;
							inPlay[c] = null;
							answer = "";
						}
					}
				}
				
				else if (inPlay[c].typeOfTreasure.equals("1 Hand")) {
					if (firstHand == null) {
						firstHand = inPlay[c];
						bonusStat += inPlay[c].bonus;
					}
					else if (secondHand == null) {
						secondHand = inPlay[c];
						bonusStat += inPlay[c].bonus;
					}
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
									bonusStat += inPlay[c].bonus;
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
									bonusStat += inPlay[c].bonus;
									inPlay[c] = null;
									answer2 = "";
								}
						}
					
					}
				}
				
				else if (inPlay[c].typeOfTreasure.equals("2 Hand")) {
					if (firstHand == null && secondHand == null) {
						bothHands = inPlay[c];
						bonusStat += inPlay[c].bonus;

					}
					else if (firstHand != null && secondHand != null) { //think about how to ask about a particular hand rather than splitting this if into two
						System.out.print("You hands are full, do you want to replace your weapon with " + inPlay[c].name + "? Yes/No");
						String answer = consoleStr.nextLine();
						if (answer.equals("Yes")) {
							System.out.print("You changed your" + " to " + inPlay[c].name);
							bothHands = inPlay[c];
							bonusStat += inPlay[c].bonus;
							inPlay[c] = null;
							answer = "";
						}
					}
				}

				
				
				else if (inPlay[c].typeOfTreasure.equals("Consumable")) inHand[c] = inPlay[c]; //Later will have consumabable items
			}
			else bonusStat += inPlay[c].bonus; //counts bonus
			System.out.print("\n" + inPlay[c]);			
		}
		
		for(int f = 0; f < 5; f++) { //asks player what class he want to be if there are multple class cards
			if (classCards[f] != null) {
			System.out.println("\n\nDo you want to activate card, that will make your class a " + classCards[f].typeOfTreasure + "? Yes/No");
			String answer = consoleStr.nextLine();
			if (answer.equals("Yes")) {
				Class = new Class(classCards[f].typeOfTreasure);
				break;
			}
			}
		}
			
		for(int d = 0; d < 5; d++) { //asks player what race he want to be if there are multple race cards
			if (raceCards[d] != null) {
			System.out.println("\nDo you want to activate card, that will make your race " + raceCards[d].typeOfTreasure + "? Yes/No");
			String answer = consoleStr.nextLine();
			if (answer.equals("Yes")) {
				Race = new Race(raceCards[d].typeOfTreasure);
				break;
			}
			}
		}
		
		
		Hero Player = new Hero(Class, Race, bonusStat, lvlStat);
		
		System.out.print("\n\n"+Player);
		if (helm != null) System.out.print("\nYou wear "+helm.name+" on you head.");
		if (armor != null) System.out.print("\nYou wear "+armor.name+" on your torso.");
		if (shoes != null) System.out.print("\nYou wear "+shoes.name+" on you legs.");
		if (firstHand != null) System.out.print("\nYou hold "+firstHand.name+" in your right arm");
		if (secondHand != null) System.out.print("\nYou hold "+secondHand.name+" in your left hand");
		if (bothHands != null) System.out.print("\nYou hold "+bothHands.name+" in your both hands");
		//There is a bug where you can hold 1 hand weapon and 2 hand weapon at the same time, will fix later
	}
}


