package Bot;

public class Board {
	Tiles[] tiles; //array of tiles
	Player[] playerList; //list of players currently playing the game
	
	//public Tiles(int prices, String names, int index, int[6] rents){
	public Board(){
		tiles = new Tiles[41];
		playerList = new Player[4];

<<<<<<< HEAD
		//tiles[0] = new Tiles(); GO tile
		tiles[1] = new Tiles(60, "Mediterranean Avenue", 1, [2, 4, 10, 30, 90, 160, 250]);
		//tiles[2] = new Tiles(); Community Chest
		tiles[3] = new Tiles(60, "Baltic Avenue", 2, [4, 8, 20, 60, 180, 320, 450]);
		//tiles[4] = new Tiles(); Income Tax
		//tiles[5] = new Tiles(200); Reading Railroad
		tiles[6] = new Tiles(100, "Oriental Avenue", 6, [6, 12, 30, 90, 270, 400, 550]);
		//tiles[7] = new Tiles(); Chance
		tiles[8] = new Tiles(100, "Vermont Avenue", 8, [6, 12, 30, 90, 270, 400, 550]);
		tiles[9] = new Tiles(120, "Connecticut Avenue", 9, [8, 16, 40, 100, 300, 450, 600]);
		//tiles[10] = new Tiles(); In Jail/Just Visiting
		tiles[11] = new Tiles(140, "St. Charles Place", 11, [10, 20, 50, 150, 450, 625, 750]);
		//tiles[12] = new Tiles(); Electric Company
		tiles[13] = new Tiles(140, "States Avenue", 13, [10, 20, 50, 150, 450, 625, 750]);
		tiles[14] = new Tiles(160, "Virginia Avenue", 14, [12, 24, 60, 180, 500, 700, 900]);
		//tiles[15] = new Tiles(200); Pennsylvania Railroad
		tiles[16] = new Tiles(180, "St. James Place", 16, [14, 28, 70, 200, 550, 750, 950]);
		//tiles[17] = new Tiles(); Community Chest
		tiles[18] = new Tiles(180, "Tennessee Avenue", 18, [14, 28, 70, 200, 550, 750, 950]);
		tiles[19] = new Tiles(200, "New York Avenue", 19, [16, 32, 80, 220, 600, 800, 1000]);
		//tiles[20] = new Tiles(); Free Parking
		tiles[21] = new Tiles(220, "Kentucky Avenue", 21, [18, 36, 90, 250, 700, 875, 1050]);
		//tiles[22] = new Tiles(); Chance
		tiles[23] = new Tiles(220, "Indiana Avenue", 23, [18, 36, 90, 250, 700, 875, 1050]);
		tiles[24] = new Tiles(240, "Illinois Avenue", 24, [20, 40, 100, 300, 750, 925, 1100]);
		//tiles[25] = new Tiles(200); B. & O. Railroad
		tiles[26] = new Tiles(260, "Atlantic Avenue", 26, [22, 44, 110, 330, 800, 975, 1150]);
		tiles[27] = new Tiles(260, "Ventnor Avenue", 27, [22, 44, 110, 330, 800, 975, 1150]);
		//tiles[28] = new Tiles(); Water Works
		tiles[29] = new Tiles(280, "Marvin Gardens", 29, [24, 48, 120, 360, 850, 1025, 1200]);
		//tiles[30] = new Tiles(); Go To Jail
		tiles[31] = new Tiles(300, "Pacific Avenue", 31, [26, 52, 130, 390, 900, 1100, 1275]);
		tiles[32] = new Tiles(300, "North Carolina Avenue", 32, [26, 52, 130, 390, 900, 1100, 1275]);
		//tiles[33] = new Tiles(); Community Chest
		tiles[34] = new Tiles(320, "Pennsylvania Avenue", 34, [28, 56, 150, 450, 1000, 1200, 1400]);
		//tiles[35] = new Tiles(200); Short Line
		//tiles[36] = new Tiles(); Chance
		tiles[37] = new Tiles(350, "Park Place", 37, [35, 70, 175, 500, 1100, 1300, 1500]);
		//tiles[38] = new Tiles(); Luxury Tax
		tiles[39] = new Tiles(400, "Boardwalk", 39, [50, 100, 200, 600, 1400, 1700, 2000]);
=======
>>>>>>> origin/main
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
