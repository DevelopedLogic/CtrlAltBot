package developerEvents;

//this class manages the shutdown command for the bot.

import java.util.concurrent.TimeUnit;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Shutdown extends ListenerAdapter{
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
		if(isDeveloper){
			if(message.equals(prefix+"!quit")){
				event.getChannel().sendMessage("Bot backend will shut down in 3 seconds!").queue(); //Send a confirmation message
				main.State.setDnd(); //Make the bot have a Do Not Disturb status
				try{
					TimeUnit.SECONDS.sleep(3); //Wait for 3 seconds
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				main.State.shutdown(); //Shut the bot down
			}
		}
    }
}
