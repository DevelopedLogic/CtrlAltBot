package events;

import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class EasterEggs extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String message = event.getMessage().getContent(); //Grab the actual message
		if(message.equals("Ctrl+S")){
			EmbedBuilder eb = new EmbedBuilder(); //Make a fancy embed box
	        eb.setDescription("Save complete!"); //Set the contents of the fancy embed box
	        eb.setColor(new Color(255, 0, 0)); //Set the stripe colour of the fancy embed box
			event.getChannel().sendMessage(eb.build()).queue(); //Send the fancy embed box as a message
		}else if(message.equals("Ctrl+a")){
			EmbedBuilder eb = new EmbedBuilder(); //Make a fancy embed box
	        eb.setDescription("Selected all!"); //Set the contents of the fancy embed box
	        eb.setColor(new Color(255, 0, 0)); //Set the stripe colour of the fancy embed box
			event.getChannel().sendMessage(eb.build()).queue(); //Send the fancy embed box as a message
		}
    }
}
