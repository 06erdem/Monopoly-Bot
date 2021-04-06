package Bot;

public class Board {
	Tiles[] tiles; //array of tiles
	Player[] playerList; //list of players currently playing the game
	int numPlayers;
	int currPlayer;
	
	//public Tiles(int prices, String names, int index, int[6] rents){
	public Board(){
		tiles = new Tiles[40];
		playerList = new Player[4];
		buildBoard();
	}
	
	public Board(Tiles[] tileList, Player[] players){
		tiles = tileList;
		playerList = players;
		numPlayers = 0;
		currPlayer = 0;
		buildBoard();
	}
	void buildBoard() {
		for(int i = 0; i < 40; i++) {
			if(i==0)
				tiles[i] = new Tiles_Start();
			else if(i==1)
				tiles[i] = new Tiles_Property(60,10,"Mediteranean Avenue");
			else if(i==2) //This is a chest
				tiles[i] = new Tiles_Chance();
			else if(i==3)
				tiles[i] = new Tiles_Property(200,20,"Baltic Avenue");
			else if(i==4)
				tiles[i] = new Tiles_Tax(200);
			else if(i==5) //We may need to implement something for rent of railroad.
				//Rent of railroad *should* be $25 for one, 50 for two, 100 for three, 200 for all four owned
				tiles[i] = new Tiles_Property(200, 25, "Reading Railroad", ":steam_locomotive:");
			else if(i==6)
				tiles[i] = new Tiles_Property(100, 30, "Oriental Avenue");
			else if(i==7)
				tiles[i] = new Tiles_Chance();
			else if(i==8)
				tiles[i] = new Tiles_Property(100, 30, "Vermont Avenue");
			else if(i==9)
				tiles[i] = new Tiles_Property(100, 30, "Conneticut Avenue");
			else if(i==10) //No Action Jail
				tiles[i] = new Tiles_Jail();
			else if(i==11)
				tiles[i] = new Tiles_Property(140, 50, "St. Charles Place");
			else if(i==12)
				//This also doesn't have the same rent mechanics as the real game
				tiles[i] = new Tiles_Property(140, 20, "Electric Company", ":bulb:");
			else if(i==13)
				tiles[i] = new Tiles_Property(140, 50, "States Avenue", ":house_with_garden:");
			else if(i==14)
				tiles[i] = new Tiles_Property(140, 60, "Virginia Avenue", ":house_with_garden:");
			else if(i==15)
				tiles[i] = new Tiles_Property(200, 40, "Pensylvania Railroad", ":steam_locomotive:");
			else if(i==16)
				tiles[i] = new Tiles_Property(180, 70, "St. James Palace", ":house_with_garden:");
			else if(i==17) //This is a chest
				tiles[i] = new Tiles_Chance();
			else if(i==18)
				tiles[i] = new Tiles_Property(180, 70, "Tennesse Avenue", ":house_with_garden:");
			else if(i==19)
				tiles[i] = new Tiles_Property(200, 80, "New York Avenue",":house_with_garden:");
			else if(i==20)
				tiles[i] = new Tiles("Free Parking",0, ":parking:");
			else if(i==21)
				tiles[i] = new Tiles_Property(220, 90, "Kentucky Avenue", ":homes:");
			else if(i==22)
				tiles[i] = new Tiles_Chance();
			else if(i==23)
				tiles[i] = new Tiles_Property(220, 90, "Indiana Avenue", ":homes:");
			else if(i==24)
				tiles[i] = new Tiles_Property(240, 100, "Illinois Avenue", ":homes:");
			else if(i==25)
				tiles[i] = new Tiles_Property(200, 60, "B & O Railroad", ":steam_locomotive:");
			else if(i==26)
				tiles[i] = new Tiles_Property(260, 110, "Atlantic Avenue", ":homes:");
			else if(i==27)
				tiles[i] = new Tiles_Property(260, 110, "Ventnor Avenue", ":homes:");
			else if(i==28)
				tiles[i] = new Tiles_Property(150, 20, "Water Works", ":shower:");
			else if(i==29)
				tiles[i] = new Tiles_Property(280, 120, "Marvin Gardens", ":homes:");
			else if(i==30) //Jail WITH action
				//TO-DO: Action
				tiles[i] = new Tiles_Jail();
			else if(i==31)
				tiles[i] = new Tiles_Property(300, 130, "Pacific Avenue", ":classical_building:");
			else if(i==32)
				tiles[i] = new Tiles_Property(300, 130, "North Carolina Avenue", ":classical_building:");
			else if(i==33) //This is a chest
				tiles[i] = new Tiles_Chance();
			else if(i==34)
				tiles[i] = new Tiles_Property(320, 150,"Pennsylvania Avenue", ":classical_building:");
			else if(i==35)
				tiles[i] = new Tiles_Property(200, 80, "Short Line", ":steam_locomotive:");
			else if(i==36)
				tiles[i] = new Tiles_Chance();
			else if(i==37)
				tiles[i] = new Tiles_Property(350, 175, "Park Place", ":classical_building:");
			else if(i==38)
				tiles[i] = new Tiles_Tax(100);
			else if(i==39)
				tiles[i] = new Tiles_Property(400, 200, "Boardwalk", ":classical_building:");
			
				
		}
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
		String strBoard = "";
		for(int i = 20; i < 31; i++)
			strBoard += tiles[i].getEmoji();
		strBoard += "\n";
		int L = 19;
		for(int R = 31; R < 40; R++) {
			strBoard += tiles[L].getEmoji();
			strBoard += printSpaces();
			strBoard += tiles[R].getEmoji();
			L--;
			strBoard += "\n";
		}
		for(int j = 10; j >= 0; j--)
			strBoard += tiles[j].getEmoji();
		
		return strBoard;
	}

	String rollDice(){
		int dice1;
    	int dice2;
		dice1 = (int)(Math.random()*6+1);
		dice2 = (int)(Math.random()*6+1);
		String rollOutput =  dice1 + " " + dice2;
		return rollOutput;
	}

	String printSpaces() {
		String space = "";
		for(int i = 0; i < 9; i++) {
			space += "⬛";
		}
		return space;
	}
	
}
