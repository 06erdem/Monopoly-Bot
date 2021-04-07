package Bot;
import java.util.*;
public class Player {
 
 int position; //position on board
 int money; //money
 ArrayList<Tiles> propertiesOwned; //properties owned by the player
 boolean inJail;
 long playerId;
 String playerEmoji;

 public Player(){
  position = 0;
  money = 1500;
  properties_Owned = new ArrayList<Tiles>();
  inJail = false;
  emoji = "";
 }
 
 public Player(int cash, int pos, Tiles[] properties, long id, String emoji){
  position = pos;
  money = cash;
  properties_Owned = properties;
  inJail = false;
  playerId = id;
  playerEmoji = emoji;
 }
 
 void setInJail(boolean jail){
   inJail = jail;
 }
 
 void goToJail(){
   inJail = true;
   position = 30;
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

 void setOwnedProperties(Tiles[] properties){ //set the properties owned of the player
   propertiesOwned = properties;
 }
 
 Tiles[] getOwnedProperties(){ //get the properties owned by the player
   return propertiesOwned;
 }
 
 void buyProperty(Tiles_Property tile) {
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
}
