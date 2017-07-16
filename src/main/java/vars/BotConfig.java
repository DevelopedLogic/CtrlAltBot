package vars;

//This class holds settings. Final values cannot be programmed to be changed by the bot.

import net.dv8tion.jda.core.AccountType;

public class BotConfig{
	//Settings
	public static final AccountType accType = AccountType.BOT;
	public static final String token = "";
	public static String prefix = ",";
	public static boolean StateOnlinePresence = false;
	public static boolean log = false;
	public static boolean uiEnabled = true;
}
