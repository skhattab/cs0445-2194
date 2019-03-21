public class BackTrackingSolver {

	private SolutionInterface solution;
	private DecisionInterface decision;
<<<<<<< HEAD
	int nSolutions;
=======
>>>>>>> de49df507edea03078f0a41da322d11390057171

	public BackTrackingSolver(SolutionInterface solution, DecisionInterface decision) {
		this.solution = solution;
		this.decision = decision;
<<<<<<< HEAD
		nSolutions = 0;
=======
>>>>>>> de49df507edea03078f0a41da322d11390057171
	}
	public SolutionInterface solve() {
		return solve(decision, solution);
	}

<<<<<<< HEAD
	public int getNSolutions() {
		return nSolutions;
	}

	private  SolutionInterface solve(DecisionInterface currentDecision,
																	SolutionInterface partial) {
		SolutionInterface result = null;
		//no more decisions?
		if(currentDecision.isTerminalDecision()) {
			System.out.println(partial);
=======
	private  SolutionInterface solve(DecisionInterface currentDecision, SolutionInterface partial) {
		SolutionInterface result = null;			
		//no more decisions?
		if(currentDecision.isTerminalDecision()) {
			//System.out.println(partial);
>>>>>>> de49df507edea03078f0a41da322d11390057171
			return partial;
		}

		//iterate over all options for currentDecision
<<<<<<< HEAD

=======
		
>>>>>>> de49df507edea03078f0a41da322d11390057171
		while(currentDecision.hasNextOption()) {
			//advance to next option
			currentDecision.nextOption();
			//is next option feasible?
<<<<<<< HEAD
			if(partial.isFeasible(currentDecision)) {
=======
			if(partial.isFeasible(currentDecision)) { 
>>>>>>> de49df507edea03078f0a41da322d11390057171
				//apply the option to the partial solution
				partial.applyOption(currentDecision);
				//dispatch a worker to examine the option
				result  = solve(currentDecision.getNextDecision(), partial);
				//check the worker's output
				if(result != null) //found a solution?
<<<<<<< HEAD
					nSolutions++;
				//	return result;
				//undo the option from the partial solution
				partial.undoOption(currentDecision);
			}
		}
		//all options have been exhausted without finding a solution
		//return null
		assert result == null;
		return null;
=======
					return result;
				//undo the option from the partial solution
				partial.undoOption(currentDecision);				
			}
		} 
		//all options have been exhausted without finding a solution
		//return null
		assert result == null;
		return null;		
>>>>>>> de49df507edea03078f0a41da322d11390057171
	}
}
