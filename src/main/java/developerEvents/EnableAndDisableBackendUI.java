package developerEvents;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class EnableAndDisableBackendUI extends ListenerAdapter{
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
			if(message.equals(prefix+"!eui")){
				vars.Handlers.ui.setVisible(true);
				event.getChannel().sendMessage("Enabled Backend UI!").queue();
			}else if(message.equals(prefix+"!dui")){
				vars.Handlers.ui.setVisible(false);
				event.getChannel().sendMessage("Disabled Backend UI!").queue();
			}
		}
    }
}
