package audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.util.HashMap;
import java.util.Map;

public class AudioEvents extends ListenerAdapter{
	private final AudioPlayerManager playerManager;
	private final Map<Long, GuildMusicManager> musicManagers;
	
	public AudioEvents() {
		this.musicManagers = new HashMap<>();
		this.playerManager = new DefaultAudioPlayerManager();
		AudioSourceManagers.registerRemoteSources(playerManager);
		AudioSourceManagers.registerLocalSource(playerManager);
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String prefix = vars.BotConfig.prefix;
		String[] command = event.getMessage().getContent().split(" ", 2);
		Guild guild = event.getGuild();
		AudioFunctions functionHandler = new AudioFunctions(playerManager, musicManagers);
		
		if(guild != null){
			if(command[0].equals(prefix+"play") && command.length == 2){
				functionHandler.loadAndPlay(event.getTextChannel(), command[1]);
			}else if(command[0].equals(prefix+"next")){
				functionHandler.skipTrack(event.getTextChannel());
			}
		}
	}
}