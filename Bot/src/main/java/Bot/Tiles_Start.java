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













/*
package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;


public class Game_Control_Center {
	
	private int 	gameState = 0 ; // 0 = uninitialized , 1 = setting up, 2 = running , 3 = finished or not running
	private String 	playerEmojis[] = new String[]{":pickup_truck:",":race_car:",":bus:",":motorcycle:"};
	private Board 	board;
	private MessageChannel channel;
	private EmbedBuilder embed;
	
	public Game_Control_Center() {
		gameState = 1 ;
		board = new Board();
		
	}

	public String gameAction(int actionID , String userID) {
		String resultMessage = "success";
		
		if ( (actionID >=1) && (actionID <= 4))
			resultMessage = join(actionID , userID);
			
		return resultMessage;
	}
	public int getState() {
		return gameState;
	}

	private String join(int playerNumber , String userID) {
		String resultMessage = ""; // default String of a successful operation
		
		//Handles error when the space player is trying to join is invalid
		if (board.playerList[playerNumber - 1] != null) {
			resultMessage += "Can't join game!";
			int emptySlots = 0;
			for(int i=0; i < 4; i++) {
				if(board.playerList[i] == null) {
					emptySlots++;
					if(emptySlots == 1)
						resultMessage += " Empty player slots are: ";
					resultMessage += (i+1) + " ";
				}
			}
			if(emptySlots == 0)
				resultMessage += " There are no empty slots. Players can leave with the command \"!leave\" to make space for you.";
			return resultMessage;
		}
		
		board.addPlayer(userID, playerEmojis[playerNumber - 1]); // call funciton in Board
		
		/* This is a test String for join function in GameControl
		resultMessage = String.format("Player emoji: %s \nPlayer num: %d \nPlayer id: %s",
				playerEmojis[playerNumber - 1].toString(), playerNumber , board.playerList[playerNumber - 1].getId());
		return resultMessage;
	}
	

	Board getBoard() {
		return board;
	}
	
	public void run(String[] output, MessageChannel channel, String input, String userID) {
		if(this.channel == null)
			this.channel = channel;
		else if(this.channel == channel) {
			if(input.equals("!play")) {
				//embed = new EmbedBuilder();

				if (gameState == 0) {
					output = setOutput(null, "Failure to start! Another instance is already running. Type !reset to start a new game.", null);
					return;
				}
				else {
					r.sendGenericEmbed("Welcome to Discord Monopoly!" ,
								 "Select your player emoji. Type \"!join\" followed with the number you wish to join as\nFor example: \"!join1\"\n1 :pickup_truck:\n2 :race_car:\n3 :bus:\n4 :motorcycle:" ,
								 "2-4 Players required\nPlayers cannot choose the same emoji.\nType \"!start\" when ready." );
					board = new Board();
				
				}
			}
			if(input.contains("!join")) {
				if(gameState == 1)
					joinReceiver(input, userID);
				else if(gameState == 0 || gameState == 3) //If there is no running state
					sendGenericEmbed(null, "You haven't started a game.",null);
				else if(gameState == 2) //if the game is already running
					sendGenericEmbed(null, "Can't join running game.",null);
			}
			
		}
		
	}
	public String[] setOutput(String a, String b, String c) {
		String[3] out = {a,b,c};
		return out;
	}
	public void sendGenericEmbed(String title, String description, String footer) {
		if ( (title != null) && !(title.equals(""))) //if not null string or empty String
			embed.setTitle(title);
		if ( (description.length() < 2048) && (description != null) ) // max length for an embed description.
			embed.setDescription(description);
		else embed.setDescription("Invalid description String. Cannot exceed 2048 or null");
		
		embed.setFooter(footer); // doesnt need to handle exceoption since setFooter accepts null
		channel.sendMessage(embed.build()).queue();
	}
	
	public void joinReceiver(String input, String userID) {
		int playerNum;
		if(input.equals("!join1") || input.equals("!join 1"))
			playerNum = 0;
		else if(input.equals("!join2")	|| input.equals("!join 2"))
			playerNum = 1;
		else if(input.equals("!join3")	|| input.equals("!join 3"))
			playerNum = 2;
		else if(input.equals("!join4")	|| input.equals("!join 4"))
			playerNum = 3;
		else {
			sendGenericEmbed("Invalid Join Input.", null, null);
			return;
		}
		
		if(getBoard().playerList[playerNum]==null) //Player Joins!
			sendGenericEmbed("Sucessfully added player" + playerNum, "Player Emoji: " + playerEmojis[playerNum] + "\nPlayer Number: " + 
		playerNum+1, null);
		else { //Spot is taken
			String description = "Can't join game!";
			int emptySlots = 0;
			for(int i=0; i < 4; i++) {
				if(board.playerList[i] == null) {
					emptySlots++;
					if(emptySlots == 1)
						description += " Empty player slots are: ";
					description += (i+1) + " ";
				}
			}
			if(emptySlots == 0)
				description += " There are no empty slots. Players can leave with the command \"!leave\" to make space for you.";
			sendGenericEmbed("Player " + playerNum + " spot already taken", description, null);
		}
	}
}
*/































