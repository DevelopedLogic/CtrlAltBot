package events;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class TypingDisplayer extends ListenerAdapter{
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
		if(message.equals(prefix+"!typeon")){
			if(isDeveloper){
				main.ReactionAdder.addTick(event);
				event.getChannel().sendTyping().queue();
			}else{
				main.ReactionAdder.addCross(event);
			}
				
		}
    }
}
