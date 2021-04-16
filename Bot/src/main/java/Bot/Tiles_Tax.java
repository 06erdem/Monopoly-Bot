package Bot;

public class Tiles_Tax extends Tiles {
 int tax;
 int random = 0;
 int rent = 0;
 int owner = 0;
 boolean hasOwner = false;
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
 int getTax(){
   return tax;
 }
 public int getOwner(){
   return owner;
 }
 public boolean hasOwner(){
   return hasOwner;
 }
 
 public int getRent(){
   return rent;
 }
 
 public int getRandom(){
   return random;
 }
 
 void setTax(int t){
   tax = t;
}
@Override
public String getMessage(int playNum) {
	// TODO Auto-generated method stub
	return null;
}
}
