public class ExpressionEvaluator {
  public static void main(String[] args){
    System.out.println(
       new ExpressionEvaluator().convertToPostfix("a+r^2-5"));
    System.out.println(
      new ExpressionEvaluator().evaluatePostfix("abcd^*+"));
  }

  private Integer evaluatePostfix(String postfix){
    StackInterface<Integer> operandStack =
      new LinkedStack<>();

    for(int i=0; i<postfix.length(); i++){
      System.out.println(operandStack);
      Character nextChar = postfix.charAt(i);
      switch(nextChar){
        case 'a': case 'b': case 'c': case 'd':
          operandStack.push(valueOf(nextChar));
          break;
        case '+': case '-': case '*': case '/': case '^':
          Integer firstOperand = operandStack.pop();
          Integer secondOperand = operandStack.pop();
          Integer result = compute(nextChar, firstOperand,
                                    secondOperand);
          operandStack.push(result);
          break;
      }
    }
    return operandStack.pop();
  }

  private String convertToPostfix(String infix) {
    StringBuilder postfix = new StringBuilder();
    StackInterface<Character> operatorStack =
      new LinkedStack<>();

    for(int i=0; i<infix.length(); i++){
      Character nextChar = infix.charAt(i);

      switch(nextChar){
        case 'a': case 'b': case 'c': case 'd': case 'r': case '2': case '5':
            postfix.append(nextChar);
            break;
        case '^':
          operatorStack.push(nextChar);
          break;
        case '+': case '-': case '*': case '/':
          while(!operatorStack.isEmpty()){
            Character top = operatorStack.peek();
            if(getPrecedence(nextChar) >= getPrecedence(top)){
              operatorStack.pop();
              postfix.append(top);
            } else {
              break;
            }
          }
          operatorStack.push(nextChar);
          break;
        case '(':
          operatorStack.push(nextChar);
          break;
        case ')':
          Character top = operatorStack.pop();
          while(top != '('){
            postfix.append(top);
            top = operatorStack.pop();
          }
          break;
      }
    }
    while(!operatorStack.isEmpty()){
      postfix.append(operatorStack.pop());
    }
    return postfix.toString();

  }

  private int getPrecedence(char operator) {
    int result = -1;
    switch(operator){
      case '(': case ')':
        result = 0;
        break;
      case '^':
        result = 1;
        break;
      case '*': case '/':
        result = 2;
        break;
      case '+': case '-':
        result = 3;
        break;
    }
    return result;
  }

  private Integer valueOf(Character operand){
    int result = -1;
    switch(operand){
      case 'a':
        result = 3;
        break;
      case 'b':
        result = 5;
        break;
      case 'c':
        result = 6;
        break;
      case 'd':
        result = 2;
    }
    return result;
  }

  private Integer compute(Character operator, Integer firstOperand,
                          Integer secondOperand){
      Integer result = -1;
      switch(operator){
        case '+':
          result = firstOperand + secondOperand;
          break;
        case '*':
          result = firstOperand * secondOperand;
          break;
        case '-':
          result = secondOperand - firstOperand;
          break;
        case '/':
          result = secondOperand / firstOperand;
          break;
        case '^':
          result = 1;
          for(int i=0; i<firstOperand; i++){
            result = result * secondOperand;
          }
          break;
      }

      return result;

  }
}
