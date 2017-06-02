package audio;

import java.util.Map;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.managers.AudioManager;

public class AudioFunctions{
	AudioPlayerManager playerManager;
	Map<Long, GuildMusicManager> musicManagers;
	
	public AudioFunctions(AudioPlayerManager playerManager, Map<Long, GuildMusicManager> musicManagers){
		this.playerManager = playerManager;
		this.musicManagers = musicManagers;
	}
	
	public void play(Guild guild, GuildMusicManager musicManager, AudioTrack track) {
		connectToFirstVoiceChannel(guild.getAudioManager());
		
		musicManager.scheduler.queue(track);
	}
	
	public static void connectToFirstVoiceChannel(AudioManager audioManager) {
		if (!audioManager.isConnected() && !audioManager.isAttemptingToConnect()) {
			for (VoiceChannel voiceChannel : audioManager.getGuild().getVoiceChannels()) {
				audioManager.openAudioConnection(voiceChannel);
				break;
			}
		}
	}
	
	public void skipTrack(TextChannel channel) {
		GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
		musicManager.scheduler.nextTrack();
		
		channel.sendMessage("Playing next track in list!").queue();
	}
	
	public void loadAndPlay(final TextChannel channel, final String trackUrl) {
		GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
		
		playerManager.loadItemOrdered(musicManager, trackUrl, new AudioHandler(trackUrl, channel, musicManager, this));
	}
	
	public synchronized GuildMusicManager getGuildAudioPlayer(Guild guild) {
		long guildId = Long.parseLong(guild.getId());
		GuildMusicManager musicManager = musicManagers.get(guildId);
		
		if (musicManager == null) {
				musicManager = new GuildMusicManager(playerManager);
				musicManagers.put(guildId, musicManager);
		}
		
		guild.getAudioManager().setSendingHandler(musicManager.getSendHandler());
		
		return musicManager;
	}
}
