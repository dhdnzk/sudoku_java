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
            for (int col = 0; col < 9; col ++ ) {
                 
            }




        }

        return 2;
    }


//    public static int colSearchHiddenSingleCandidate( Problem problem, int row ) {
//
//    }
//
//    public static int sectionSearchHiddenSingleCandidate( Problem problem, int row ) {
//
//    }
}
