package HomeScreen.Properties;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class HomeScreenProperties implements HomeScreenProperties_Interface{

	public void SetHeaderProperties(JPanel headerPanel, int windowWidth)
	{
		headerPanel.setPreferredSize(new Dimension(windowWidth, 200));
		headerPanel.setBackground(Color.BLUE);
	}
	
	public void SetFooterProperties(JPanel footerPanel, int windowWidth)
	{
		footerPanel.setPreferredSize(new Dimension(windowWidth, 150));
		footerPanel.setBackground(Color.RED);
	}
}
