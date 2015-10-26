package sudoku;

public class SudokuTest {
    public static void main ( String[] args ) {
        Problem p1 = new Problem( MakingQuestion.makeQuiz() );
        p1.showState();
        while ( 0 < p1.numOfZero ) {
//            SolveSingleCandidate.solveSingleCandidate(p1);
            SolveHiddenSingleCandidate.solveHiddenSingleCandidate( p1 );
        }
        p1.showState();
    }
}
