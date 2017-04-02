package HomeScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import HomeScreen.Properties.HomeScreenProperties;
import HomeScreen.Properties.HomeScreenProperties_Interface;
import Settings.Settings;
import Settings.Settings_Interface;

public class HomeScreenGUI 
{
	// Global variables
	private Settings_Interface settings; // Interface for Settings class
	private HomeScreenProperties_Interface properties;
	
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
		properties = new HomeScreenProperties();
	}
	
	public void Start()
	{
		applicationWindow.setVisible(true);
	}
	
	public void Prepare()
	{	
		System.out.println("\nPreparing HomeScreen...");
		
		// Set settings from the properties file
		settings.SetWindowSettings(applicationWindow);
		settings.SetHomeScreenLayout(applicationWindow, containerPanel);
		windowWidth = applicationWindow.getWidth();
		
		// Set the Header and Footer Settings
		CreateContainers();
		
		// Add header & footer to container
		containerPanel.add(headerPanel, BorderLayout.NORTH);
		containerPanel.add(footerPanel, BorderLayout.SOUTH);
		
		System.out.println("Preperations completed! Time lapse: " + System.currentTimeMillis() % 1000 + "ms");
	}
	
	private void CreateContainers()
	{
		headerPanel = new JPanel();
		footerPanel = new JPanel();
		
		properties.SetHeaderProperties(headerPanel, windowWidth);
		properties.SetFooterProperties(footerPanel, windowWidth);
		
		System.out.println("- Header and Footer created");
	}
}
