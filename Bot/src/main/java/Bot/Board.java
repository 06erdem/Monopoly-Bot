package Bot;

public class Board {
	Tiles[] tiles;
	int[] playerList;
	
	public Board(){
		tiles = new Tiles[41];
		playerList = new int[4];
	}
	
	public Board(Tiles[] tileList, int[] players){
		tiles = tileList;
		playerList = players;
	}
	
	int[] getPlayerList(){
		return playerList;
	}
	
	void setPlayerList(int[] players){
		playerList = players;
	}
		
	Tiles[] getTiles(){
		return tiles;
	}	
		
	void setTiles(Tiles[] tileList){
		tiles = tileList;
	}
	
	
	void printBoard() {
		
	}
	
}
