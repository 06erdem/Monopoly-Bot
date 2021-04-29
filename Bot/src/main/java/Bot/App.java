package Bot;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;


public class App
{
    public static void main( String[] args ) throws LoginException {
       JDABuilder builder = JDABuilder.createDefault("Enter key here");
	   builder.setActivity(Activity.watching("CS 321 Vids"));
	   Receiver receiver = new Receiver();
	   builder.addEventListeners(receiver);
	   builder.build();
		
    }
}
