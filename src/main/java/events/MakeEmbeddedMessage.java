package events;

//This class manages the hello command for the bot.

import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MakeEmbeddedMessage extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String[] message = event.getMessage().getContent().split(" "); //Split the message up into arguments
		String compiled = ""; //Make an empty string
		if(message[0].equals(prefix+"buildembed")){
			if(message.length < 5){
				event.getChannel().sendMessage("Usage: `"+prefix+"buildembed <R> <G> <B> <word> (word)...`").queue(); //Have a go at the user for improper syntax
				main.ReactionAdder.addCross(event);
			}else{
				for(int i = 1; i < message.length; i++){
					compiled = compiled+" "+message[i]; //Attach an argument to the string
				}
				final String compiled1 = compiled; //Stop Java from having a meltdown
				EmbedBuilder eb = new EmbedBuilder(); //Make a fancy embed box
		        eb.setDescription(compiled1); //Set the contents of the fancy embed box
		        try{
		        	eb.setColor(new Color(Integer.parseInt(message[1]), Integer.parseInt(message[2]), Integer.parseInt(message[3]))); //Set the stripe colour of the fancy embed box
		        	event.getChannel().sendMessage(eb.build()).queue(); //Send the fancy embed box as a message
		        	main.ReactionAdder.addTick(event);
		        }catch(Exception e){
		        	main.ReactionAdder.addCross(event);
		        	event.getChannel().sendMessage("Arguments 1 2 and 3 must be integers!").queue();
		        }
			}
		}
    }
}
