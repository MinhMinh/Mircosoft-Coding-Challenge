import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;


public class ClockAngles {

//	private static String inputFile = "ScoringInputs/ClockAngles/ActualInput.txt";
	private static String inputFile = "SampleInputs/ClockAngles/SampleInput.txt";
	
	private static int[] data = new int[3];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(inputFile);
		BufferedReader reader = null;
		
		try {
		    reader = new BufferedReader(new FileReader(file));
		    int n = Integer.parseInt(reader.readLine());
		    
		    System.out.println(n);
		    
		    DecimalFormat df = new DecimalFormat("0.00");
		    
		    for (int i = 0; i < n; i++) {
		    	String[] sp = reader.readLine().split(":");
		    	for (int j = 0; j < 3; j++)
		    		data[j] = Integer.parseInt(sp[j]);
		    	
		    	double angleHour = data[0] * 30.0 + (data[1] * 60.0 + data[2]) / 120.0;
		    	double angleMinute = data[1] * 6.0 + data[2] * 0.1;
		    	double angleSecond = data[2] * 6.0;
		    	/*
		    	System.out.println(angleHour);
		    	System.out.println(angleMinute);
		    	System.out.println(angleSecond);
		    	*/
		    	double hour2minute = Math.abs(angleHour - angleMinute);
		    	if (hour2minute > 180)
		    		hour2minute = 360 - hour2minute;
		    	
		    	double hour2second = Math.abs(angleHour - angleSecond);
		    	if (hour2second > 180)
		    		hour2second = 360 - hour2second;
		    	
		    	double minute2second = Math.abs(angleMinute - angleSecond);
		    	if (minute2second > 180)
		    		minute2second = 360 - minute2second;
		    	
		    	System.out.println(df.format(hour2minute + 0.0000005) + ", " + df.format(hour2second + 0.0000005) + ", " + df.format(minute2second + 0.0000005));
		    }
		    
		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		        
		    } catch (IOException e) {
		    }
		}	
	}
}
