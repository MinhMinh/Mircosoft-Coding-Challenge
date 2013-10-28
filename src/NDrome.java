import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class NDrome {

	private static String inputFile = "ScoringInputs/NDrome/ActualInput.txt";
//	private static String inputFile = "SampleInputs/NDrome/SampleInput.txt";
	
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
		    
		    while ((text = reader.readLine()) != null) {
		    	int index = text.indexOf("|");
		    	
		    	String s = text.substring(0, index);
		    	int n = Integer.parseInt(text.substring(index + 1));
		    	
		    	String t = "";
		    	for (int i = 0; i < s.length(); ) {
		    		t = s.substring(i, i + n) + t;
		    		i += n;
		    	}
		    	
		    	if (s.equals(t)) {
		    		System.out.println(text + "|" + 1);
		    	} else {
		    		System.out.println(text + "|" + 0);
		    	}
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
