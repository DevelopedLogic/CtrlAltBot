package main;

import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class HelpHandler extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String message = event.getMessage().getContent(); //Grab the actual message
		if(message.equals(prefix+"help")){
			main.ReactionAdder.addTick(event);
			EmbedBuilder eb = new EmbedBuilder(); //Make a fancy embed box
			eb.setTitle(vars.Constants.botName+" Help Menu Key:");
			eb.setDescription("The red box contains command any user can do.\nThe green box contains commands only administrators and developers can do.\nThe blue box contains commands only developers can do.\n\nFor more information on what a developer is, please run "+prefix+"whatdev"); //Set the contents of the fancy embed box
	        event.getChannel().sendMessage(eb.build()).queue(); //Send the fancy embed box as a message
	        eb.setTitle(null);
	        eb.setDescription("Any user commands will go here...");
	        eb.setColor(new Color(255, 0, 0));
	        event.getChannel().sendMessage(eb.build()).queue();
	        eb.setDescription("Administrator commands will go here...");
	        eb.setColor(new Color(0, 255, 0));
	        event.getChannel().sendMessage(eb.build()).queue();
	        eb.setDescription("Developer commands will go here...");
	        eb.setColor(new Color(0, 0, 255));
	        event.getChannel().sendMessage(eb.build()).queue();
		}
    }
}
