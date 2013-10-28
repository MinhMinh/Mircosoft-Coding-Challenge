import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReplacementGrammar {

	private static String inputFile = "ScoringInputs/ReplacementGrammar/ActualInput.txt";
//	private static String inputFile = "SampleInputs/ReplacementGrammar/SampleInput.txt";
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
		    
		    ArrayList<String> rules = new ArrayList<String>();
		    while ((text = reader.readLine()) != null) {
		    	if (text.isEmpty()) continue;
		    	
		    	rules.add(text);
		    }
		    
		    int n = rules.size();
		    String msg = rules.get(n - 1);
		    
		    n--;
		    String[] a = new String[n];
		    String[] b = new String[n];
		    for (int i = 0; i < n; i++) {
		    	int idx = rules.get(i).indexOf("|"); 
		    	a[i] = rules.get(i).substring(0, idx);
		    	b[i] = rules.get(i).substring(idx + 1);
		    }
		    
		    boolean[] c = new boolean[n];
		    boolean stop = false;
		    while (!stop) {
		    	stop = true;
		    	for (int i = 0; i < n; i++)
		    		if (!c[i] && msg.contains(a[i])) {
		    			msg = msg.replace(a[i], b[i]);
		    			stop = false;
		    			c[i] = true;
		    			break;
		    		}
		    }
		    
		    System.out.println(msg);
		    
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
