package Bot;

public class Tiles_Start extends Tiles {

	public Tiles_Start() {
		// TODO Auto-generated constructor stub
		type = 0;
		name = "Collect $200 as you pass!";
	}
	int getType() {
		return type;
	}
	int getReward() {
		return 200;
	}
	public String toString() { return ":checkered_flag:"; }
}
