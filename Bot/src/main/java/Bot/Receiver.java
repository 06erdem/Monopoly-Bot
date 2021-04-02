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
	}
	
}
