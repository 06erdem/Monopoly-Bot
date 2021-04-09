package Bot;

public class Tiles_Start extends Tiles {
  boolean hasOwner = false;
  int rent = 0;
  int random = 0;
  public Tiles_Start() {
    // TODO Auto-generated constructor stub
    type = 0;
    name = "Collect $200 as you pass!";
    emoji = ":green_circle:";
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
 
  int getReward() {
    return 200;
  }
  public String toString() { return ":checkered_flag:"; }
}
