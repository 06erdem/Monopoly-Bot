package Bot;

public class Tiles_Start extends Tiles {
  boolean hasOwner = false;
  int rent = 0;
  int random = 0;
  int owner = 0;
  public Tiles_Start() {
    // TODO Auto-generated constructor stub
    type = 0;
    name = "Collect $200 as you pass!";
    emoji = ":green_circle:";
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
 
  int getReward() {
    return 200;
  }
  public String toString() { return ":checkered_flag:"; }

  @Override
  public String getMessage(int playNum) {
	  // TODO Auto-generated method stub
	  return null;
  }
}
