import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FollowDirections {
	
//	private static String inputFile = "ScoringInputs/FollowDirections/ActualInput.txt";
	private static String inputFile = "SampleInputs/FollowDirections/SampleInput.txt";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(inputFile);
		BufferedReader reader = null;
		
		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;

		    int x = 0;
		    int y = 0;
		    int direction = 0;
		    
		    while ((text = reader.readLine()) != null) {
		    	String[] sp = text.split(" "); 
		    	if ("Move".equals(sp[0])) {
		    		switch (direction) {
		    		case 0: //North
		    			y += Integer.parseInt(sp[1]);
		    			break;
		    		case 2: //South
		    			y -= Integer.parseInt(sp[1]);
		    			break;
		    		case 1: //East
		    			x += Integer.parseInt(sp[1]);
		    			break;
		    		case 3: //West
		    			x -= Integer.parseInt(sp[1]);
		    			break;
		    		}
		    	} else { ///turn
		    		if (sp[1].equalsIgnoreCase("right")) {
		    			direction = (direction + 1) % 4;
		    		}
		    		else { //left 
		    			direction = (direction - 1 + 4) % 4;
		    		}
		    	}
		    }
		    System.out.println(x + "," + y);
		    
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
