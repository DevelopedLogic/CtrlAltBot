package developerEvents;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ForceShutdown extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String message = event.getMessage().getContent(); //Grab the actual message
		boolean isDeveloper = false;
		for(String devId:vars.Constants.developerNames){
            if(devId.equals(event.getAuthor().getId())){
                isDeveloper = true;
                break;
            }
        }
		if(message.equals(prefix+"!fquit")){
			if(isDeveloper){
				main.ReactionAdder.addTick(event);
				event.getChannel().sendMessage("Forced quick quitting now!").queue(); //Send a confirmation message
				main.State.shutdown(); //Shut the bot down
			}else{
				main.ReactionAdder.addNoentry(event);
			}
		}
    }
}
