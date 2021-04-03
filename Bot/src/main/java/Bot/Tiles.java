package Bot;
/* Parent class for all tiles of the board */
public class Tiles {
	/* contain the coordinate of the tile on the board */
	private int[] coordinate;
	int type; //Type = (1=Start) (2=Property) (3=Jail)
	String name; //Will hold name that the bot will print. i.e Old Kent Road, Community Chest, etc
	public Tiles() {		
	}
	String getName() {
		return name;
	}
}
