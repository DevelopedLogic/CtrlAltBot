package events;

import java.util.Random;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class RandomLinkGen extends ListenerAdapter{
	@Override
    public void onMessageReceived(MessageReceivedEvent event){
		String prefix = vars.BotConfig.prefix; //Grab the prefix locally
		String message = event.getMessage().getContent(); //Grab the actual message
		
		String[] possibilities = {
		"https://static.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg"
		,"http://www.rd.com/wp-content/uploads/sites/2/2016/04/01-cat-wants-to-tell-you-laptop.jpg"
		,"https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg"
		,"http://animalpetdoctor.homestead.com/acat1.jpg"
		,"https://static.pexels.com/photos/115011/cat-face-close-view-115011.jpeg"
		};
		
		if(message.equals(prefix+"randlink")){
			main.ReactionAdder.addTick(event);
			Random chooser = new Random();
			int choice = chooser.nextInt(possibilities.length-1) + 0; //+0 is the minimum
			
			event.getChannel().sendMessage(possibilities[choice]).queue();
		}
    }
}