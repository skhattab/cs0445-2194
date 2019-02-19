public class BalanceChecker {

  public static void main(String[] args) {

    System.out.println(new BalanceChecker().checkBalance("{([])}}"));

  }

  private boolean checkBalance(String expression) {

    StackInterface<Character> parenStack =
      new ArrayStack<>(10);

    boolean isBalanced = true;
    for(int i=0; i<expression.length() && isBalanced; i++){
      Character nextChar = expression.charAt(i);

      switch(nextChar) {
        case '{': case '[': case '(':
          parenStack.push(nextChar);
          break;
        case '}': case ']': case ')':
          if(!parenStack.isEmpty()){
            Character poppedChar = parenStack.pop();
            if(!isPair(poppedChar, nextChar)){
              isBalanced = false;
            }
          } else {
            isBalanced = false;
          }
      }
    }
    if(!parenStack.isEmpty()){
      isBalanced = false;
    }

    return isBalanced;
  }

  private boolean isPair(Character open, Character close){
    return (open.equals('{') && close.equals('}')) ||
           (open.equals('[') && close.equals(']')) ||
           (open.equals('(') && close.equals(')'));
  }

}
