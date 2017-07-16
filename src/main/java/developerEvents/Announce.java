package developerEvents;

//This class manages the announce command for the bot.

import java.util.List;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Announce extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		List<Guild> guildList = vars.Handlers.jdaHandler.getGuilds(); //Build a list of servers
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String[] message = event.getMessage().getContent().split(" "); //Split the message up into arguments
		String compiled = ""; //Make an empty string
		boolean isDeveloper = false;
		for(String devId:vars.Constants.developerNames){
            if(devId.equals(event.getAuthor().getId())){
                isDeveloper = true;
                break;
            }
        }
		if(message[0].equals(prefix+"!ann")){
			if(isDeveloper){
				if(message.length < 2){
					event.getChannel().sendMessage("Usage: `"+prefix+"!ann <word> (word) (word)...`").queue(); //Have a go at the user for improper syntax
					main.ReactionAdder.addCross(event);
				}else{
					main.ReactionAdder.addTick(event);
					for(int i = 1; i < message.length; i++){
						compiled = compiled+" "+message[i]; //Attach an argument to the string
					}
					final String compiled1 = compiled; //Stop Java from having a meltdown
					try{
						guildList.stream().forEach(guild -> (guild.getPublicChannel().sendMessage("`"+compiled1+"`")).queue()); //Send the message to all servers
					}catch(PermissionException e){
						//System.err.println("Was not able to announce in a public channel");
						//We don't care, ignore it.
					}
				}
			}else{
				main.ReactionAdder.addNoentry(event);
			}
		}
    }
}
