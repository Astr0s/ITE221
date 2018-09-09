import java.util.Scanner;
public class Gameplay {
	
	private static final Object[] Treasure = null;

	private static int Randomizer(int x, int y) {
		int min = x;
		int max = y;
		
		double random = (min + Math.random() * (max + 1 - min));
		random = Math.floor(random);
		return (int) random;
	}
	

	private static Treasure[] itemRecieve(int num) {
		//this method returns an array with set size
		//num is how big you want your array to be
		Treasure[] array = new Treasure[num];	
		for (int i = 0; i<num; i++) {
			array[i] = Card_Constructor.TreasureCards[Randomizer(0, 37)];
		}
		return array;	
	}
	
	private static void arrayPrint(Treasure[] array, int num) {
		//this method should print out cards
		System.out.print("\n===========You have got!===========\n");

		 for (int i = 0; i < num; i++) {
	         if (i > 0) {
	            System.out.print("\n\t===|===|===|===|===|===|===");
	         }
	         System.out.print("\n#" + (i+1) + array[i]); //i+1 to start the list with 1
		 }
			System.out.print("\n===========**************===========");

	}
	
	private static Treasure[] chooseItem(Treasure[] array, int num, int num2) {
		//a method for picking cards out of array and returning a new array
		//array in arguments is an array from which to pick cards
		//first number is how big array is, second is how many cards you need to choose
		Scanner console = new Scanner(System.in);
		Treasure[] arrayReturn = new Treasure[num];	

		System.out.print("\n\nPick " + num2 + " cards: \n"); 
		for(int b = 0; b < num2; b++) {
			int number = console.nextInt();
			arrayReturn[b] = array[number-1]; //-1 because it shows an array elements with +1 counter
		}
		return arrayReturn;
	}
	
	
	
	private static String sortRaceKlass(Treasure[] ITEM) {
		//this method checks if player chose a race or klass card
		String text = "";
		for(int c = 0; 0 < ITEM.length; c++) {
		if (ITEM[c].specialCondition != null) {
			if (ITEM[c].specialCondition.equals("Race Card")) {
				text = ITEM[c].typeOfTreasure;
				return text;
			}

			else if (ITEM[c].specialCondition.equals("Klass Card")); {
				text = ITEM[c].typeOfTreasure;
				return text;
			}
		}
		}
		return text;
	}
	
	private static Treasure sortItemsfromArray (Treasure[] ITEM, String Type, int num) {
		//this method picks out a specified type of treasure out of an array
		//ITEM is array, you want to sort
		//Type is the typeOfTreasure you want
		//num is how many elemts of an array you want to check, usually should be array.length i guess
		Treasure thing = null;
		for (int v = 0; v < num; v++) {
		if (ITEM[v].typeOfTreasure.equals(Type)) {
				thing = ITEM[v];
			}
		else return thing;
		}
		return thing;
	}
	
	private static Treasure[] sortItemsintoArray (Treasure[] ITEM) {
		//this method picks out a specified type of treasure out of an array and returns an array
		//!!ONLY FOR THE BEGGIGNING OF GAME
		//ITEM is array, you want to sort
		Treasure[] fullSwag = new Treasure[6];
		Scanner console = new Scanner(System.in);
			
			fullSwag[0] = sortItemsfromArray(ITEM, "Helmet", fullSwag.length);
			fullSwag[1] = sortItemsfromArray(ITEM, "Armour", fullSwag.length);
			fullSwag[2] = sortItemsfromArray(ITEM, "1 Hand", fullSwag.length);
			if (fullSwag[2] != null) { //a check if first hand is full, if not, probably there is no 1 Hand weapon in the array, so second hand has a null value too
				fullSwag[3] = sortItemsfromArray(ITEM, "1 Hand", fullSwag.length);
			}
			else {
				fullSwag[3] = null;	
			}
			
			/*if (sortItemsfromArray(ITEM, "2 Hand", fullSwag.length) != null) {
				if (fullSwag[2] != null || fullSwag[3] != null) { //Player can choose if he wants to drop 1 hand weapon, if he has a 2 hand weapon
					System.out.println("Your hands are full, would you like to switch 1 hand weapon(s) to 2 hand weapon? Yes/No");
					String answer = console.nextLine();
					
					if (answer.equals("Yes")) {
						fullSwag[4] = sortItemsfromArray(ITEM, "2 Hand", fullSwag.length);
						}
					else fullSwag[4] = null; 
				}*/
				
			
			fullSwag[4] = sortItemsfromArray(ITEM, "2 Hand", fullSwag.length);		
			fullSwag[5] = sortItemsfromArray(ITEM, "Shoes", fullSwag.length);
		
		
			return fullSwag;
	}
	
	private static int BonusCount(Treasure[] array) {
		int num = 0;
		for (int i = 0; 0 <= (array.length+1); i++) {
			 if (array[i] != null) num += array[i].bonus;
		}
		return num;
	}
	
	
	
	public static void main(String[] args) {
		Treasure[] startingHand = itemRecieve(8); //First 8 cards player has to choose his treasures from
		arrayPrint(startingHand, 8);

		Treasure[] inPlay = chooseItem(startingHand, 20, 5); //Cards that give various bonuses/stats and cannot be used/consumed during play
		arrayPrint(inPlay, 5);
		
		int lvlStat = 1;
		int bonusStat = 0 + lvlStat;
		Race Race = new Race(sortRaceKlass(inPlay));
		Klass Klass = new Klass(sortRaceKlass(inPlay));
	
		Treasure[] Wear = sortItemsintoArray(inPlay);
		//an array of amour&weapons [0]Helmet, [1]Armour, [2]firstHand, [3]secondHand, [4]bothHands,  [5]Shoes
		arrayPrint(Wear, 5);
		//bonusStat += BonusCount(Wear);
		//bonusStat += BonusCount(inPlay);
		
		
		Hero Player = new Hero(Klass, Race, bonusStat, lvlStat);
		System.out.print(Player);
	}

}
