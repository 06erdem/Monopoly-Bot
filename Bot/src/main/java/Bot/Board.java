package Bot;

public class Board {
	Tiles[] tiles; //array of tiles
	Player[] playerList; //list of players currently playing the game
	
	//public Tiles(int prices, String names, int index, int[6] rents){
	public Board(){
		tiles = new Tiles[41];
		playerList = new Player[4];

	}
	
	public Board(Tiles[] tileList, Player[] players){
		tiles = tileList;
		playerList = players;
	}
	
	Player[] getPlayerList(){ //returns the list of players
		return playerList;
	}
	
	void setPlayerList(Player[] players){ //set the list of players
		playerList = players;
	}
		
	Tiles[] getTiles(){ //return the list of tiles that are used for the board
		return tiles;
	}	
		
	void setTiles(Tiles[] tileList){ //set the tiles used for the board
		tiles = tileList;
	}
	
	
	String printBoard() {
		return "";
	}
	
}
