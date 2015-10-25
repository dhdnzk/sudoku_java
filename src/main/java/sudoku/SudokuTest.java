package sudoku;

public class SudokuTest {
    public static void main ( String[] args ) {
        Problem p1 = new Problem( MakingQuestion.makeQuiz( 1 ) );
        p1.showState();
        while ( 0 < p1.numOfZero ) {
            JuniorExplanation.juniorExplanation( p1 );
//          seniorExplanation( p1 );
            p1.showState();
        }
        p1.showState();
    }
}
