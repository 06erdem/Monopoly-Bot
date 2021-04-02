package Bot;

public class Player {
	
	int position; //position on board
	int money; //money
	
	public Player(){
		position = 0;
		money = 1500;
	}
	
	public Player(int cash, int pos){
		position = pos;
		money = cash;
	}
	
	void setPosition(int pos) { //Set position on board
		position = pos;
	}
	int getPosition() { //Get position on board
		return position;
	}
	
	void addMoney(int diff) { //Adds or subtracts given amount from player's money
		money += diff;
	}

	void setMoney(int cash) {
		money = cash;
	}
	int getMoney() {
		return money;
	}
	
	//****Functions for tiles****//
	void buyProperty(Tiles tile) {
		tile.buyProperty();
		addMoney(-tile.getValue());
	}
	
	void rentProperty(Tiles tile) {
		addMoney(-tile.getRent());
	}
	void payTax(Tiles tile) {
		addMoney(-tile.getTax());
	}
	void payJail() {
		addMoney(-200);
	}
}
