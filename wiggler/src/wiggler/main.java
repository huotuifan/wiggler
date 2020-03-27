package wiggler;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Point;
import java.awt.MouseInfo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

	public static void main(String[] args) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd h:mm:ss a");
			Date date = new Date();
			System.out.println("Break start: " + dateFormat.format(date));
			
			// Create yourself and find your handy-dandy mouse 
			Robot me = new Robot();
			Point mousePos = MouseInfo.getPointerInfo().getLocation();
			
			// Number of minutes to wait before pressing key again
			int minutes = 4, wait = 0;
			
			while(true)
			{
				System.out.println("Minutes inactive: " + wait);
				Thread.sleep(minutes * 60000);
				mousePos = MouseInfo.getPointerInfo().getLocation();
				me.mouseMove(mousePos.x+1, mousePos.y+1);
				me.mouseMove(mousePos.x-1, mousePos.y-1);
				wait += minutes;
			}
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
}
