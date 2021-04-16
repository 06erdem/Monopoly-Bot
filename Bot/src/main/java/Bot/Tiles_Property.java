package Bot;

<<<<<<< HEAD
public class Tiles_Property extends Tiles {
	int ownerNum;
	int value;
	int rent;
	boolean isMortgaged = false;

	public Tiles_Property(int value, int rent, String name) {
		// TODO Auto-generated constructor stub
		ownerNum = 5; // Owner number = 5 can mean there is no owner. This removes need for boolean.
						// Simple encapsulation.
		type = 2;
		this.value = value;
		this.rent = rent;
		this.name = name;
		emoji = ":house:";
	}

	public Tiles_Property(int value, int rent, String name, String emoji) {
		// TODO Auto-generated constructor stub
		ownerNum = 5; // Owner number = 5 can mean there is no owner. This removes need for boolean.
						// Simple encapsulation.
		type = 2;
		this.value = value;
		this.rent = rent;
		this.name = name;
		this.emoji = emoji;
	}

	boolean hasOwner() {
		return ownerNum == 5;
	}

	void freeOwner() {
		ownerNum = 5;
	}

	int getOwner() {
		return ownerNum;
	}

	void setMortgaged() {
		isMortgaged = true;
	}

	void freeMortgaged() {
		isMortgaged = false;
	}

	boolean isMortgaged() {
		return isMortgaged;
	}

	int getValue() {
		return value;
	}

	int getRent() {
		return rent;
	}

	void setRent(int ren) {
		rent = ren;
	}

	void setValue(int val) {
		value = val;
	}

	void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return ":classical_building:";
	}
=======
public class Tiles_Property extends Tiles  {
 int ownerNum;
 int value;
 int rent;
 boolean isMortgaged = false;
 int random = 0;
 public Tiles_Property(int value, int rent, String name) {
  // TODO Auto-generated constructor stub
  ownerNum = 4; //Owner number = 4 can mean there is no owner. This removes need for boolean. Simple encapsulation.
  type = 2;
  this.value = value;
  this.rent = rent;
  this.name = name;
  emoji = ":house:";
 }
 public Tiles_Property(int value, int rent, String name, String emoji) {
  // TODO Auto-generated constructor stub
  ownerNum = 4; //Owner number = 4 can mean there is no owner. This removes need for boolean. Simple encapsulation.
  type = 2;
  this.value = value;
  this.rent = rent;
  this.name = name;
  this.emoji = emoji;
 }
 
 public int getRandom(){
   return random;
 }
 public boolean hasOwner() {
  return ownerNum == 4;
 }
 void freeOwner() {
  ownerNum = 4;
 }
 public int getOwner() {
  return ownerNum;
 }
 void setOwner(int newOwner) {
	 ownerNum = newOwner;
 }
 void setMortgaged() {
  isMortgaged = true;
 }
 void freeMortgaged() {
  isMortgaged = false;
 }
 boolean isMortgaged() {
  return isMortgaged;
 }
 public int getValue(){
   return value;
 }
 
 public int getRent(){
   return rent;
 }
 
 void setRent(int ren){
   rent = ren;
 }
 
 void setValue(int val){
   value = val;
 }
 void setName(String name) {
  this.name = name;
 }
 public String toString() { return ":classical_building:"; }
 public String getMessage(int playerNum) {
	 if(hasOwner()) {
		 if(isMortgaged())
			 return "This property is mortgaged. You can stay here rent free!\n";
		 else if(playerNum == ownerNum)
			 return "You are the owner of this property and can stay here rent free!\n";
		 else
			 return "This property is owned by player " + getOwner() + "pay rent to stay here or declare bankrupcy by typing 'bankrupt'";
	 }
	 else {
		 return "You can buy this property for $" + getValue() + "\nPress 'b' to make the purchase!"; 
	 }
 }
>>>>>>> branch 'main' of https://github.com/LordChester64/CS321_Monopoly_Bot.git
}
