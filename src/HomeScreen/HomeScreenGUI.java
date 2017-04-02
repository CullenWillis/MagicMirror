package HomeScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Settings.Settings;
import Settings.Settings_Interface;

public class HomeScreenGUI 
{
	// Global variables
	private Settings_Interface settings; // Interface for Settings class
	
	private int windowWidth; // width of the application's window;
	
	private JFrame applicationWindow; // Application's window
	private JPanel containerPanel; // Container
	
	private JPanel headerPanel; // Header
	private JPanel footerPanel; // Footer
	
	public HomeScreenGUI()
	{
		// Intialization
		applicationWindow = new JFrame();
		containerPanel = new JPanel();
		
		settings = new Settings();
	}
	
	public void SetProperties()
	{
		// Set settings from the properties file
		settings.SetWindowSettings(applicationWindow);
		settings.SetHomeScreenLayout(applicationWindow, containerPanel);
		windowWidth = applicationWindow.getWidth();
		System.out.println(windowWidth);
		
		// Set the Header and Footer Settings
		SetHeaderProperties();
		SetFooterProperties();
		
		// Add header & footer to container
		containerPanel.add(headerPanel, BorderLayout.NORTH);
		containerPanel.add(footerPanel, BorderLayout.SOUTH);
	}
	
	private void SetHeaderProperties()
	{
		headerPanel = new JPanel();
		
		headerPanel.setPreferredSize(new Dimension(windowWidth, 200));
		headerPanel.setBackground(Color.BLUE);
	}
	
	private void SetFooterProperties()
	{
		footerPanel = new JPanel();
		
		footerPanel.setPreferredSize(new Dimension(windowWidth, 150));
		footerPanel.setBackground(Color.RED);
	}
}
