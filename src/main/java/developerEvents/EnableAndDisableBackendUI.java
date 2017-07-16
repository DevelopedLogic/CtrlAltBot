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
		if(message.equals(prefix+"!eui")){
			if(isDeveloper){
				main.ReactionAdder.addTick(event);
				vars.Handlers.ui.setVisible(true);
				event.getChannel().sendMessage("Enabled Backend UI!").queue();
				main.ReactionAdder.addTick(event);
			}else{
				main.ReactionAdder.addNoentry(event);
			}
		}else if(message.equals(prefix+"!dui")){
			if(isDeveloper){
				main.ReactionAdder.addTick(event);
				vars.Handlers.ui.setVisible(false);
				event.getChannel().sendMessage("Disabled Backend UI!").queue();
				main.ReactionAdder.addTick(event);
			}else{
				main.ReactionAdder.addNoentry(event);
			}
		}
    }
}
