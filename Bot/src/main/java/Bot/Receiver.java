package Bot;

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
		if(e.getMessage().getContentRaw().toLowerCase().contains("printboard")) {
			e.getChannel().sendMessage(board_temp.printBoard()).queue();
		}
		/*for testing purpose, should be deleted afterwards.*/
		Board board_temp = new Board();
		if(e.getMessage().getContentRaw().toLowerCase().contains("printboard")) {
			e.getChannel().sendMessage(board_temp.printBoard()).queue();
		}
		if(e.getMessage().getContentRaw().toLowerCase().contains("!delete")) {
			e.getChannel().purgeMessages(e.getChannel().getHistory().retrievePast(50).complete());
		}
	}
	
}
