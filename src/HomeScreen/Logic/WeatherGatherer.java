package HomeScreen.Logic;


import javax.swing.JLabel;



public class WeatherGatherer implements Runnable, Weather_Interface{
	
	Thread t1 = null;
	
	JLabel weatherLabel;
	
	String weatherTempature = "";
	String weatherLocation = "";
	
	public WeatherGatherer()
	{
		
	}
	
	public void StartWeather(JLabel label, String location)
	{
		weatherLabel = label;
		weatherLocation = location;
		
		t1 = new Thread(this);
		t1.start();
	}

	public void run() 
	{
		try 
		{		
			while (true) 
     		{
				
				weatherLabel.setText(display.getCondition());
				
    	 		t1.sleep( 1000 ); 
     		}  
  		}  
		catch (Exception e) 
		{ 
	  		System.out.println("ERROR | " + e); 
  		}  
	}
}
