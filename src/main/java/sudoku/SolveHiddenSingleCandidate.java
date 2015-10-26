package sudoku;

public class SolveHiddenSingleCandidate extends JuniorExplanation {

    public static boolean transformThisCandidateToConfirmedElement ( Element element, int candidate ) {
        if ( element.getConfirmedElement() != 0 ) return false;
        if ( element.getCandidates()[candidate - 1] != 0 ) {
            element.setConfirmedElement( candidate );
            return true;
        }
        return false;
    }

    public static int rowSearchHiddenSingleCandidate( Problem problem, int row ) {
        for ( int number = 1; number <= 9; number ++ ) {
            int candidateCount = 0;
            for (int col = 0; col < 9; col ++ ) {
                if ( problem.getCandidateBoard()[ row - 1][ col ].getConfirmedElement() ==0 && problem.getCandidateBoard()[ row - 1][ col ].getCandidates()[number - 1] != 0 )
                   candidateCount ++;
                if ( candidateCount > 1 )
                    break;
            }
            if ( candidateCount == 1 )
                return number;
        }
        return 0;
    }

    public static void rowSolveHiddenSingleCandidate( Problem problem ) {
        for ( int row = 1; row <= problem.getCandidateBoard().length; row ++ ) {
            int hiddenSingleCandidate = rowSearchHiddenSingleCandidate( problem, row );
            if ( hiddenSingleCandidate != 0 ) {
                for ( int col = 1; col < problem.getCandidateBoard()[row -1].length; col ++ ) {
                    if ( transformThisCandidateToConfirmedElement( problem.getCandidateBoard()[row - 1][col - 1], hiddenSingleCandidate ) ) {
                        problem.numOfZero --;
                        problem.showState();
                        return;
                    }

                }
            }

        }

    }




//    public static int colSearchHiddenSingleCandidate( Problem problem, int row ) {
//
//    }
//
//    public static int sectionSearchHiddenSingleCandidate( Problem problem, int row ) {
//
//    }

    public static void solveHiddenSingleCandidate ( Problem problem ) {
        rowSolveHiddenSingleCandidate( problem );
    }
}
