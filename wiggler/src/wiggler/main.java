package wiggler;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

	public static void main(String[] args) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd h:mm:ss a");
			Date date = new Date();
			System.out.println("Break start: " + dateFormat.format(date));
			
			Robot robot = new Robot();
			int minutes = 4, wait = 0; // Number of minutes to wait before pressing key again
			
			while(true)
			{
				System.out.println("Minutes inactive: " + wait);
				Thread.sleep(minutes * 60000);
				robot.keyPress(KeyEvent.VK_SHIFT);	
				robot.keyRelease(KeyEvent.VK_SHIFT);
				wait += minutes;
			}
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
}
