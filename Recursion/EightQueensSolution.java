public class EightQueensSolution implements SolutionInterface {
	//data structure(s) to represent a solution
	private  boolean[][] board;

	public EightQueensSolution() {
		//initialize the solution
		board = new boolean[8][8];
		init();
	}

	private  void init() {
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++)
				board[i][j] = false;
	}

	//apply an option
	public void applyOption(DecisionInterface decision) {
		board[decision.getCurrentOption()][decision.getCurrentDecision()] = true;
	}

	//undo an option
	public void undoOption(DecisionInterface decision) {
		board[decision.getCurrentOption()][decision.getCurrentDecision()] = false;
	}

	//check if an option is feasible
	public boolean isFeasible(DecisionInterface decision)
	{
		int col = decision.getCurrentDecision();
		int row = decision.getCurrentOption();
		//check the row
		for(int i=0; i<col; i++){
			if(board[row][i])
				return false;
		}

		//check the left diagonal
		int i = row-1;
		int j = col-1;
		while((i >= 0)&& (j >= 0)){
			if(board[i][j])
				return false;
			i--;
			j--;
		}

		//check the right diagonal
		i = row+1;
		j = col-1;
		while((i < 8)&& (j >= 0)){
			if(board[i][j])
				return false;
			i++;
			j--;
		}
		return true;
	}

	//return a printable representation of the solution
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------------\n");
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(board[i][j])
					sb.append("Q ");
				else
					sb.append("_ ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
