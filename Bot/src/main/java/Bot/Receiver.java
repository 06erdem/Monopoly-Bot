package Bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Receiver extends ListenerAdapter {
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		if(e.getMessage().getContentRaw().equals("hi")) {
			e.getChannel().sendMessage("what's up mate").queue();
		}
		if(e.getMessage().getContentRaw().equals("cool")) {
			e.getChannel().sendMessage("ikr!").queue();
		}
	}
	
}