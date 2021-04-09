package Bot;

import java.util.*;

import net.dv8tion.jda.api.entities.User;

public class Player {

	int position; // position on board
	int money; // money
	String emoji;
	String userID;
	ArrayList<Tiles> properties_Owned; // properties owned by the player
	boolean inJail;

	/* Default Constructor */
	public Player(String userID , String emoji) {
		this.userID 		= userID;
		position 	= 0;
		money 		= 1500;
		properties_Owned = new ArrayList<Tiles>();
		inJail 		= false;
	}

	public Player(int cash, int pos, ArrayList<Tiles> properties) {
		position = pos;
		money = cash;
		properties_Owned = properties;
		inJail = false;
	}

	@Override
	public String toString() {
		return emoji;
	}
	
	void setInJail(boolean jail) {
		inJail = jail;
	}

	void goToJail() {
		inJail = true;
		position = 30;
	}

	boolean getInJail() {
		return inJail;
	}

	void setPosition(int pos) { // Set position on board
		position = pos;
	}

	int getPosition() { // Get position on board
		return position;
	}

	void addMoney(int diff) { // Adds or subtracts given amount from player's money
		money += diff;
	}

	void setMoney(int cash) {
		money = cash;
	}

	int getMoney() {
		return money;
	}
//
//	void setOwnedProperties(Arraylist[] properties) { // set the properties owned of the player
//		properties_Owned = properties;
//	}
//
//	Tiles getOwnedProperties() { // get the properties owned by the player
//		return properties_Owned;
//	}

	void buyProperty(Tiles_Property tile) {
		properties_Owned.add(tile);
		addMoney(-tile.getValue());
	}

	void rentProperty(Tiles_Property tile) {
		addMoney(-tile.getRent());
	}

	void collectRent(Tiles_Property tile) {
		addMoney(tile.getRent());
	}

	void payTax(Tiles_Tax tile) {
		addMoney(-tile.getTax());
	}

	void payJail() {
		addMoney(-50);
		inJail = false;
	}
	// ****Functions for tiles****//
	/*
	 * 
	 * 
	 * 
	 * 
	 * void payJail() { addMoney(-5-); }
	 */
}
