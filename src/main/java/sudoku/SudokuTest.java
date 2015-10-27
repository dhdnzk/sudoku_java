package sudoku;

public class SudokuTest {
    public static void main ( String[] args ) {
        Problem p1 = new Problem( MakingQuestion.makeQuiz() );
        p1.showState();
        while ( 0 < p1.numOfZero ) {
            int before = p1.getNumOfZero();
            SolveSingleCandidate.solve( p1 );
            SolveHiddenSingleCandidate.solve( p1 );
            int cur = p1.getNumOfZero();
            if ( before == cur ) {
                System.out.println("현재 구현된 풀이법으로는 더이상 풀 수 없습니다");
                return;
            }
        }
        p1.showState();
    }
}
