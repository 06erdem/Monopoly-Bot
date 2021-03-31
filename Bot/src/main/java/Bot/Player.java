package Bot;

public class Player {
	
	int position; //position on board
	int money; //money
	
	void setPosition(int pos) { //Set position on board
		position = pos;
	}
	int getPosition() { //Get position on board
		return position;
	}
	
	void changeMoney(int diff) { //Adds or subtracts given amount from player's money
		money += diff;
	}
	void setMoney(int cash) {
		money = cash;
	}
	int getMoney() {
		return money;
	}
}
