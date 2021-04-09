package Bot;
import java.lang.*;

public class Tiles_Chance extends Tiles { 
 int min = -50;
 int max = 50;
 int random;
 public Tiles_Chance() {
  name = "Chance!";
  type = 4;
  emoji = ":question:";
  random = (int)Math.floor(Math.random()*(max-min+1)+min);
 }
 public Tiles_Chance(String emoji) {
  name = "Chance!";
  type = 4;
  this.emoji = emoji;
  random = (int)Math.floor(Math.random()*(max-min+1)+min);
 }
 
 public int getRandom(){
   return random;
 }
}
