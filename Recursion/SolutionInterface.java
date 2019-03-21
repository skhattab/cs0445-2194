//An interface to represent a solution
public interface SolutionInterface {
	//apply an option
	public void applyOption(DecisionInterface decision);
	//undo an option
	public void undoOption(DecisionInterface decision);
	//check if an option is feasible
	public boolean isFeasible(DecisionInterface decision);
}
