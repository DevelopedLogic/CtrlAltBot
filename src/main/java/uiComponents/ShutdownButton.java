package uiComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class ShutdownButton{
	public static ActionListener action = new ActionListener(){
		public void actionPerformed(ActionEvent event1){
			System.out.println("[UI] Triggered Shutdown Button");
			ShutdownButton.Shutdown();
		}
	};

	public static void Shutdown()
	{
		main.State.setDnd();
		try{
			TimeUnit.SECONDS.sleep(3);
		}catch(InterruptedException event2){
			event2.printStackTrace();
		}
		main.State.shutdown();
	}
}
