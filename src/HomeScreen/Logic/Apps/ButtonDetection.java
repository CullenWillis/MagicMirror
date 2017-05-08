package HomeScreen.Logic.Apps;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class ButtonDetection implements ButtonDetection_Interface
{
	public ButtonDetection(){}
	
	public void Start(JLabel label)
	{
		label.addMouseListener(new CustomListener());
	}
}

//This doesn't print anything when i am clicking in the JFrame
class CustomListener implements MouseListener {

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
      if(mouseEvent.getButton() == MouseEvent.BUTTON1)
      {
          System.out.println("left");
      }
      else if(mouseEvent.getButton() == MouseEvent.BUTTON3)
      {
          System.out.println("right");
      }
  }

  @Override
  public void mousePressed(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseReleased(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseEntered(MouseEvent mouseEvent) {

  }

  @Override
  public void mouseExited(MouseEvent mouseEvent) {

  }
}