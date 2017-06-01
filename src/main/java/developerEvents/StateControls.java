package developerEvents;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class StateControls extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix;
		String message = event.getMessage().getContent();
		boolean isDeveloper = false;
		for(String devId:vars.Constants.developerNames){
            if(devId.equals(event.getAuthor().getId())){
                isDeveloper = true;
                break;
            }
        }
		if(isDeveloper){
			if(message.equals(prefix+"!dnd")){
				main.State.setDnd();
				event.getChannel().sendMessage("Do Not Disturb Mode!").queue();
			}else if(message.equals(prefix+"!online")){
				main.State.setOnline();
				event.getChannel().sendMessage("Online Mode!").queue();
			}else if(message.equals(prefix+"!idle")){
				main.State.setIdle();
				event.getChannel().sendMessage("Idle Mode!").queue();
			}else if(message.equals(prefix+"!offline")){
				main.State.setOffline();
				event.getChannel().sendMessage("Offline Mode!").queue();
			}
		}
    }
}
