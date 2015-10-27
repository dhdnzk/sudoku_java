package sudoku;

import junit.framework.TestCase;
import org.junit.Test;

public class SolveHiddenSingleCandidateTest {

    @Test
    public void transformThisCandidateToConfirmedElement() {
        Element testElement = new Element();

        SolveHiddenSingleCandidate.transformThisCandidateToConfirmedElement ( testElement, 1 );
        TestCase.assertEquals( null, testElement.getCandidates() );

    }

    @Test
    public void rowSearchHiddenSingleCandidate() {
        int[][] testArr = new int[1][9];
        Problem testProblem = new Problem ( testArr );
        for (int i = 0; i < 8; i ++ ) {
            for (int candidate = 2; candidate <= 9; candidate ++ ) {
                testProblem.getCandidateBoard()[0][i].removeACandidate( candidate );
            }
        }
        for ( int candidate = 3; candidate <= 9; candidate ++ ) {
            testProblem.getCandidateBoard()[0][8].removeACandidate(candidate);
        }

        TestCase.assertEquals( 2, SolveHiddenSingleCandidate.rowSearchHiddenSingleCandidate( testProblem, 1));

    }

    @Test
    public void rowSolveHiddenSingleCandidate() {
        int[][] testArr = {
                {5, 3, 4,  6, 7, 8,  9, 1, 0},
                {6, 7, 2,  1, 9, 5,  3, 0, 8},
                {1, 9, 8,  3, 4, 2,  0, 6, 7},

                {8, 0, 0,  0, 6, 0,  0, 0, 3},
                {4, 0, 0,  8, 0, 3,  0, 0, 1},
                {7, 0, 0,  0, 2, 0,  0, 0, 6},

                {0, 6, 0,  0, 0, 0,  2, 8, 0},
                {0, 0, 0,  4, 1, 9,  0, 0, 5},
                {0, 0, 0,  0, 8, 0,  0, 7, 9}
        };
        Problem testProblem = new Problem(testArr);
        SolveHiddenSingleCandidate.rowSolveHiddenSingleCandidate(testProblem);
    }


    @Test
    public void colSearchHiddenSingleCandidate() {










    }



    // TODO 미구현
    @Test
    public void colSolveHiddenSingleCandidate() {
        int[][] testArr = {
                {5, 3, 0,  0, 7, 0,  0, 0, 0},
                {6, 0, 0,  1, 9, 5,  0, 0, 0},
                {0, 9, 8,  0, 0, 0,  0, 6, 0},

                {8, 0, 0,  0, 6, 0,  0, 0, 3},
                {4, 0, 0,  8, 0, 3,  0, 0, 1},
                {7, 0, 0,  0, 2, 0,  0, 0, 6},

                {0, 6, 0,  0, 0, 0,  2, 8, 0},
                {0, 0, 0,  4, 1, 9,  0, 0, 5},
                {0, 0, 0,  0, 8, 0,  0, 7, 9}
        };
        Problem testProblem = new Problem(testArr);

    }


    // TODO 미구현
    @Test
    public void sectionSolveHiddenSingleCandidate() {
        int[][] testArr = {
                {5, 3, 0,  0, 7, 0,  0, 0, 0},
                {6, 0, 0,  1, 9, 5,  0, 0, 0},
                {0, 9, 8,  0, 0, 0,  0, 6, 0},

                {8, 0, 0,  0, 6, 0,  0, 0, 3},
                {4, 0, 0,  8, 0, 3,  0, 0, 1},
                {7, 0, 0,  0, 2, 0,  0, 0, 6},

                {0, 6, 0,  0, 0, 0,  2, 8, 0},
                {0, 0, 0,  4, 1, 9,  0, 0, 5},
                {0, 0, 0,  0, 8, 0,  0, 7, 9}
        };
        Problem testProblem = new Problem(testArr);

    }


    // TODO 미구현
    @Test
    public void solveHiddenSingleCandidate() {
        int[][] testArr = {
                {5, 3, 0,  0, 7, 0,  0, 0, 0},
                {6, 0, 0,  1, 9, 5,  0, 0, 0},
                {0, 9, 8,  0, 0, 0,  0, 6, 0},

                {8, 0, 0,  0, 6, 0,  0, 0, 3},
                {4, 0, 0,  8, 0, 3,  0, 0, 1},
                {7, 0, 0,  0, 2, 0,  0, 0, 6},

                {0, 6, 0,  0, 0, 0,  2, 8, 0},
                {0, 0, 0,  4, 1, 9,  0, 0, 5},
                {0, 0, 0,  0, 8, 0,  0, 7, 9}
        };
        Problem testProblem = new Problem(testArr);


    }

}
