package Bot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;


public class App 
{
    public static void main( String[] args ) throws LoginException {
    	JDABuilder builder = JDABuilder.createDefault("ODA5MDgwNTIzNTAyMzg3Mjkw.YCP49A.teu4fV_d8-Dy-8ae6rsFz-MMbLk");
		//JDA builder = JDABuilder.createDefault("ODIxNTY4ODkyNzQ4MzAwMjg4.YFFnqA.s7jw9fEVbwgd-fcWsiy4Anc_X8c").build();
		// Disable parts of the cache
	    //builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
	    // Enable the bulk delete event
	    //builder.setBulkDeleteSplittingEnabled(false);
	    // Disable compression (not recommended)
	    //builder.setCompression(Compression.NONE);
	    // Set activity (like "playing Something")
	   builder.setActivity(Activity.watching("CS 321 Vids"));
	   
	   builder.build();
		
    }
}
