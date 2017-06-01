package events;

//This class manages the hello command for the bot.

import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Hello extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String message = event.getMessage().getContent(); //Grab the actual message
		if(message.equals(prefix+"hello")){
			EmbedBuilder eb = new EmbedBuilder(); //Make a fancy embed box
	        eb.setDescription("Hello "+event.getAuthor().getAsMention()); //Set the contents of the fancy embed box
	        eb.setColor(new Color(255, 0, 0)); //Set the stripe colour of the fancy embed box
			event.getChannel().sendMessage(eb.build()).queue(); //Send the fancy embed box as a message
		}
    }
}
