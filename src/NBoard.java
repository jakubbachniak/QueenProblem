import java.util.Scanner;

/**
 * Obtain input from the user, set the N x N board by calling the main
 * object's method for finding the solution to the problem
 * @author Jakub Bachniak
 *
 */
public class NBoard {
	// constructor for the object of the NBoard type class
	// create instance of the class
	public NBoard() {
		
	}
	//display information about input to the program
	public void info() {
		System.out.println("***************************************************");
		System.out.println("For n = 2 and n = 3 the number of queens that can be");
		System.out.println("placed on the n x n board is n - 1");
		System.out.println("Thus, for n = 2 the solution is 1");
		System.out.println("      for n = 3 the solution is 2");
		System.out.println("	  for n >=4 the solution is n");
		System.out.println("Provide integer value greater than 3");
		System.out.println("to calculate one example of placing n queens on n x n board");
	}
	
	public void setBoard() {
		
		// crete an instance newQueen of the NQueenSolutioinFinder object
		// in which computes the solution
		NQueenSolutionFinder newQueen = new NQueenSolutionFinder();
	    int n = getInput();
	    SingleQueenPlacement[] positions = newQueen.solutionFinder(n);
	    System.out.println("******************************************");
	    System.out.println("For the boad size " + n + " x " + n);
	    System.out.println("total number of queens palced on the board is: " + positions.length);
	    System.out.println("******************************************");
	    System.out.println("The positions of the queens on the board are: ");
    	System.out.println();
	    // traverse the array positions and display the contents
	    // that is the positions of the N queens on the N x N chessboard
	    for (int i = 0; i < positions.length; i++ ) {
	    	// display the number of the queen
	    	// and convert from zero-based number to one-based number
	    	System.out.println("Position of the queen no. " + (i+1) + ":");
	    	// because the board inside the program is zero-based
	    	// increment row and column by 1 to display the true location of queens
	    	// on a physical 1 based board
	    	// for example:
	    	// for n = 8:
	    	// inside the program we have 	row 0 - 7 which corresponds to physical row 1 - 8
	    	//								col 0 - 7 which corresponds to physical col 1 - 8	
	    	System.out.println("Row no: " + ((positions[i].getRow())+1) + " column no: " + ((positions[i].getCol())+1));
	    }
	}
	
	// obrain and verify input from the user
	public int getInput() {
		
		// instance of the Scanner class in order to obtain input from user
		Scanner scanUserInput = new Scanner(System.in);
		System.out.println("******************************************");
		System.out.println("Please, Enter the \"n\":");
		System.out.println("Please note, for n > 20, finding solution may take");
		System.out.println("considerably long time...");
		System.out.print("> ");
		// if the value entered is not an integer value, inform
		// and prompt for input of the correct type  int
		while(!scanUserInput.hasNextInt()) {
			System.out.println("Invalid input, please provide integer value number \"n\":");
			System.out.println("Please note, for n > 20, finding solution may take");
			System.out.println("considerably long time...");
			System.out.print("> ");
			scanUserInput.next();
		}
		// assign value from the scanned input to the int value variable
		// which will be retured by the method
		int value = scanUserInput.nextInt();
		// prevent leakeges
		scanUserInput.close();
		
		return value;
	} // end of getUserInput method

}
