package Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Receiver extends ListenerAdapter {
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		String content = e.getMessage().getContentRaw().toLowerCase();
		if(content.equals("hi")) {
			e.getChannel().sendMessage("what's up mate").queue();
		}
		/*for testing purpose, should be deleted afterwards.*/
		Board board_temp = new Board();
		if(content.toLowerCase().contains("printboard")) {
			e.getChannel().sendMessage(board_temp.printBoard()).queue();
		}

		if(content.contains("!delete")) {
			e.getChannel().purgeMessages(e.getChannel().getHistory().retrievePast(50).complete());
		}
		if(content.equals("!play")) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setTitle("Welcome to Discord Monopoly!");
			embed.setDescription("Select your player emoji.\n1 :pickup_truck:    2 :race_car:    3 :bus:    4 :motorcycle:");
			embed.setFooter("Type 1, 2, 3 or 4.\n2-4 Players required\nPlayers cannot choose the same emoji. Type '!start' when ready.");
			e.getChannel().sendMessage(embed.build()).queue();
			//e.getMessage().addReaction("U+2705").queue();
		}
	}
	
}
