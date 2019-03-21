public  class CryptArithmeticDecision implements DecisionInterface {
	private int currentDecision;
	private int currentOption;
	public CryptArithmeticDecision() {
		currentDecision = 0;
		currentOption = -1;
	}
	public CryptArithmeticDecision(int decision) {
		currentDecision = decision;
		currentOption = -1;
	}
	public  boolean isTerminalDecision() {
		return currentDecision > 7;
	}
	public  boolean hasNextOption() {
		return currentOption < 9;
	}

	//return a new Decision object without changing the current decision
	public  DecisionInterface getNextDecision() {
		return new CryptArithmeticDecision(currentDecision+1);
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
