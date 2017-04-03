package HomeScreen.Properties;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeScreenProperties implements HomeScreenProperties_Interface{

	public void SetHeaderProperties(JPanel headerPanel, int windowWidth)
	{
		headerPanel.setPreferredSize(new Dimension(windowWidth, 200));
		headerPanel.setBackground(Color.BLACK);
		headerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		
		headerPanel.setLayout(null);
	}
	
	public void SetClockProperties(JLabel clockLabel, int windowWidth)
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    ge.getAllFonts();
	    
		clockLabel.setForeground(Color.WHITE);
		clockLabel.setFont(new Font("Gadugi", Font.PLAIN, 100));
		clockLabel.setBounds(20, 10, windowWidth, 100);
	}
	
	public void SetFooterProperties(JPanel footerPanel, int windowWidth)
	{
		footerPanel.setPreferredSize(new Dimension(windowWidth, 150));
		footerPanel.setBackground(Color.BLACK);
		
		FlowLayout layout = new FlowLayout();
		footerPanel.setLayout(layout);
	}
}
