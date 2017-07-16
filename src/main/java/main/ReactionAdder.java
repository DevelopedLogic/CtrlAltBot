package main;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ReactionAdder{
	public static void addTick(MessageReceivedEvent event){
		event.getMessage().addReaction("✅").queue();
	}
	
	public static void addCross(MessageReceivedEvent event){
		event.getMessage().addReaction("❌").queue();
	}
	
	public static void addNoentry(MessageReceivedEvent event){
		event.getMessage().addReaction("🚫").queue();
	}
	
	public static void addLike(MessageReceivedEvent event){
		event.getMessage().addReaction("👍").queue();
	}
	
	public static void addDislike(MessageReceivedEvent event){
		event.getMessage().addReaction("👎").queue();
	}
}
