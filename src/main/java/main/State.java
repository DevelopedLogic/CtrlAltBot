package main;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class State{
	public static void setOnline(){
		vars.Handlers.jdaHandler.getPresence().setStatus(OnlineStatus.ONLINE);
		if(vars.BotConfig.uiEnabled){
			vars.Handlers.uiOnlineStatus.setText("Online");
			vars.Handlers.ui.pack();
		}
		System.out.println("[State] State was set to ONLINE");
	}
	public static void setOffline(){
		vars.Handlers.jdaHandler.getPresence().setStatus(OnlineStatus.OFFLINE);
		if(vars.BotConfig.uiEnabled){
			vars.Handlers.uiOnlineStatus.setText("Offline/Invis");
			vars.Handlers.ui.pack();
		}
		System.out.println("[State] State was set to OFFLINE");
	}
	public static void setIdle(){
		vars.Handlers.jdaHandler.getPresence().setStatus(OnlineStatus.IDLE);
		if(vars.BotConfig.uiEnabled){
			vars.Handlers.uiOnlineStatus.setText("Idle");
			vars.Handlers.ui.pack();
		}
		System.out.println("[State] State was set to IDLE");
	}
	public static void setDnd(){
		vars.Handlers.jdaHandler.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		if(vars.BotConfig.uiEnabled){
			vars.Handlers.uiOnlineStatus.setText("Do Not Disturb");
			vars.Handlers.ui.pack();
		}
		System.out.println("[State] State was set to DO NOT DISTURB");
	}
	public static void shutdown(){
		vars.Handlers.jdaHandler.shutdown();
		if(vars.BotConfig.uiEnabled){
			vars.Handlers.ui.dispose();	
		}
		System.out.println("[State] Bot will now terminate");
	}
	public static void setGame(String game){
		vars.Handlers.jdaHandler.getPresence().setGame(Game.of(game));
		System.out.println("[State] Bot is now playing: "+game);
	}
}
