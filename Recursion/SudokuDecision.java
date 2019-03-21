public  class SudokuDecision implements DecisionInterface {
	private int currentDecision;
	private int currentOption;
	public SudokuDecision() {
		currentDecision = 0;
		currentOption = 0;
	}
	public SudokuDecision(int decision) {
		currentDecision = decision;
		currentOption = 0;
	}
	public  boolean isTerminalDecision() {
		return currentDecision > 80;
	}
	public  boolean hasNextOption() {
		return currentOption < 9;
	}

	//return a new Decision object without changing the current decision
	public  DecisionInterface getNextDecision() {
		return new SudokuDecision(currentDecision+1);
	}

	//advance to next option
	public  void nextOption() {
		currentOption++;
	}
	@Override
	public int getCurrentDecision() {
		return currentDecision;
	}
	@Override
	public int getCurrentOption() {
		return currentOption;
	}
}
