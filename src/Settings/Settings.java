package Settings;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import javax.swing.*;

public class Settings implements Settings_Interface{
	
	Properties settings;
	
	Boolean testingMode = true;
	String directory = null;
	String propertiesFile = "settings.properties";
	
	public Settings()
	{
		settings = new Properties();
		URL u = getClass().getProtectionDomain().getCodeSource().getLocation();
		
	    try 
	    {
			File f = new File(u.toURI());
			directory = f.getParent();
			
			directory += "\\" + propertiesFile;
		} 
	    catch (URISyntaxException e1) 
	    {
	    	System.out.println(e1);
		}

		
		try 
		{
			settings.load(new FileInputStream(directory));
			System.out.println("properties file found.");
		}
		catch (IOException e)
		{
			System.out.println("Couldn't find file: settings.properties.");
		}
	}
	
	public void SetSettings(JFrame window)
	{
		if(settings != null)
		{
			int windowWidth = Integer.parseInt(settings.getProperty("windowWidth", "1920"));
			int windowHeight = Integer.parseInt(settings.getProperty("windowHeight", "1080"));
			boolean windowResizable = Boolean.parseBoolean(settings.getProperty("windowResizable", "false"));
			boolean windowUndecorated = Boolean.parseBoolean(settings.getProperty("windowUndecorated", "true"));
			boolean windowExtendedState = Boolean.parseBoolean(settings.getProperty("windowExtendedState", "true"));
			Dimension size = new Dimension(windowWidth, windowHeight);
			
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
				
			window.setLocationRelativeTo(null); 
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close (DISPOSE_ON_CLOSE, dispose frame)
			window.setTitle("Magic Mirror"); // title
			window.setResizable(windowResizable);
			window.getContentPane().setBackground(Color.BLACK);
			
			window.setVisible(true);
		}
		else
		{
			System.out.println("Couldn't find file: settings.properties.");
		}
	}
}
