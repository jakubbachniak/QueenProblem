/**
 * Class containing the main method
 * as set by Java standard
 * @author Jakub Bachniak
 *
 */
public class NQueenMain {

	public static void main(String[] args) {
		
		// create instance of NBoard class
		NBoard board = new NBoard();
		// call the info method of the board object
		// and display instruction to the user
		board.info();
		// call to the method of the instance of the NBoard class
		// which in turn invodes the main solution finding object NQueenSolutionFinder
		board.setBoard();
		
	}

}
