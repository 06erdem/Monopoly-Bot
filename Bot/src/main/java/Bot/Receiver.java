package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Receiver extends ListenerAdapter {
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		int playCommand = 0;
		int startCommand = 0;
		int[] playersAvailable = new int[4];
		String content = e.getMessage().getContentRaw().toLowerCase();
		if(content.equals("hi")) {
			e.getChannel().sendMessage("what's up mate").queue();
		}
		/*for testing purpose, should be deleted afterwards.*/
		//Board board_temp = new Board();
		if(content.contains("!delete")) {
			e.getChannel().purgeMessages(e.getChannel().getHistory().retrievePast(50).complete());
		}
		if(content.equals("!play")) {
			Board board_temp = new Board();
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Welcome to Discord Monopoly!");
			embed.setDescription("Select your player emoji.\n1 :pickup_truck:    2 :race_car:    3 :bus:    4 :motorcycle:");
			embed.setFooter("Type 1, 2, 3 or 4.\n2-4 Players required\nPlayers cannot choose the same emoji. Type '!start' when ready.");
			e.getChannel().sendMessage(embed.build()).queue();
			playCommand = 1;
			playersAvailable = [0, 0, 0, 0];
			//e.getMessage().addReaction("U+2705").queue();
		}
		if(playCommand){
			if(content.equals("1")) {
				if(!playersAvailable[0]){
					board_temp.addPlayer(event.getAuthor().getIdLong(), ":pickup_truck:");
					playersAvailable[0] = 1;
				}
				else{
					embed.setTitle("Player 1 Token is already taken");
					e.getChannel().sendMessage(embed.build()).queue();
				}
			}
			if(content.equals("2")) {
				if(!playersAvailable[1]){
					board_temp.addPlayer(event.getAuthor().getIdLong(), ":race_car:");
					playersAvailable[1] = 1;
				}
				else{
					embed.setTitle("Player 2 Token is already taken");
					e.getChannel().sendMessage(embed.build()).queue();
				}
			}
			if(content.equals("3")) {
				if(!playersAvailable[2]){
					board_temp.addPlayer(event.getAuthor().getIdLong(), ":bus:");
					playersAvailable[2] = 1;
				}
				else{
					embed.setTitle("Player 3 Token is already taken");
					e.getChannel().sendMessage(embed.build()).queue();
				}
			}
			if(content.equals("4")) {
				if(!playersAvailable[3]){
					board_temp.addPlayer(event.getAuthor().getIdLong(), ":motorcycle:");
					playersAvailable[3] = 1;
				}
				else{
					embed.setTitle("Player 4 Token is already taken");
					e.getChannel().sendMessage(embed.build()).queue();
				}
			}
			if(content.equals("!start")) {
				EmbedBuilder embed = new EmbedBuilder();
				if(board_temp.getNumPlayers() <= 1){
					embed.setTitle("Not Enough Players");
					embed.setDescription("Select your player emoji.\n1 :pickup_truck:    2 :race_car:    3 :bus:    4 :motorcycle:");
					embed.setFooter("Type 1, 2, 3 or 4.\n2-4 Players required\nPlayers cannot choose the same emoji. Type '!start' when ready.");
					e.getChannel().sendMessage(embed.build()).queue();
				}
				else{
					board_temp.setCurrPlayer(0);
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
				String rollOutput = board_temp.rollDice();
				String rollArray[] = rollOutput.split(" ", 2)
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
	
}
