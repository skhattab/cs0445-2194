public class SudokuSolution implements SolutionInterface {
	//data structure(s) to represent a solution
	private  int[][] board;

	public SudokuSolution() {
		//initialize the solution
		board = new int[9][9];
		init();
	}

	private  void init() {
		for(int i=0; i<9; i++)
			for(int j=0; j<9; j++)
				board[i][j] = 0;
	}

	//apply an option
	public void applyOption(DecisionInterface decision) {
		//decode the decision first
		int row = decision.getCurrentDecision() / 9;
		int col = decision.getCurrentDecision() % 9;
		board[row][col] = decision.getCurrentOption();
	}

	//undo an option
	public void undoOption(DecisionInterface decision) {
		//decode the decision first
		int row = decision.getCurrentDecision() / 9;
		int col = decision.getCurrentDecision() % 9;
		board[row][col] = 0;
	}

	//check if an option is feasible
	public boolean isFeasible(DecisionInterface decision)
	{
		//decode the decision first
		int row = decision.getCurrentDecision() / 9;
		int col = decision.getCurrentDecision() % 9;
		//check the row
		for(int i=0; i<col; i++){
			if(board[row][i] == decision.getCurrentOption())
				return false;
		}

		//check the column
		for(int i=0; i<row; i++){
			if(board[i][col] == decision.getCurrentOption())
				return false;
		}

		//check the box
		int boxStartRow = 3*(row / 3);
		int boxStartCol = 3*(col / 3);
		for(int i=boxStartRow; i<boxStartRow+3; i++) {
			for(int j=boxStartCol; j<boxStartCol+3; j++) {
				if(board[i][j] == decision.getCurrentOption())
					return false;
			}
		}

		return true;
	}

	//return a printable representation of the solution
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			if(i%3 == 0)
				sb.append("+-----+-----+-----+\n");
			for(int j=0; j<9; j++) {
				if(j%3==0)
					sb.append("|" + board[i][j] + " ");
				else if(j%3==2)
					sb.append(board[i][j]);
				else
					sb.append(board[i][j] +  " ");
			}
			sb.append("|\n");
		}
		sb.append("+-----+-----+-----+\n");

		return sb.toString();
	}
}
