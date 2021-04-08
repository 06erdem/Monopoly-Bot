package Bot;

public class Tiles_GoToJail extends Tiles {
  // TODO Auto-generated constructor stub
  
 public Tiles_GoToJail(String emoji) {
  // TODO Auto-generated constructor stub
  name = "Go To Jail!";
  type = 2;
  this.emoji = ":passport_control:";
 }

 void setName(String name) {
  this.name = name;
 }
 //I am not sure if this is how the jail 'with action' will work. The idea is player will pay 200 if it is 'with action'.
 //Correct if needed.
 int returnFee() {
  return 50;
 }
 public String toString() { return ":passport_control:"; }

}