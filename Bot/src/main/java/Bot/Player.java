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
	
	void addMoney(int diff) { //Adds given amount from player's money
		money += diff;
	}
	
	void subtractMoney(int diff){ //subtracts money from players account
		money -= diff;
	}
	
	void setMoney(int cash) {
		money = cash;
	}
	int getMoney() {
		return money;
	}
}
