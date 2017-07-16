package main;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class DevExplainer extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String message = event.getMessage().getContent(); //Grab the actual message
		if(message.equals(prefix+"whatdev")){
			main.ReactionAdder.addTick(event);
			EmbedBuilder eb = new EmbedBuilder(); //Make a fancy embed box
	        eb.setDescription("Info will go here..."); //Set the contents of the fancy embed box
			event.getChannel().sendMessage(eb.build()).queue(); //Send the fancy embed box as a message
		}
    }
}
