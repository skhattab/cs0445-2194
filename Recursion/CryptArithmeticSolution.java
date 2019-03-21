import java.util.ArrayList;
import java.util.TreeSet;

public class CryptArithmeticSolution implements SolutionInterface {
	//data structure(s) to represent a solution
	private  int[] code;

	public CryptArithmeticSolution() {
		//initialize the solution
		//SEDMORNY
		code = new int[8];
		init();
	}

	private  void init() {
		for(int j=0; j<8; j++)
			code[j] = -1;
	}

	//apply an option
	public void applyOption(DecisionInterface decision) {
		//decode the decision first
		int index = decision.getCurrentDecision();
		code[index] = decision.getCurrentOption();
	}

	//undo an option
	public void undoOption(DecisionInterface decision) {
		//decode the decision first
		int index = decision.getCurrentDecision();
		code[index] = -1;
	}

	//check if an option is feasible
	public boolean isFeasible(DecisionInterface decision)
	{
		//Apply the option into a temprary array
		int [] temp = new int[8];
		for(int i=0; i<8; i++) {
			temp[i] = code[i];
		}
		temp[decision.getCurrentDecision()] = decision.getCurrentOption();

		//make sure the assignment is unique
		ArrayList<Integer> assignedValues = new ArrayList<>();
		for(int i=0; i<8; i++) {
			if(temp[i] != -1) {
				if(assignedValues.contains(temp[i]))
					return false;
				assignedValues.add(temp[i]);
			}
		}
		//add(SEND + MORE) ?= MONEY
		//D + E = Y?
		if((temp[2] != -1)&&(temp[7] != -1)&&(temp[1]!=-1)) {
			if((temp[2] + temp[1])%10 != temp[7])
				return false;
		}

		//N+R=E?
		int carry = (temp[2] + temp[1])/10;
		if((temp[6] != -1)&&(temp[5] != -1)&&(temp[1]!=-1)) {
			if((carry + temp[6] + temp[5])%10 != temp[1])
				return false;
		}

		//E+O=N?
		carry = (carry + temp[6] + temp[5])/10;
		if((temp[1] != -1)&&(temp[4] != -1)&&(temp[6]!=-1)) {
			if((carry + temp[1] + temp[4])%10 != temp[6])
				return false;
		}

		//S+M=O?
		carry = (carry + temp[1] + temp[4])/10;
		if((temp[0] != -1)&&(temp[3] != -1)&&(temp[4]!=-1)) {
			if((carry + temp[0] + temp[3])%10 != temp[4])
				return false;
			carry = (carry + temp[0] + temp[3])/10;
			if(carry != temp[3])
				return false;
			//M>0?
			if(carry != 1)
				return false;
		}

		return true;
	}

	//return a printable representation of the solution
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String letters = "SEDMORNY";
		for(int i=0; i<8; i++) {
			sb.append(letters.charAt(i) + "=" + code[i] + " ");
		}
		sb.append("\n");
		return sb.toString();
	}

}
