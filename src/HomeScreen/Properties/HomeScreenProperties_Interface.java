package HomeScreen.Properties;

import javax.swing.JLabel;
import javax.swing.JPanel;

public interface HomeScreenProperties_Interface {

	public void SetHeaderProperties(JPanel headerPanel, int windowWidth);
	public void SetClockProperties(JLabel clockLabel, int windowWidth);
	public void SetDateProperties(JLabel dateLabel, int windowWidth);
	public void SetWeatherProperties(JLabel dateLabel, int windowWidth);
	public void SetFooterProperties(JPanel footerPanel, int windowWidth);
}
