package sudoku;

import junit.framework.TestCase;
import org.junit.Test;

public class ProblemTest {

    @Test
    public void matchQuizToCandidateBoard() {
        int[][] testArr = {
                { 5, 3, 0,  0, 7, 0,  0, 0, 0 },
                { 6, 0, 0,  1, 9, 5,  0, 0, 0 },
                { 0, 9, 8,  0, 0, 0,  0, 6, 0 },

                { 8, 0, 0,  0, 6, 0,  0, 0, 3 },
                { 4, 0, 0,  8, 0, 3,  0, 0, 1 },
                { 7, 0, 0,  0, 2, 0,  0, 0, 6 },

                { 0, 6, 0,  0, 0, 0,  2, 8, 0 },
                { 0, 0, 0,  4, 1, 9,  0, 0, 5 },
                { 0, 0, 0,  0, 8, 0,  0, 7, 9 }
        };

        Problem testProblem = new Problem ( testArr );
        TestCase.assertEquals( 51, testProblem.getNumOfZero() );
        TestCase.assertEquals( 8, testProblem.getCandidateBoard()[2][2].getConfirmedElement() );
        TestCase.assertEquals( 0, testProblem.getCandidateBoard()[1][1].getConfirmedElement() );
        TestCase.assertEquals( null, testProblem.getCandidateBoard()[2][2].getCandidates() );
    }


}
