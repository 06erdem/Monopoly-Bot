package Bot;

public class Tiles_Tax extends Tiles {
	int tax;
	public Tiles_Tax(int tax) {
		name = "Tax";
		type = 5;
		this.tax = tax;
		emoji = ":money_with_wings:";
	}
	public Tiles_Tax(int tax, String emoji) {
		name = "Tax";
		type = 5;
		this.emoji = emoji;
		this.tax = tax;
	}

}
