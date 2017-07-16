package main;

//This is the main class which sets everything up.

import javax.security.auth.login.LoginException;
import developerEvents.*;
import developerEvents.Shutdown;
import events.*;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Main{
    public static void main(String[] args) throws LoginException, RateLimitedException, InterruptedException{
        JDA bot = new JDABuilder(vars.BotConfig.accType).setToken(vars.BotConfig.token).buildBlocking(); //Make the bot
        vars.Handlers.jdaHandler = bot; //Put the bot in the global handler
        if(vars.BotConfig.uiEnabled){
        	UI.init(); //Open the Backend UI
        	Reg.register(new EnableAndDisableBackendUI());
        }
        bot.getPresence().setGame(Game.of(vars.BotConfig.prefix+"help")); //Set the default "Playing" message
        OnlineAct.statePresence(); //Tell all servers  we have come online
        
        //Register all event handlers
        Reg.register(new Hello());
        Reg.register(new Shutdown());
        Reg.register(new ForceShutdown());
        Reg.register(new Announce());
        Reg.register(new StateControls());
        Reg.register(new Logger());
        Reg.register(new LoggingControl());
        Reg.register(new ForceJoinAndLeaveVoice());
        Reg.register(new PermissionChecker());
        Reg.register(new ForceMuteAndDeafenVoice());
        Reg.register(new ChannelIDGetter());
        Reg.register(new EasterEggs());
        //Reg.register(new RandomLinkGen());
        //Reg.register(new TypingDisplayer());
        Reg.register(new LikeThis());
        Reg.register(new DislikeThis());
        Reg.register(new TestEmoji());
        Reg.register(new MakeEmbeddedMessage());
        Reg.register(new HelpHandler());
        Reg.register(new DevExplainer());
    }
}