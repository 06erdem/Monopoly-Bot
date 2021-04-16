package Bot;
<<<<<<< HEAD
=======

import java.util.ArrayList;
public class Player {
 

 int position; //position on board
 int money; //money
 ArrayList<Tiles> propertiesOwned; //properties owned by the player
 boolean inJail;
 String playerID;
 String playerEmoji;
 
 public Player(){
  position = 40;
  money = 1500;
  propertiesOwned = new ArrayList<Tiles>();
  inJail = false;
 }
 
 public Player(String ID, String emojis){
  position = 0;
  money = 1500;
  propertiesOwned = new ArrayList<Tiles>();
  inJail = false;
  playerID = ID;
  playerEmoji = emojis;
 }
 
 void setId(long id){
   playerID = Long.toString(id);
 }

 String getId(){
   return playerID;
 }

 String getEmoji() {
   return playerEmoji;
 }
 
 void setInJail(boolean jail){
   inJail = jail;
 }
 
 void goToJail(){
   inJail = true;
   position = 11;
 }
 
 boolean getInJail(){
   return inJail;
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
>>>>>>> branch 'main' of https://github.com/LordChester64/CS321_Monopoly_Bot.git

<<<<<<< HEAD
import java.util.*;

public class Player {

	int position; // position on board
	int money; // money
	String emoji;
	String userID;
	ArrayList<Tiles> properties_Owned; // properties owned by the player
	boolean inJail;

	/* Default Constructor */
	public Player(String userID , String emoji) {
		this.userID = userID;
		this.emoji 	= emoji;
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
=======
 void setMoney(int cash) {
  money = cash;
 }
 int getMoney() {
  return money;
 }
 
 void setOwnedProperties(ArrayList<Tiles> properties){ //set the properties owned of the player
   propertiesOwned = properties;
 }
 
 ArrayList<Tiles> getOwnedProperties(){ //get the properties owned by the player
   return propertiesOwned;
 }

 Tiles sellOwnedProperty(){
    Tiles soldTile = propertiesOwned.remove(propertiesOwned.size() - 1);
    return soldTile;
 }

 int getNumProperties(){
   return propertiesOwned.size();
 }
 
 void buyProperty(Tiles_Property tile, int id) {
  tile.setOwner(id);
  propertiesOwned.add(tile);
  addMoney(-tile.getValue());
 }
 
	void rentProperty(Tiles_Property tile) {
		addMoney(-tile.getRent());
	}
 
	void collectRent(Tiles_Property tile){
		addMoney(tile.getRent());
	}
 
	void payTax(Tiles_Tax tile) {
		addMoney(-tile.getTax());
	}
 
	void payJail() {	
		addMoney(-50);
		inJail = false;
	}
	 //****Functions for tiles****//
	 /*
 
 
 
	
	 void payJail() {
	  addMoney(-5-);
	 }*/
>>>>>>> branch 'main' of https://github.com/LordChester64/CS321_Monopoly_Bot.git
}
