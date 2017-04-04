package HomeScreen.Logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;

public class ClockGatherer implements Runnable, DateTime_Interface 
{
	Thread t1 = null;
	int hours = 0, minutes = 0, seconds = 0;
	String time = "";
	
	JLabel digitalClock;
	
	public ClockGatherer(){}
	
	public void Start(JLabel label)
	{
		digitalClock = label;
		
		t1 = new Thread(this);
		t1.start();
	}

	public void run() 
	{
	      try 
	      {
	         while (true) 
	         {
	            Calendar cal = Calendar.getInstance();  
	            hours = cal.get( Calendar.HOUR_OF_DAY );  
	            
	            if (hours > 12) hours -= 12;  
	            
	            minutes = cal.get( Calendar.MINUTE );  
	            seconds = cal.get( Calendar.SECOND );
	            
	            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");  
	            Date d = cal.getTime();  
	            
	            time = formatter.format( d );
	            
	            if(time.substring(0, 1).equals("0"))
	            	digitalClock.setText(time.substring(1));
	            else
	            	digitalClock.setText(time);
	            
	            t1.sleep( 1000 ); 
	         }  
	      }  
	      catch (Exception e) 
	      { 
	    	  System.out.println("ERROR | " + e); 
	      }  
	}
}
