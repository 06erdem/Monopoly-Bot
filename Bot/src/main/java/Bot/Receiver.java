package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class Receiver extends ListenerAdapter {
	
	private Game_Control_Center controller = null;  
	private int startCommand = 0;
	private EmbedBuilder embed;
	private String returnMessage;     //result of an function in Conntroller, default is String "success"
	private String content;
	private MessageChannel channel;   //this variable is used to send message to the channel of the commands just entered
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		//get message and channel of the message
		content = e.getMessage().getContentRaw().toLowerCase();
		channel = e.getChannel();
		
		if(content.equals("hi")) {
			e.getChannel().sendMessage("what's up mate!").queue();
		}
		
		if(content.contains("!delete")) {
			e.getChannel().purgeMessages(e.getChannel().getHistory().retrievePast(50).complete());
		}
		
//		if(content.equals("!play")) {
//			Board board_temp = new Board();
//			EmbedBuilder embed = new EmbedBuilder();
//			embed.setTitle("Welcome to Discord Monopoly!");
//			embed.setDescription("Select your player emoji.\n1 :pickup_truck:    2 :race_car:    3 :bus:    4 :motorcycle:");
//			embed.setFooter("Type 1, 2, 3 or 4.\n2-4 Players required\nPlayers cannot choose the same emoji. Type '!start' when ready.");
//			e.getChannel().sendMessage(embed.build()).queue();
//
//		}
		
		/* Actions when game has not been initialized */
		if(content.equals("!play")) decideAction(0); 
		if(content.equals("!join1") || content.equals("!join 1")) decideAction(1);	// join as player 1
		if(content.equals("!join2"	|| content.equals("!join 2")) decideAction(2);  // join as player 2
		if(content.equals("!join3"	|| content.equals("!join 3")) decideAction(3);  // join as player 3
		if(content.equals("!join4"	|| content.equals("!join 4")) decideAction(4);  // join as player 4
		
		/* Actions when game is running */
		
		if(playCommand  != 0) {
			if(content.equals("1")) {
				if(!playersAvailable[0]){
					//Add Player function
					board_temp.numPlayers++; //Temp stub to allow testing
					playersAvailable[0] = 1;
				}
				else{
					embed.setTitle("Player 1 Token is already taken");
					e.getChannel().sendMessage(embed.build()).queue();
				}
			}
			if(content.equals("2")) {
				if(!playersAvailable[1]){
					//Add Player function
					board_temp.numPlayers++; //Temp stub to allow testing
					playersAvailable[1] = 1;
				}
				else{
					embed.setTitle("Player 2 Token is already taken");
					e.getChannel().sendMessage(embed.build()).queue();
				}
			}
			if(content.equals("3")) {
				if(!playersAvailable[2]){
					//Add Player function
					board_temp.numPlayers++; //Temp stub to allow testing
					playersAvailable[2] = 1;
				}
				else{
					embed.setTitle("Player 3 Token is already taken");
					e.getChannel().sendMessage(embed.build()).queue();
				}
			}
			if(content.equals("4")) {
				if(!playersAvailable[3]){
					//Add Player function
					board_temp.numPlayers++; //Temp stub to allow testing
					playersAvailable[3] = 1;
				}
				else{
					embed.setTitle("Player 4 Token is already taken");
					e.getChannel().sendMessage(embed.build()).queue();
				}
			}
			if(content.equals("!start")) {
				EmbedBuilder embed = new EmbedBuilder();
				if(board_temp.numPlayers <= 1){
					embed.setTitle("Not Enough Players");
					embed.setDescription("Select your player emoji.\n1 :pickup_truck:    2 :race_car:    3 :bus:    4 :motorcycle:");
					embed.setFooter("Type 1, 2, 3 or 4.\n2-4 Players required\nPlayers cannot choose the same emoji. Type '!start' when ready.");
					e.getChannel().sendMessage(embed.build()).queue();
				}
				else{
					board_temp.currPlayer = 1;
					embed.setTitle("Let the Game Begin!");
					embed.setDescription("");
					embed.setFooter("");
					e.getChannel().sendMessage(embed.build()).queue();
					playCommand = 0;
					startCommand = 1;
				}
			}
		}
		if(startCommand){
			if(content.equals("!roll")){
				
				rollArray = board_temp.rollDice().split(" ", 2);
				int sum = Integer.parseInt(rollArray[0]) + Integer.parseInt(rollArray[1]);
				EmbedBuilder embed = new EmbedBuilder();
				embed.setTitle("Rolled Dice!");
				embed.setDescription("Dice 1: " + rollArray[0] + "\nDice 2: " + rollArray[1] + "\nTotal: " + sum);
				if(rollArray[0].equals(rollArray[1])){
					embed.setFooter("Doubles! Roll Again!");
				}
				e.getChannel().sendMessage(embed.build()).queue();
			}
			if(content.toLowerCase().equals("printboard")) {
				e.getChannel().sendMessage(board_temp.printBoard()).queue();
			}
			
			//***This is how we can make the board and output look pretty.***//
			if(content.toLowerCase().equals("!printboard")) {
				EmbedBuilder embed = new EmbedBuilder();
				embed.setTitle(":pickup_truck: player's turn!");
				embed.setDescription(board_temp.printBoard());
				embed.setFooter("Instruction can be here:\nType 1 to buy\nType 2 to mortgage\n");
				e.getChannel().sendMessage(embed.build()).queue();
			}
		}
	}
	
//	/* This is where action is sent to Contrller */
//	private void decideAction(int receivedMessageID) {
//		if (receivedMessageID == 1) start();
//		if (receivedMessageID == 2) join();
//	}
	
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
	
	private void joinReceiver(int playerID) {
		if (controller == null) { // if no instance of game has been made
			sendGenericEmbed(null, "Failure to join! \n No instance of the game is running."
									+ "Please type !play to create a new game", null);
			return;
		}
		
		
		
	}
	
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









