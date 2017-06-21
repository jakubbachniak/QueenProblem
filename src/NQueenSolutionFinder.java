/**
 * The main class of the project
 * responsible for finding the solution
 */
public class NQueenSolutionFinder {
	
	/**
	 * Constructor - create an instance of the class
	 */
	public NQueenSolutionFinder(){

	}
	/**
	 * 
	 * @param 	n value obtained from the user
	 * 			n queens; n x n chessbard
	 * @return	return type is an array of SinglePlacement type
	 * 			an array of objects containing positions of queens
	 * 			on the n x n board
	 */
    public SingleQueenPlacement[] solutionFinder(int n) {
    	SingleQueenPlacement[] positions = new SingleQueenPlacement[n];
        backtracker(n, 0, positions);

        return positions;
    }
	/**
	 * 			backtracker method is an implementation of the backtracking
	 * 			algorithm which servees as a way of finding the 'safe' squares
	 * 			on the n x n board 			
	 * 
	 * @param 	parameter n passed from the invoking function solutionFinder
	 * @param 	row - row on which we start placing queens on the board
	 * 			since the array is zero based (which corresponds to the first row
	 * 			on physical board) we initialise our serch variable row to 0
	 * @param 	positions - container for the n x n board - this will hold current
	 * 			and final positions of n queens on the n x n board
	 * @return	boolean
	 * 			in order to traverse entire N x N board the method calls itself
	 * 			recursively. Test for true at the end of each recursive call:
	 * 			if true - continue with recursion
	 * 			if false - stop
	 */
    private boolean backtracker(int n, int row, SingleQueenPlacement[] positions) {
    	// test and continue with recursively calling itself
    	// as long as not on the last row of the board
    	while (row < n){
    		// on each row traverse accorss and check each column
	    	for (int col = 0; col < n; col++) {
	    		// boolean varaible to hold the state of the current square
	            boolean safeSquareFound = true;
	
	            // inspect each square if it is 'under attack' from
	            // the above queen
	            for (int square = 0; square < row; square++) {
	            		// test if on the same column...
	                if (positions[square].getCol() == col ||
	                		// ... or on the 'top-right to bottom-left' diagonal...
	                		positions[square].getRow() - positions[square].getCol() == row - col ||
	                		// ... or on the 'top-left to borrom right' diagonal
	                        positions[square].getRow() + positions[square].getCol() == row + col) {
	                	// if any of the three tests fails set the safeSquareFound to false
	                	// terminate iteration
	                    safeSquareFound = false;
	                    break;
	                }
	            }
	            // if, however, a safe square found at the current positioin
	            // create new instance of the SingleQueenPlacement which represents
	            // a new queen on the board and by use of the mutatuor methods
	            // set the new queen positioin to the curren row and column
	            if (safeSquareFound) {
	                positions[row] = new SingleQueenPlacement();
	                positions[row].setRow(row);
	                positions[row].setCol(col);
	                // as long as as still on the board, that is row < n
	                // backtracker method yields a true value and the method
	                // is called recursively by itself
	                if (backtracker(n, row + 1, positions)) {
	                    return true;
	                }
	            }
	        } // end of the outher for loop
	    	return false;
    	} // end of the while loop
    	return true;
    } // end of the backtrtacker method
}
