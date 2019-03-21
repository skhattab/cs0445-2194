class Main {
	public static void main(String[] args){
		BackTrackingSolver bts = new BackTrackingSolver(
    new EightQueensSolution(),
		new EightQueensDecision());
		bts.solve();
    System.out.println(bts.getNSolutions())

    // BackTrackingSolver bts1 = new BackTrackingSolver(
    // new SudokuSolution(),
		// new SudokuDecision());
		// System.out.println(bts1.solve());
    //
		// BackTrackingSolver bts = new BackTrackingSolver(
    //   new CryptArithmeticSolution(),
		// 	new CryptArithmeticDecision());
		// System.out.println(bts3.solve());
	}
}
