package Bot;

public class Player {
	
	int position; //position on board
	int money; //money
	long playerId;
	String playerEmoji;
	
	public Player(){
		position = 0;
		money = 1500;
		emoji = "";
	}
	
	public Player(int pos, int cash, long id, String emoji){
		position = pos;
		money = cash;
		playerId = id;
		playerEmoji = emoji;
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

	void setId(long id){
		playerId = id;
	}

	long getId(){
		return playerId;
	}

	String getEmoji() {
		return playerEmoji;
	}
	
	//****Functions for tiles****//
	/*
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
	}*/
}
