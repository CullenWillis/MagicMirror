package Settings;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import javax.swing.*;

public class Settings implements Settings_Interface{
	
	// Global Variables
	private Properties settings;
	
	private Boolean testingMode = false;
	
	private String directory = null;
	private String propertiesFile = "settings.properties";
	
	private Dimension preferredResolution;
	private Dimension screenSize;
	
	public Settings()
	{
		// Intializing properties variable and checking it can find the file.
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		settings = new Properties();
		
		URL u = getClass().getProtectionDomain().getCodeSource().getLocation();
		
		System.out.println("Searching for properties file...");
		
	    try 
	    {
			File f = new File(u.toURI());
			directory = f.getParent();
			
			directory += "\\" + propertiesFile;
		} 
	    catch (URISyntaxException e1) 
	    {
	    	System.out.println("ERROR | " + e1);
		}

		
		try 
		{
			settings.load(new FileInputStream(directory));
			System.out.println("properties file found! Time lapse: " + System.currentTimeMillis() % 1000 + "ms");
		}
		catch (IOException e)
		{
			System.out.println("ERROR | Couldn't find file: settings.properties");
		}
	}
	
	public void SetWindowSettings(JFrame window)
	{
		if(settings != null)
		{
			// True antialiasing on!
			System.setProperty("awt.useSystemAAFontSettings","on"); 
			System.setProperty("swing.aatext", "true");
			 
			// Receive values from the properties file
			int windowWidth = Integer.parseInt(settings.getProperty("windowWidth", String.valueOf((int)screenSize.getWidth())));
			int windowHeight = Integer.parseInt(settings.getProperty("windowHeight", String.valueOf((int)screenSize.getHeight())));
			
			boolean windowResizable = Boolean.parseBoolean(settings.getProperty("windowResizable", "false"));
			boolean windowUndecorated = Boolean.parseBoolean(settings.getProperty("windowUndecorated", "true"));
			boolean windowExtendedState = Boolean.parseBoolean(settings.getProperty("windowExtendedState", "true"));
			Dimension size = new Dimension(windowWidth, windowHeight);
			preferredResolution = size;
			
			// Testing mode to put the application in windowed mode
			if(testingMode)
			{
				window.setSize(new Dimension(1600, 1024));
			}
			else
			{
				window.setSize(size);
				
				if(windowExtendedState)
				{
					window.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
				
				window.setUndecorated(windowUndecorated);
			}
				
			// Set values from properties file to the JFrame
			window.setLocationRelativeTo(null); 
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close (DISPOSE_ON_CLOSE, dispose frame)
			window.setTitle("Magic Mirror"); // title
			window.setResizable(windowResizable);
			window.getContentPane().setBackground(Color.BLACK);
			
			System.out.println("- Application properties set");
		}
		else
		{
			System.out.println("ERROR | Couldn't find file: settings.properties");
		}
	}

	public void SetHomeScreenLayout(JFrame window, JPanel panel)
	{
		// Intialize layout style
		BorderLayout layout = new BorderLayout();
		
		// Panel settings
		panel.setBackground(Color.BLACK);
		panel.setSize(preferredResolution);
		
		// Window settings (Will place panel in the center and allow it to grow until its the same size as the window.
		panel.setLayout(layout);
		window.add(panel);
		
		System.out.println("- HomeScreen properties set");
	}
	
	public Dimension GetResolution() { return preferredResolution; }
}
