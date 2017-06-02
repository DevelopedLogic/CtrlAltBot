package audio;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import net.dv8tion.jda.core.entities.TextChannel;

public class AudioHandler implements AudioLoadResultHandler{
	String trackUrl;
	TextChannel channel;
	GuildMusicManager musicManager;
	AudioFunctions loopback;
	public AudioHandler(String trackUrl, TextChannel channel, GuildMusicManager musicManager, AudioFunctions audioFunctions){
		this.trackUrl = trackUrl;
		this.channel = channel;
		this.musicManager = musicManager;
		this.loopback = audioFunctions;
	}
	@Override
	public void trackLoaded(AudioTrack track) {
		channel.sendMessage("Adding to queue " + track.getInfo().title).queue();
		
		loopback.play(channel.getGuild(), musicManager, track);
	}
	
	@Override
	public void playlistLoaded(AudioPlaylist playlist) {
		AudioTrack firstTrack = playlist.getSelectedTrack();
		
		if (firstTrack == null) {
			firstTrack = playlist.getTracks().get(0);
		}
		
		channel.sendMessage("Adding to queue " + firstTrack.getInfo().title + " (first track of playlist " + playlist.getName() + ")").queue();
		
		loopback.play(channel.getGuild(), musicManager, firstTrack);
	}
	
	@Override
	public void noMatches() {
		channel.sendMessage("Nothing found by " + trackUrl).queue();
	}
	
	@Override
	public void loadFailed(FriendlyException exception) {
		channel.sendMessage("Could not play: " + exception.getMessage()).queue();
	}
}
