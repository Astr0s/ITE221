
public class Card_Constructor {

		public static Treasure[] TreasureCards = {
		
		new Treasure("Boots of Running Really Fast", 0, 400, "Human", null, "Shoes", null), //gives -2 to escape
		new Treasure("Spiky Knees", 1, 200, null, "Human", "Regular", null),
		new Treasure("Staff of Napalm", 5, 800, "Human", "Wizard", "1 Hand", null),
		new Treasure("Stepladder", 3, 400, "Halfling", null, "", null),
		new Treasure("Swiss Army Polearm", 4, 600, "Human", null, "2 Hand", null),
		new Treasure("Flaming Armor", 2, 400, "Human", null, "Armour", null),
		new Treasure("Club", 3, 400, "Human", null, "1 Hand", null), //for some reason club often gives an error
		new Treasure("Hammer of Kneecap", 4, 600, "Dwarf", null, "1 Hand", null),
		new Treasure("Helm of Courage", 1, 200, "Human", null, "Helmet", null),
		new Treasure("Huge Rock", 3, 0, "Human", null, "2 Hand", null),
		new Treasure("Leather Armor", 1, 200, "Human", null, "Armour", null),
		new Treasure("Stincky Sandwich", 3, 400, "Halfling", null, "Regular", null),
		new Treasure("Mace of Sharpness", 4, 600, "Human", "Cliric", "1 Hand", null),
		new Treasure("Mithryl Armor", 3, 600, "Human", "!Wizards", "Armor", null),
		new Treasure("Bad Ass Bandana", 3, 400, "Human", null, "Armor", null),
		new Treasure("Boots of Butt-Kicking", 2, 400, "Human", null, "Shoes", null),
		new Treasure("Bow with Ribbons", 4, 800, "Elf", null, "2 Hand", null),
		new Treasure("Broad Sword", 3, 400, "Human", null, "1 Hand", null),
		new Treasure("Buckler of Swasher", 2, 400, "Human", null, "1 Hand", null),
		new Treasure("Chainsaw of Bloody Dismemberment", 3, 600, "Human", null, "2 Hand", null),
		new Treasure("Cheese Grater of Peace", 3, 400, "Human", "Cliric", "1 Hand", null),
		new Treasure("Cloak of Obcsurity", 4, 600, "Human", "Thieves", "Regular", null),
		new Treasure("Dagger of Treachery", 3, 400, "Human", "Thieves", "1 Hand", null),
		new Treasure("Eleven-Foot Pole", 1, 200, "Human", null, "2 Hand", null), //23 Treasures ATM
		//Race Cards Below
		new Treasure("Elf Race Card", 0, 000, "", null, "Elf", "Race Card"),
		new Treasure("Elf Race Card", 0, 000, "", null, "Elf", "Race Card"),
		new Treasure("Dwarf Race Card", 0, 000, "", null, "Dwarf", "Race Card"),
		new Treasure("Dwarf Race Card", 0, 000, "", null, "Dwarf", "Race Card"),
		new Treasure("Halfling Race Card", 0, 000, "", null, "Halfling", "Race Card"),
		new Treasure("Halfling Race Card", 0, 000, "", null, "Halfling", "Race Card"),
		//Class Cards Below
		new Treasure("Warrior Class Card", 0, 000, "", null, "Warrior", "Class Card"),
		new Treasure("Warrior Class Card", 0, 000, "", null, "Warrior", "Class Card"),
		new Treasure("Thief Class Card", 0, 000, "", null, "Thief", "Class Card"),
		new Treasure("Thief Class Card", 0, 000, "", null, "Thief", "Class Card"),
		new Treasure("Wizard Class Card", 0, 000, "", null, "Wizard", "Class Card"),
		new Treasure("Wizard Class Card", 0, 000, "", null, "Wizard", "Class Card"),
		new Treasure("Cliric Class Card", 0, 000, "", null, "Cliric", "Class Card"),
		new Treasure("Cliric Class Card", 0, 000, "", null, "Cliric", "Class Card"),
		//Level Up Cards
		new Treasure("Get a level!", 0, 000, "", null, "", "Level Up!"),
		new Treasure("Get a level!", 0, 000, "", null, "", "Level Up!"),
		new Treasure("Get a level!", 0, 000, "", null, "", "Level Up!"),

		};
		
		public Monster[] Monster = {

		
		new Monster("Young Rat", 1, 1, 1, 0, null),//" +3 against Clirics "
		new Monster("Mr.Bones", 2, 1, 2, 0, null), //"If you escape, you will loose one level anyway"
		new Monster("Snails on Speed", 4, 1, 0, -2, null), //"If you loose, roll a dice and throw away number of items from your hand"
		new Monster("Screaming Gekk", 6, 2, 0 , 0, null), //"+6 against warriors, also if you loose, throw away all your class and race cards"
		new Monster("Potter_Plant", 1, 1, 0, 0, null),//"Elfs get additional treasure if they win"
		new Monster("3875 Orks", 10, 3, 0, 0, null), //"+6 against dwarfs, if loose, roll a dice, if you number is less than 2, you die, else loose number of levels"
		new Monster("Amazon", 8, 2, 0, 0, null), //"If you loose, loose a class card or 3 levels."
		new Monster("Big Foot", 12, 3, 0, 0, null), //"+3 against halfling and dwarfs, if loose, losse your hat."
		new Monster("Bull Rog", 18, 5, 2, 0, null), //"doesn't attack anyone below lvl 4, if you loose, you die"
		new Monster("Crabs", 1, 1, 0, 0, null), //"Can't escape. If loose, loose armor and shoes"
		new Monster("Drooling Slime", 1, 1, 0, 0, null), //"+4 against elfs, loose shoes or 1 lvl if loose"
		new Monster("Face Sucker", 8, 2, 0, 0, null), //"+6 against elfs, if loose, loose your hat and 1 lvl"
		new Monster("Floating Monster", 10, 3, 3, -4, null), //"Can't escape. Can pay him off with any item worth of 200 gold"
		new Monster("Flyting Frogs", 2, 1, 2, -1, null),
		new Monster("Gazebo", 8, 2, 3, 0, null),
		new Monster("Gelatinous Octahedron", 2, 1, 0, 1, null),
		new Monster("Ghoul Fiends", 8, 2, 1, 0, null), //"Fight with them only with your level"
		new Monster("Harpies", 4, 2, 2, 0, null),//"+5 against wizards"
		new Monster("Hippogrief", 16, 4, 2, 0, null), //"Doesn't attack anyone below lvl 3"
		new Monster("Insurance Salesman", 14, 4, 0, 0, null), //"Beat him only with your bonuses, if loose, give him items worth of 1000 gold, otherwise loose everything"
		new Monster("King Tut", 16, 4, 2, 0, null), //"Doesn't attack anyone below lvl 3, even if you escape you loose 2 levels, if you loose, you loose all yout items and hand"
		new Monster("Lame Goblin", 1, 1, 1, 1, null),
		new Monster("Large Angry Chicken", 2, 1, 1, 0, null),
		new Monster("Lawyers", 6, 2, 0, 0, null), //"Loose your items"
		new Monster("Leperchaun", 4, 2, 0, 0, null), //"+5 against elfs, if loose, loose 2 items"
		};
		
		

}
