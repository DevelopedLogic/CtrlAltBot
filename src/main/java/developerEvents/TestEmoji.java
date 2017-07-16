package developerEvents;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class TestEmoji extends ListenerAdapter{
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
		if(message.equals(prefix+"!testreactions")){
			if(isDeveloper){
				main.ReactionAdder.addCross(event);
				main.ReactionAdder.addDislike(event);
				main.ReactionAdder.addLike(event);
				main.ReactionAdder.addNoentry(event);
				main.ReactionAdder.addTick(event);
			}else{
				main.ReactionAdder.addNoentry(event);
			}
		}
    }
}
