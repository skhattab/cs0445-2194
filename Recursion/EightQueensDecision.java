public  class EightQueensDecision implements DecisionInterface{
  private int currentDecision;
  private int currentOption;
  public EightQueensDecision() {
    currentDecision = 0;
    currentOption = -1;
  }
  public EightQueensDecision(int decision) {
    currentDecision = decision;
    currentOption = -1;
  }
  public  boolean isTerminalDecision() {
    return currentDecision > 7;
  }
  public  boolean hasNextOption() {
    return currentOption < 7;
  }

  //return a new Decision object without changing the current decision
  public  DecisionInterface getNextDecision() {
    return new EightQueensDecision(currentDecision+1);
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
