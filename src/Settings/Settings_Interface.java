package Settings;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public interface Settings_Interface
{
	public void SetWindowSettings(JFrame window);
	public void SetHomeScreenLayout(JFrame window, JPanel panel);
	public Dimension GetResolution();
}
