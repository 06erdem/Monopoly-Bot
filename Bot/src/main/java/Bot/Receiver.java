package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Receiver extends ListenerAdapter {
	
<<<<<<< HEAD
	private Game_Control_Center controller = null;  
	//private int startCommand = 0;
	private EmbedBuilder embed;
	private String resultMessage;     //result of an function in Controller, default is String "success"
	private String content;
	private MessageChannel channel;   //this variable is used to send message to the channel of the commands just entered
	
=======
	private Game_Control_Center controller = new Game_Control_Center();  
	//private int startCommand = 0;
	private EmbedBuilder embed = new EmbedBuilder();
	//private String resultMessage;     //result of an function in Controller, default is String "success"
	private String content;
	private MessageChannel channel;   //this variable is used to send message to the channel of the commands just entered
>>>>>>> branch 'main' of https://github.com/LordChester64/CS321_Monopoly_Bot.git
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		//get message and channel of the message
		content = e.getMessage().getContentRaw().toLowerCase();
		channel = e.getChannel();
<<<<<<< HEAD
		String userID	= e.getAuthor().getId();
		
		if(content.equals("hi")) {
			e.getChannel().sendMessage("what's up mate!").queue();
=======
		String userID = e.getAuthor().getId();
		
		
		if(content.equals("!play") || ( (controller.getState() == 1 || controller.getState() == 2))) { // state = 1 means it is setting up the game and should take input 
			controller.run(embed, channel, content, userID);                                          // state = 2 means the game is running and should take input
>>>>>>> branch 'main' of https://github.com/LordChester64/CS321_Monopoly_Bot.git
		}
<<<<<<< HEAD
		
=======
		if(content.equals("!commands")) {//I don't know why but this doesn't work
			e.getChannel().sendMessage("Type \"!play\" to start the game!");
		}
		if(content.equals("hi")) {
			e.getChannel().sendMessage("what's up mate!").queue();
		}
>>>>>>> branch 'main' of https://github.com/LordChester64/CS321_Monopoly_Bot.git
		if(content.contains("!delete")) {
			e.getChannel().purgeMessages(e.getChannel().getHistory().retrievePast(50).complete());
		}
<<<<<<< HEAD
		
		/* ACTIONS FOR INITIALIZNG THE GAME */
		
		/* Check player's turn by comparing userID. IF not this person's turn, IGNORE*/
		/* Also check if a player has joined already, 1 person cannot be 2 players */
		/* Actions when game has not been initialized */
		if(content.equals("!easteregg")) testEmbed(); // just for testing embed function. delete afterwards or modify
		if(content.equals("!play")) play(); 
		if(content.equals("!join1") || content.equals("!join 1"))	joinReceiver(1, userID);  // join as player 1
		if(content.equals("!join2")	|| content.equals("!join 2")) 	joinReceiver(2, userID);  // join as player 2
		if(content.equals("!join3")	|| content.equals("!join 3")) 	joinReceiver(3, userID);  // join as player 3
		if(content.equals("!join4")	|| content.equals("!join 4")) 	joinReceiver(4, userID);  // join as player 4
		
		/* ACTIONS WHEN GAME IS RUNNING */
		
=======
>>>>>>> branch 'main' of https://github.com/LordChester64/CS321_Monopoly_Bot.git
	}
<<<<<<< HEAD
	
	
	private void play() {
		embed = new EmbedBuilder();
		/* if there has been an instance of the game. Send error message and return function */
		if (controller != null) {
			sendGenericEmbed(null, "Failure to start! Another instance is already running. Type !reset to start a new game.", null);
			return;
		}
		
		controller = new Game_Control_Center();		
		sendGenericEmbed("Welcome to Discord Monopoly!" ,
						 "Select your player emoji.\n1 :pickup_truck:    2 :race_car:    3 :bus:    4 :motorcycle:" ,
						 "Type 1, 2, 3 or 4.\n2-4 Players required\nPlayers cannot choose the same emoji. Type '!start' when ready." );
	}
	
	private void joinReceiver(int playerNum , String userID) {
		if (controller == null) { // if no instance of game has been made
			sendGenericEmbed(null, "Failure to join! \n No instance of the game is running."
									+ "Please type !play to create a new game", null);
			return;
		}
		
		resultMessage = controller.gameAction(playerNum, userID); //since playerNum coincides with actionID in gameAction
		sendGenericEmbed("Sucessfully add player" + playerNum, resultMessage, null);
	}
	
	private void testEmbed() {
		embed = new EmbedBuilder();
		embed.setThumbnail("https://img.memecdn.com/computer-science-students-will-get-this_o_216650.jpg");
		embed.setTitle("You found the Easter Egg !");
		embed.setColor(0x527A00);
		channel.sendMessage(embed.build()).queue();
	}
	
=======
>>>>>>> branch 'main' of https://github.com/LordChester64/CS321_Monopoly_Bot.git
	/* Used for constructing and sending generic embed message. 
	 * If no title or footer is present, call the function with them as null: 
	 * sendGenericEmbed(null, description, null); */
	public void sendGenericEmbed(String title, String description, String footer) {
		if ( (title != null) && !(title.equals(""))) //if not null string or empty String
			embed.setTitle(title);
		if ( (description.length() < 2048) && (description != null) ) // max length for an embed description.
			embed.setDescription(description);
		else embed.setDescription("Invalid description String. Cannot exceed 2048 or null");
		
		embed.setFooter(footer); // doesnt need to handle exceoption since setFooter accepts null
		channel.sendMessage(embed.build()).queue();
	}
}









