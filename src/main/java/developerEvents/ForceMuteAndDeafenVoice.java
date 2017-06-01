package developerEvents;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.AudioManager;

public class ForceMuteAndDeafenVoice extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String[] message = event.getMessage().getContent().split(" "); //Split the message up into arguments
		boolean isDeveloper = false;
		for(String devId:vars.Constants.developerNames){
            if(devId.equals(event.getAuthor().getId())){
                isDeveloper = true;
                break;
            }
        }
		if(isDeveloper){
			if(message[0].equals(prefix+"!fvcm")){
				//Join execution
				if(message.length == 2){
					AudioManager manager = vars.Handlers.jdaHandler.getGuildById(message[1]).getAudioManager();
					if(manager.isSelfMuted()){
						manager.setSelfMuted(false);
						event.getChannel().sendMessage("Unmuted myself on server "+vars.Handlers.jdaHandler.getGuildById(message[1]).getName()).queue();
					}else{
						manager.setSelfMuted(true);
						event.getChannel().sendMessage("Muted myself on server "+vars.Handlers.jdaHandler.getGuildById(message[1]).getName()).queue();
					}
				}else{
					AudioManager manager = event.getGuild().getAudioManager();
					if(manager.isSelfMuted()){
						manager.setSelfMuted(false);
						event.getChannel().sendMessage("Unmuted myself on server "+event.getGuild().getName()).queue();
					}else{
						manager.setSelfMuted(true);
						event.getChannel().sendMessage("Muted myself on server "+event.getGuild().getName()).queue();
					}
				}
			}else if(message[0].equals(prefix+"!fvcd")){
				//Join execution
				if(message.length == 2){
					AudioManager manager = vars.Handlers.jdaHandler.getGuildById(message[1]).getAudioManager();
					if(manager.isSelfDeafened()){
						manager.setSelfDeafened(false);
						event.getChannel().sendMessage("Undeafened myself on server "+vars.Handlers.jdaHandler.getGuildById(message[1]).getName()).queue();
					}else{
						manager.setSelfDeafened(true);
						event.getChannel().sendMessage("Deafened myself on server "+vars.Handlers.jdaHandler.getGuildById(message[1]).getName()).queue();
					}
				}else{
					AudioManager manager = event.getGuild().getAudioManager();
					if(manager.isSelfDeafened()){
						manager.setSelfDeafened(false);
						event.getChannel().sendMessage("Undeafened myself on server "+event.getGuild().getName()).queue();
					}else{
						manager.setSelfDeafened(true);
						event.getChannel().sendMessage("Deafened myself on server "+event.getGuild().getName()).queue();
					}
				}
			}
		}
    }
}
