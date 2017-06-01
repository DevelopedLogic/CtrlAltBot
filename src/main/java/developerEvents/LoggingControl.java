package developerEvents;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class LoggingControl extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String message = event.getMessage().getContent();
		boolean isDeveloper = false;
		for(String devId:vars.Constants.developerNames){
            if(devId.equals(event.getAuthor().getId())){
                isDeveloper = true;
                break;
            }
        }
		if(isDeveloper){
			if(message.equals(prefix+"!el")){
				vars.BotConfig.log = true;
				event.getChannel().sendMessage("Enabled Chat Logging!").queue();
			}else if(message.equals(prefix+"!dl")){
				vars.BotConfig.log = false;
				event.getChannel().sendMessage("Disabled Chat Logging!").queue();
			}
		}
    }
}
