package demo;

import javax.swing.*;

import GUISettings.Settings.Settings;

public class GUI {

	JFrame GUIwindow;
	JPanel GUIcontainer;
	
	Settings GUIsettings;
	
	public GUI()
	{
		InitializeGUI();
		
		GUIsettings = new Settings();
		GUIsettings.SetFrameSettings(GUIwindow);
	}
	
	public void InitializeGUI()
	{
		GUIwindow = new JFrame();
		GUIcontainer = new JPanel();
		
		GUIwindow.getContentPane().add(GUIcontainer);
	}
}
