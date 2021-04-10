package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

/* 
 * Control Center for game that handles interaction between board and receiver class.
 * Receiver : 
 *      take message from users
 *       call appropriate functions of controller according to message  (such as start new game, next move info 
 *                (trade, roll dice, next turn, buy property ,... ) , reset game ,.... )
 *       take action result from controller
 *        return appropriate message to chat depend on that action result 
 *
 * Controller:
 * 		  keep track of game status (GameState)
 *        take message from receiver
 *        manage logic and run the game. manipulate Board info as necessary
 *        update game state (if a person wins or they decide to concede the game early ->> here we calculate wealth 
 *                    and decides the winner)
 *        return  action result to receiver
 *
 *        Note : controller should have all access to board variables and handles the game logic
 *
 * Board: 
 *        Update board states and player states
 *        Functions in board when called should only perform its task such as move player, add properties, 
 *                 add/subtract money, all logic whether an action is valid should be done in controller
 * 
 * 
 **/
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
	
	/* Receive corresponding action from message received in Receiver. 
	 * Call appropriate function in Control Center to handle instruction.
	 * Return result message to receiver.
	 * 
	 * actionID : 
	 * 1-4 = player join, correspondingly to position in array of players
	 * 5   = next turn
	 * 6   = buy properties
	 * 7   = invoke trades
	 * */

	public int getState() {
		return gameState;
	}
	
	/*  
	   *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
	 * ALL PRIVATE HELPER METHODS for gameAction function go down here  * 
	   *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  
	 * */

	Board getBoard() {
		return board;
	}
	private void sendGenericEmbed(String title, String description, String footer) {
		if ( (title != null) && !(title.equals(""))) //if not null string or empty String
			embed.setTitle(title);
		if ( (description != null) && description.length() < 2048) // max length for an embed description.
			embed.setDescription(description);
		else embed.setDescription("Invalid description String. Cannot exceed 2048 or null");
		
		embed.setFooter(footer); // doesn't need to handle exception since setFooter accepts null
		channel.sendMessage(embed.build()).queue();
	}
	public void run(EmbedBuilder embed, MessageChannel channel, String input, String userID) {
		this.embed = embed;
		if(this.channel == null)
			this.channel = channel;
		if(this.channel == channel) {
			if(input.equals("!play")) {
				//if there has been an instance of the game. Send error message and return function
				if (gameState == 2) {
					sendGenericEmbed(null, "Failure to start! Another instance is already running. Type !reset to start a new game.", null);
					return;
				}
				else {
					sendGenericEmbed("Welcome to Discord Monopoly!" ,
							 "Select your player emoji. Type \"!join\" followed with the number you wish to join as\nFor example: \"!join1\"\n**1** :pickup_truck:\n**2** :race_car:\n**3** :bus:\n**4** :motorcycle:" ,
							 "2-4 Players required\nPlayers cannot choose the same emoji.\nType \"!start\" when ready.\nType \"commands\" for help." );
					board = new Board();
					gameState = 1;
				
				}
			}
			else if(input.contains("!join")) {
				if(gameState == 1)
					joinReceiver(input, userID);
				else if(gameState == 0 || gameState == 3) //If there is no running state
					sendGenericEmbed(null, "You haven't started a game.",null);
				else if(gameState == 2) //if the game is already running
					sendGenericEmbed(null, "Can't join running game.",null);
			}
			else if(input.equals("!leave"))
				leaveGame(userID);
			else if(input.equals("!printboard"))
				board.printBoard();
			else if(input.equals("commands"))
				sendGenericEmbed("Commands:","**!play** to start game.\n**!join 1/2/3/4** to join game.\n**!leave** to leave game\n**!start** to start game.",null);
			
			//functions for testing
			else if(input.contains("show"))
				showPlayers();
			
		}
		
	}
	
	public void leaveGame(String userID) {
		for(int i = 0; i < 4; i++) {
			if(board.playerList[i].getId().equals(userID)) {
				board.removePlayer(i);
				break;
			}
			sendGenericEmbed("Player " + (i+1) + "Left!","Space is now available", null);
		}
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
			sendGenericEmbed("Invalid Join Input.", "You can only join spaces 1-4.", null);
			return;
		}
		int oldPlayerNum = 4; //5 is a place holder that lets the program know, the user was not already in a position before this.
		for(int i = 0; i < 4; i++) {
				if(board.playerList[i] != null) {
					if(board.playerList[i].getId().equals(userID)) //checks if the player is registered in the board
						oldPlayerNum = i;
				}
		}
		
		if(board.playerList[playerNum]==null)  { //If space is empty, player joins!
			
			if(oldPlayerNum == 4) //player isn't in board and can be added
				sendGenericEmbed("Sucessfully added player " + (playerNum+1), "Player Emoji: " + playerEmojis[playerNum] + "\nPlayer Number: " + 
						(playerNum+1), null);
			
			else {//player is registered at another space and should move
				sendGenericEmbed("You've registered for space " + (playerNum+1) + " and are no longer in space " + (oldPlayerNum+1), "Player Emoji: " + 
						playerEmojis[playerNum] + "\nPlayer Number: " + (playerNum+1), null);
				//board.removePlayer(oldPlayerNum);
				board.removePlayer(oldPlayerNum);
			}
			board.addPlayer(userID, playerNum, playerEmojis[playerNum]);			
		}
		else { //Spot is taken
			if(oldPlayerNum == playerNum) {//If the player already exists in the board as this player
				sendGenericEmbed("You've already registered at space " + (oldPlayerNum+1),
						"Player Emoji: " + playerEmojis[playerNum] + "\nPlayer Number: " + (playerNum+1), null);
				return;
			}
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
			sendGenericEmbed("Player " + (playerNum+1) + " spot already taken", description, null);
		}
	}
	
	
	//**********************************//
	//*******Tools for testing*********//
	//********************************//
	public void showPlayers() {
		String ret = "";
		for(Player p: board.getPlayerList())
			if(p != null)
				ret += p.getEmoji() + " ID: " + p.getId();
		sendGenericEmbed("Showing Players:",ret,null);
	}
}






























