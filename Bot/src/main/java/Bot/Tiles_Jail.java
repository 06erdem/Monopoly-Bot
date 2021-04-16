package Bot;

public class Tiles_Jail extends Tiles {
  int rent = 0;
  int random = 0;
  boolean hasOwner = false;
  int owner;
  public Tiles_Jail() {
    // TODO Auto-generated constructor stub
    name = "Jail! No action";
    type = 2;
    emoji = ":passport_control:";
  }
  public Tiles_Jail(String emoji) {
    // TODO Auto-generated constructor stub
    name = "Jail! No action";
    type = 2;
    this.emoji = emoji;
  }
  
  void setName(String name) {
    this.name = name;
  }
  //I am not sure if this is how the jail 'with action' will work. The idea is player will pay 200 if it is 'with action'.
  //Correct if needed.
  int returnFee() {
    return 50;
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
  public int getValue(){
    return 0;
  }
  public String toString() { return ":passport_control:"; }
@Override
public String getMessage(int playNum) {
	// TODO Auto-generated method stub
	return null;
}

}
