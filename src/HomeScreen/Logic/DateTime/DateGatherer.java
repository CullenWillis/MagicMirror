package HomeScreen.Logic.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class DateGatherer implements Runnable, DateTime_Interface
{
	Thread t1 = null;
	String date = "";
	
	JLabel dateLabel;
	
	public DateGatherer()
	{
		
	}
	
	public void Start(JLabel label)
	{
		dateLabel = label;
		
		t1 = new Thread(this);
		t1.start();
	}

	public void run() 
	{
	      try 
	      {
	         while (true) 
	         {
	        	 Date now = new Date();
	             SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
	             
	             dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
	             date = dateFormatter.format(now);
	        	 
	        	 dateLabel.setText(date);
	        	 t1.sleep( 1000 ); 
	         }  
	      }  
	      catch (Exception e) 
	      { 
	    	  System.out.println("ERROR | " + e); 
	      }  
	}
}
