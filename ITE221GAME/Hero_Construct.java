
public class Hero_Construct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class Warrior = new Class("Warrior");
		Race Human = new Race("Hurr");
		Hero Guts = new Hero(Warrior, Human);
		System.out.print(Guts);
	}

}
