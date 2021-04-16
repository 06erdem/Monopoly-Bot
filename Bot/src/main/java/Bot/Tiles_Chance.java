package Bot;
import java.lang.*;

public class Tiles_Chance extends Tiles { 
 int min = -50;
 int max = 50;
 int random;
 int rent = 0;
 boolean hasOwner = false;
 public Tiles_Chance() {
  name = "Chance!";
  type = 4;
  emoji = ":question:";
  random = (int)Math.floor(Math.random()*(max-min+1)+min);
  hasOwner = false;
  rent = 0;
 }
 public Tiles_Chance(String emoji) {
  name = "Chance!";
  type = 4;
  this.emoji = emoji;
  random = (int)Math.floor(Math.random()*(max-min+1)+min);
  hasOwner = false;
  rent = 0;
 }
 
 public int getRandom(){
   return random;
 }
 public boolean hasOwner(){
   return hasOwner;
 }
 public int getRent(){
   return rent;
 }
 public int getOwner() {
     // TODO Auto-generated method stub
     return 0;
 }
@Override
public String getMessage(int playNum) {
	// TODO Auto-generated method stub
	return null;
}
 
}
