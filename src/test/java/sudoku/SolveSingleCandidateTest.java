package sudoku;

import junit.framework.TestCase;
import org.junit.Test;

public class SolveSingleCandidateTest {

    @Test
    public void rowSolveSingleCandidate() {
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
        SolveSingleCandidate.rowSolveSingleCandidate(testProblem);
    }

    @Test
    public void colSolveSingleCandidate() {
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
        SolveSingleCandidate.colSolveSingleCandidate(testProblem);
    }

    @Test
    public void sectionSolveSingleCandidate() {
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
        SolveSingleCandidate.sectionSolveSingleCandidate(testProblem);
    }

    @Test
    public void solve() {
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
        SolveSingleCandidate.solve(testProblem);
    }

}
