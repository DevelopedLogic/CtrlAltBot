package main;

//This class build a UI for the backend which gives important info and allows control.

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI{
	public static void init(){
		JFrame ui = new JFrame(vars.Constants.botName); //Make the UI
		JButton shutdownButton = new JButton("Shutdown"); //Make the Shutdown button
		JLabel statusLabel = new JLabel("Online"); //Make the Online Status text
		JPanel pane = new JPanel(); //Make the UI component container
		
		vars.Handlers.ui = ui; //Push the UI to the global handler
		vars.Handlers.uiOnlineStatus = statusLabel; //Push the UI's Online Status text to the global handler
		
		ui.add(pane); //Put the container in the window
		pane.add(shutdownButton); //put the Shutdown button in the container
		pane.add(statusLabel); //Put the Online Status text in the container
		
		shutdownButton.addActionListener(uiComponents.ShutdownButton.action); //Assign a function to the Shutdown button
		
		ui.pack(); //Make everything fit the window
		ui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Disable the window's close button
		ui.setVisible(true); //Make the window appear
	}
}
