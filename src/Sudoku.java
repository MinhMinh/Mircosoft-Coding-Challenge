import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Sudoku {
	
	private static String inputFile = "ScoringInputs/Sudoku/ActualInput.txt";
//	private static String inputFile = "SampleInputs/Sudoku/SampleInput.txt";
	
	private static int[][] board;
	private static boolean found;
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
		    
		    board = new int[9][9];
		    int row = 0;
		    
		    while ((text = reader.readLine()) != null) {
		    	if (text.isEmpty()) { //new board
		    		board = new int[9][9];
		    		row = 0;
		    		System.out.println();
		    		continue;
		    	}
		    	
		    	String[] sp = text.split(" ");
		    	for (int i = 0; i < 9; i++)
		    		if (sp[i].equals("x")) {
		    			board[row][i] = 0;
		    		}
		    		else {
		    			board[row][i] = Integer.parseInt(sp[i]);
		    		}
		    	row++;
		    	
		    	if (row == 9) {
		    		found = false;
		    		solve(0, 0);
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

	private static boolean canPlaceInRow(int row, int value)
	{
		int r = 0;
		for (int i = 0; i < 9; i++)
			if (board[row][i] == value) r++;
		return (r == 0);
	}
	
	//check if a value @value can place in col @col
	private static boolean canPlaceInColumn(int col, int value)
	{
		int r = 0;
		for (int i = 0; i < 9; i++)
			if (board[i][col] == value) r++;
		return (r == 0);
	}
	
	//check if a value @value can place in box has (left, top) corner is (@dx, @dy)
	private static boolean canPlaceInBox(int dx, int dy, int value)
	{
		int r = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[dx + i][dy + j] == value) r++;
		return r == 0;		
	}
		
	/*
	 *  Recursive function to solve sudoku
	 *  Try all possible for cell (x, y)
	 */
	private static void solve(int x, int y)
	{
		if (found) return;
		if (y == 9)
		{
			x++;
			y = 0;
		}
		if (x == 9)
		{
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) 
					System.out.print(board[i][j] + " ");
				System.out.println();
			}
			found = true;	
			return ;
		}
		if (board[x][y] != 0)
			solve(x, y + 1);
		else
			for (int i = 1; i <= 9; i++)
				if (canPlaceInRow(x, i) && canPlaceInColumn(y, i) && canPlaceInBox(x / 3 * 3, y / 3 * 3, i))
				{
					board[x][y] = i;
					solve(x, y + 1);
					if (found) return;
					board[x][y] = 0;
					
				}
	}
}
