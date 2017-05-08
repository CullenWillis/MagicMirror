package HomeScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import HomeScreen.Logic.DateTime.ClockGatherer;
import HomeScreen.Logic.DateTime.DateGatherer;
import HomeScreen.Logic.DateTime.DateTime_Interface;
import HomeScreen.Logic.Weather.WeatherGatherer;
import HomeScreen.Logic.Weather.Weather_Interface;
import HomeScreen.Properties.HomeScreenProperties;
import HomeScreen.Properties.HomeScreenProperties_Interface;
import Settings.Settings;
import Settings.Settings_Interface;

public class HomeScreenGUI 
{
	// Global variables
	private Settings_Interface settings; // Interface for Settings class
	private HomeScreenProperties_Interface properties; // Interface for HomeScreen Properties
	private DateTime_Interface dateTime; // Interface for Logic Settings class
	private Weather_Interface weather; // Interface for Logic Settings class
	
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
		
		properties.SetHeaderProperties(headerPanel, windowWidth); // Intialise Header
		properties.SetFooterProperties(footerPanel, windowWidth); // Intialise Footer
		
		// Header Display
		CreateDigitalClock();
		CreateDate();
		CreateWeather();
		
		// Footer Display
		CreateAppButton();
		
		System.out.println("- Header and Footer created");
	}
	
	private void CreateDigitalClock()
	{
		dateTime = new ClockGatherer();
		JLabel clock = new JLabel();
		
		properties.SetClockProperties(clock, windowWidth);
		dateTime.Start(clock);
		
		headerPanel.add(clock);
	}
	
	private void CreateDate()
	{
		dateTime = new DateGatherer();
		JLabel dateLabel = new JLabel();
		
		properties.SetDateProperties(dateLabel, windowWidth);
		dateTime.Start(dateLabel);
		
		headerPanel.add(dateLabel);
	}
	
	private void CreateWeather()
	{
		JLabel weatherLabel = new JLabel();
		
		properties.SetWeatherProperties(weatherLabel, windowWidth);
		//weather.StartWeather(weatherLabel, "31927");
		
		headerPanel.add(weatherLabel);
	}

	private void CreateAppButton()
	{
		try 
		{
			BufferedImage appPicture = ImageIO.read(new File("C:\\Users\\Cullen\\Documents\\GitHub\\MagicMirror\\AppIcon.png"));
			JLabel appButton = new JLabel(new ImageIcon(appPicture));
			footerPanel.add(appButton);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
