package main;

//This class states the presence of the bot when it comes online to all connected servers.

import java.util.List;
import net.dv8tion.jda.core.entities.Guild;

public class OnlineAct{
	public static void statePresence(){
		if(vars.BotConfig.StateOnlinePresence){ //Check if broadcasting is turned on or not
			List<Guild> guildList = vars.Handlers.jdaHandler.getGuilds(); //Build a list of servers
			guildList.stream().forEach(guild -> (guild.getPublicChannel().sendMessage("Hello! I'm online!")).queue()); //For every server broadcast the message
			System.out.println("[OnlineAct] Successfuly notified all servers of presence"); //Log in console that we have broadcasted
		}else{
			System.out.println("[OnlineAct] Online notification to all servers is disabled"); //Log in console that we have not broadcasted
		}
	}
}
