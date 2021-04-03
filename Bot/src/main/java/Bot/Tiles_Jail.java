package Bot;

public class Tiles_Jail extends Tiles {

	public Tiles_Jail() {
		// TODO Auto-generated constructor stub
		name = "Jail! No action";
		type = 2;
		emoji = ":passport_control:";
	}
	public Tiles_Jail(String emoji) {
		// TODO Auto-generated constructor stub
		name = "Jail! No action";
		type = 2;
		this.emoji = emoji;
	}
	int getType() {
		return type;
	}
	void setName(String name) {
		this.name = name;
	}
	//I am not sure if this is how the jail 'with action' will work. The idea is player will pay 200 if it is 'with action'.
	//Correct if needed.
	int returnFee() {
		return 200;
	}
	public String toString() { return ":passport_control:"; }

}
