package sudoku;

import junit.framework.TestCase;
import org.junit.Test;

public class JuniorExplanationTest {

    @Test
    public void howManyThisNumberInThisRow() {
        int[][] testArr1 = {
                { 1, 2, 3, 4, 5, 6, 7, 8, 0}
        };
        int[][] testArr2 = {
                { 1, 0, 3, 4, 5, 6, 7, 8, 0},
                { 1, 2, 0, 0, 5, 6, 7, 8, 0}
        };
        int[][] testArr3 = {
                { 1, 7, 0, 0, 5, 0, 2, 0, 0 },
                { 1, 2, 3, 4, 5, 6, 7, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        Problem testProblem1 = new Problem( testArr1 );
        Problem testProblem2 = new Problem( testArr2 );
        Problem testProblem3 = new Problem( testArr3 );
        TestCase.assertEquals(1, JuniorExplanation.howManyThisNumberInThisRow(testProblem1.getCandidateBoard(), 1, 0));
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisRow(testProblem2.getCandidateBoard(), 1, 0) );
        TestCase.assertEquals( 3, JuniorExplanation.howManyThisNumberInThisRow(testProblem2.getCandidateBoard(), 2, 0) );
        TestCase.assertEquals( 5, JuniorExplanation.howManyThisNumberInThisRow(testProblem3.getCandidateBoard(), 1, 0) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisRow(testProblem3.getCandidateBoard(), 2, 0) );
        TestCase.assertEquals( 9, JuniorExplanation.howManyThisNumberInThisRow(testProblem3.getCandidateBoard(), 3, 0) );
    }

    @Test
    public void howManyThisNumberInThisCol() {
        int[][] testArr = {
                { 1, 2, 3, 4, 0, 6, 0, 8, 9 },
                { 2, 3, 4, 5, 6, 0, 8, 9, 0 },
                { 3, 4, 5, 6, 7, 0, 9, 1, 2 },
                { 4, 5, 6, 7, 8, 0, 1, 0, 3 },
                { 5, 6, 0, 0, 9, 0, 2, 0, 4 },
                { 6, 7, 0, 0, 1, 2, 3, 4, 5 },
                { 7, 0, 0, 1, 2, 3, 4, 5, 0 },
                { 8, 0, 0, 2, 3, 4, 5, 6, 7 },
                { 0, 0, 0, 3, 4, 5, 0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );
        TestCase.assertEquals ( 1, JuniorExplanation.howManyThisNumberInThisCol(testProblem.getCandidateBoard(), 1, 0) );
        TestCase.assertEquals ( 3, JuniorExplanation.howManyThisNumberInThisCol(testProblem.getCandidateBoard(), 2, 0) );
        TestCase.assertEquals ( 5, JuniorExplanation.howManyThisNumberInThisCol(testProblem.getCandidateBoard(), 3, 0) );
        TestCase.assertEquals ( 2, JuniorExplanation.howManyThisNumberInThisCol(testProblem.getCandidateBoard(), 9, 0) );
    }

    @Test
    public void howManyThisNumberInThisSection() {
        int[][] testArr = {
                { 1, 0, 3, 0, 0, 6, 0, 8, 9 },
                { 2, 3, 0, 5, 6, 0, 8, 9, 0 },
                { 3, 4, 5, 6, 7, 0, 9, 1, 2 },
                { 4, 0, 6, 7, 8, 0, 1, 0, 3 },
                { 5, 6, 0, 0, 9, 0, 2, 0, 4 },
                { 6, 7, 0, 0, 1, 2, 3, 4, 5 },
                { 7, 0, 0, 1, 2, 3, 4, 5, 0 },
                { 8, 0, 0, 2, 3, 4, 5, 6, 7 },
                { 0, 0, 0, 3, 4, 5, 0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 1, 0) );
        TestCase.assertEquals( 4, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 2, 0) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 3, 0) );
        TestCase.assertEquals( 3, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 4, 0) );
        TestCase.assertEquals( 3, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 3, 9) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 6, 0) );
        TestCase.assertEquals( 7, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 7, 0) );
        TestCase.assertEquals( 0, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 8, 0) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 9, 0) );
        TestCase.assertEquals( 3, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 1, 3) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisSection(testProblem.getCandidateBoard(), 9, 5) );
    }

    @Test
    public void whatSectionIsThisSpot() {
        int[][] testArr = {
                { 1, 0, 3, 0, 0, 6, 0, 8, 9 },
                { 2, 3, 0, 5, 6, 0, 8, 9, 0 },
                { 3, 4, 5, 6, 7, 0, 9, 1, 2 },
                { 4, 0, 6, 7, 8, 0, 1, 0, 3 },
                { 5, 6, 0, 0, 9, 0, 2, 0, 4 },
                { 6, 7, 0, 0, 1, 2, 3, 4, 5 },
                { 7, 0, 0, 1, 2, 3, 4, 5, 0 },
                { 8, 0, 0, 2, 3, 4, 5, 6, 7 },
                { 0, 0, 0, 3, 4, 5, 0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertEquals( 1, JuniorExplanation.whatSectionIsThisSpot(testProblem.getCandidateBoard(), 1, 1) );
        TestCase.assertEquals( 3, JuniorExplanation.whatSectionIsThisSpot(testProblem.getCandidateBoard(), 2, 7) );
        TestCase.assertEquals( 8, JuniorExplanation.whatSectionIsThisSpot(testProblem.getCandidateBoard(), 7, 6) );
        TestCase.assertEquals( 4, JuniorExplanation.whatSectionIsThisSpot(testProblem.getCandidateBoard(), 4, 3) );
        TestCase.assertEquals( 9, JuniorExplanation.whatSectionIsThisSpot(testProblem.getCandidateBoard(), 7, 7) );
        TestCase.assertEquals( 6, JuniorExplanation.whatSectionIsThisSpot(testProblem.getCandidateBoard(), 6, 7) );
        TestCase.assertEquals( -1, JuniorExplanation.whatSectionIsThisSpot(testProblem.getCandidateBoard(), 0, 9) );
        TestCase.assertEquals( -1, JuniorExplanation.whatSectionIsThisSpot(testProblem.getCandidateBoard(), 10, 3) );
        TestCase.assertEquals( -1, JuniorExplanation.whatSectionIsThisSpot(testProblem.getCandidateBoard(), 1, 10) );
        TestCase.assertEquals( -1, JuniorExplanation.whatSectionIsThisSpot(testProblem.getCandidateBoard(), 10, 10) );

    }

    @Test
    public void canBeCenterOfThisCross() {
        int[][] testArr = {
                { 1, 0, 3, 0, 0, 6, 0, 8, 9 },
                { 2, 3, 0, 5, 6, 0, 8, 9, 0 },
                { 3, 4, 5, 6, 7, 0, 9, 1, 2 },
                { 4, 0, 6, 7, 8, 0, 1, 0, 3 },
                { 5, 6, 0, 0, 9, 0, 2, 0, 4 },
                { 6, 7, 0, 0, 1, 2, 3, 4, 5 },
                { 7, 0, 0, 1, 2, 3, 4, 5, 0 },
                { 8, 0, 0, 2, 3, 4, 5, 6, 7 },
                { 0, 0, 0, 3, 4, 5, 0, 7, 0 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertTrue( JuniorExplanation.canBeCenterOfThisCross(testProblem.getCandidateBoard(), 9, 9, 6) );
        TestCase.assertTrue( JuniorExplanation.canBeCenterOfThisCross(testProblem.getCandidateBoard(), 5, 6, 7));
        TestCase.assertTrue( JuniorExplanation.canBeCenterOfThisCross(testProblem.getCandidateBoard(), 2, 3, 4) );
        TestCase.assertTrue( JuniorExplanation.canBeCenterOfThisCross(testProblem.getCandidateBoard(), 4, 2, 2));
        TestCase.assertFalse( JuniorExplanation.canBeCenterOfThisCross(testProblem.getCandidateBoard(), 4, 1, 9) );
        TestCase.assertFalse( JuniorExplanation.canBeCenterOfThisCross(testProblem.getCandidateBoard(), 8, 8, 5) );
        TestCase.assertFalse( JuniorExplanation.canBeCenterOfThisCross(testProblem.getCandidateBoard(), 1, 9, 4) );
    }

    @Test
    public void searchEasySectionToSolve() {
        int[][] testArr1 = {
                { 1, 1, 3,   0, 0, 6,   0, 8, 9 },
                { 2, 3, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 6,   3, 3, 3,   1, 0, 3 },
                { 5, 6, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 8, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        int[][] testArr2 = {
                { 1, 0, 3,   0, 0, 6,   0, 8, 9 },
                { 2, 3, 0,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 6,   0, 0, 0,   1, 0, 3 },
                { 5, 6, 0,   0, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 3,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 0,   4, 5, 1 },
                { 8, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   1, 1, 1 }
        };
        int[][] testArr3 = {
                { 1, 1, 3,   0, 0, 6,   0, 8, 9 },
                { 2, 3, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 0, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 6,   3, 3, 3,   1, 0, 3 },
                { 5, 6, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 8, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem1 = new Problem( testArr1 );
        Problem testProblem2 = new Problem( testArr2 );
        Problem testProblem3 = new Problem( testArr3 );
        TestCase.assertEquals( 5, JuniorExplanation.searchEasySectionToSolve(testProblem1.getCandidateBoard()) );
        TestCase.assertEquals( 8, JuniorExplanation.searchEasySectionToSolve(testProblem2.getCandidateBoard()) );
        TestCase.assertEquals( 1, JuniorExplanation.searchEasySectionToSolve(testProblem3.getCandidateBoard()) );
    }

    @Test
    public void couldBeHereInThisSection() {
        int[][] testArr = {
                { 0, 1, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 8, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertTrue( JuniorExplanation.couldBeHereInThisSection(testProblem.getCandidateBoard(), 1, 1, 9) );
        TestCase.assertFalse(JuniorExplanation.couldBeHereInThisSection(testProblem.getCandidateBoard(), 7, 1, 9));
        TestCase.assertFalse(JuniorExplanation.couldBeHereInThisSection(testProblem.getCandidateBoard(), 2, 6, 7));
        TestCase.assertFalse(JuniorExplanation.couldBeHereInThisSection(testProblem.getCandidateBoard(), 4, 3, 9));
    }

    @Test
    public void isHereZero() {
        int[][] testArr = {
                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertTrue( JuniorExplanation.isHereZero(testProblem.getCandidateBoard(), 1, 1) );
        TestCase.assertTrue( JuniorExplanation.isHereZero(testProblem.getCandidateBoard(), 1, 2) );
        TestCase.assertFalse( JuniorExplanation.isHereZero(testProblem.getCandidateBoard(), 1, 3) );
        TestCase.assertFalse( JuniorExplanation.isHereZero(testProblem.getCandidateBoard(), 5, 5) );
        TestCase.assertFalse( JuniorExplanation.isHereZero(testProblem.getCandidateBoard(), 4, 4) );
        TestCase.assertFalse( JuniorExplanation.isHereZero(testProblem.getCandidateBoard(), 6, 9) );
    }

    @Test
    public void isHereThisNumber() {
        int[][] testArr = {
                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertTrue( JuniorExplanation.isHereThisNumber(testProblem.getCandidateBoard(), 1, 3, 7) );
        TestCase.assertTrue( JuniorExplanation.isHereThisNumber(testProblem.getCandidateBoard(), 2, 2, 0) );
        TestCase.assertTrue( JuniorExplanation.isHereThisNumber(testProblem.getCandidateBoard(), 3, 3, 5) );
        TestCase.assertFalse(JuniorExplanation.isHereThisNumber(testProblem.getCandidateBoard(), 1, 3, 3));
        TestCase.assertFalse(JuniorExplanation.isHereThisNumber(testProblem.getCandidateBoard(), 9, 9, 9));
    }

    @Test
    public void isHereUpperRowSection() {
        int[][] testArr = {
                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertTrue( JuniorExplanation.isHereUpperRowSection(testProblem.getCandidateBoard(), 1) );
        TestCase.assertTrue( JuniorExplanation.isHereUpperRowSection(testProblem.getCandidateBoard(), 2) );
        TestCase.assertTrue( JuniorExplanation.isHereUpperRowSection(testProblem.getCandidateBoard(), 3) );
        TestCase.assertFalse( JuniorExplanation.isHereUpperRowSection(testProblem.getCandidateBoard(), -1) );
        TestCase.assertFalse( JuniorExplanation.isHereUpperRowSection(testProblem.getCandidateBoard(), 5) );
        TestCase.assertFalse( JuniorExplanation.isHereUpperRowSection(testProblem.getCandidateBoard(), 10) );
        TestCase.assertFalse( JuniorExplanation.isHereUpperRowSection(testProblem.getCandidateBoard(), 0) );
    }

    @Test
    public void isHereMiddleRowSection() {
        int[][] testArr = {
                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertTrue( JuniorExplanation.isHereMiddleRowSection(testProblem.getCandidateBoard(), 4) );
        TestCase.assertTrue( JuniorExplanation.isHereMiddleRowSection(testProblem.getCandidateBoard(), 5) );
        TestCase.assertTrue( JuniorExplanation.isHereMiddleRowSection(testProblem.getCandidateBoard(), 6) );
        TestCase.assertFalse( JuniorExplanation.isHereMiddleRowSection(testProblem.getCandidateBoard(), 1) );
        TestCase.assertFalse( JuniorExplanation.isHereMiddleRowSection(testProblem.getCandidateBoard(), -1) );
        TestCase.assertFalse( JuniorExplanation.isHereMiddleRowSection(testProblem.getCandidateBoard(), 10) );
    }

    @Test
    public void isHereLowerRowSection() {
        int[][] testArr = {
                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertTrue( JuniorExplanation.isHereLowerRowSection(testProblem.getCandidateBoard(), 7) );
        TestCase.assertTrue( JuniorExplanation.isHereLowerRowSection(testProblem.getCandidateBoard(), 8) );
        TestCase.assertTrue( JuniorExplanation.isHereLowerRowSection(testProblem.getCandidateBoard(), 9) );
        TestCase.assertFalse( JuniorExplanation.isHereLowerRowSection(testProblem.getCandidateBoard(), 1) );
        TestCase.assertFalse( JuniorExplanation.isHereLowerRowSection(testProblem.getCandidateBoard(), -1) );
        TestCase.assertFalse( JuniorExplanation.isHereLowerRowSection(testProblem.getCandidateBoard(), 10) );

    }

    @Test
    public void isHereLeftColSection() {
        int[][] testArr = {
                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertTrue ( JuniorExplanation.isHereLeftColSection(testProblem.getCandidateBoard(), 1) );
        TestCase.assertTrue ( JuniorExplanation.isHereLeftColSection(testProblem.getCandidateBoard(), 2) );
        TestCase.assertTrue ( JuniorExplanation.isHereLeftColSection(testProblem.getCandidateBoard(), 3) );
        TestCase.assertFalse ( JuniorExplanation.isHereLeftColSection(testProblem.getCandidateBoard(), 0) );
        TestCase.assertFalse ( JuniorExplanation.isHereLeftColSection(testProblem.getCandidateBoard(), 4) );
        TestCase.assertFalse ( JuniorExplanation.isHereLeftColSection(testProblem.getCandidateBoard(), 10) );
        TestCase.assertFalse ( JuniorExplanation.isHereLeftColSection(testProblem.getCandidateBoard(), -1) );
    }

    @Test
    public void isHereMiddleColSection() {
        int[][] testArr = {
                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertTrue ( JuniorExplanation.isHereMiddleColSection(testProblem.getCandidateBoard(), 4) );
        TestCase.assertTrue ( JuniorExplanation.isHereMiddleColSection(testProblem.getCandidateBoard(), 5) );
        TestCase.assertTrue ( JuniorExplanation.isHereMiddleColSection(testProblem.getCandidateBoard(), 6) );
        TestCase.assertFalse ( JuniorExplanation.isHereMiddleColSection(testProblem.getCandidateBoard(), 0) );
        TestCase.assertFalse ( JuniorExplanation.isHereMiddleColSection(testProblem.getCandidateBoard(), 3) );
        TestCase.assertFalse ( JuniorExplanation.isHereMiddleColSection(testProblem.getCandidateBoard(), 10) );
        TestCase.assertFalse ( JuniorExplanation.isHereMiddleColSection(testProblem.getCandidateBoard(), -1) );
    }

    @Test
    public void isHereRightColSection() {
        int[][] testArr = {
                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertTrue ( JuniorExplanation.isHereRightColSection(testProblem.getCandidateBoard(), 7) );
        TestCase.assertTrue ( JuniorExplanation.isHereRightColSection(testProblem.getCandidateBoard(), 8) );
        TestCase.assertTrue ( JuniorExplanation.isHereRightColSection(testProblem.getCandidateBoard(), 9) );
        TestCase.assertFalse ( JuniorExplanation.isHereRightColSection(testProblem.getCandidateBoard(), 0) );
        TestCase.assertFalse ( JuniorExplanation.isHereRightColSection(testProblem.getCandidateBoard(), 6) );
        TestCase.assertFalse ( JuniorExplanation.isHereRightColSection(testProblem.getCandidateBoard(), 10) );
        TestCase.assertFalse ( JuniorExplanation.isHereRightColSection(testProblem.getCandidateBoard(), -1) );
    }

    @Test
    public void inTheArrayBoundary() {
        int[][] testArr = {
                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );
        TestCase.assertTrue( JuniorExplanation.inTheArrayBoundary(testProblem.getCandidateBoard(), 1, 1) );
        TestCase.assertTrue( JuniorExplanation.inTheArrayBoundary(testProblem.getCandidateBoard(), 2, 2) );
        TestCase.assertTrue( JuniorExplanation.inTheArrayBoundary(testProblem.getCandidateBoard(), 3, 3) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testProblem.getCandidateBoard(), 0, 1) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testProblem.getCandidateBoard(), 1, 0) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testProblem.getCandidateBoard(), 10, 1) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testProblem.getCandidateBoard(), 1, 10) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testProblem.getCandidateBoard(), -1, 1) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testProblem.getCandidateBoard(), 1, -1));
    }

    @Test
    public void isHereThisCandidate() {
        int[][] testArr = {
                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },

                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },

                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
        };
        Problem testProblem = new Problem( testArr );

        TestCase.assertEquals(false, JuniorExplanation.isHereThisCandidate( testProblem.getCandidateBoard(), 1, 3, 4));
        TestCase.assertEquals(true, JuniorExplanation.isHereThisCandidate(testProblem.getCandidateBoard(), 1, 1, 4));
    }

    @Test
    public void isHereConfirmed() {
        int[][] testArr = {
                {0, 0, 7, 0, 0, 6, 0, 8, 9},
                {2, 0, 1, 5, 6, 0, 8, 9, 0},
                {3, 4, 5, 6, 7, 0, 9, 1, 2},

                {4, 0, 0, 3, 3, 3, 1, 0, 3},
                {5, 9, 0, 3, 3, 3, 2, 0, 4},
                {6, 7, 0, 3, 3, 0, 3, 4, 5},

                {7, 0, 0, 1, 2, 3, 4, 5, 0},
                {1, 0, 0, 2, 3, 4, 5, 6, 7},
                {0, 0, 0, 3, 4, 5, 0, 7, 8}
        };
        Problem testProblem = new Problem(testArr);

        TestCase.assertTrue(JuniorExplanation.isHereConfirmed(testProblem.getCandidateBoard(), 1, 3));
        TestCase.assertTrue(JuniorExplanation.isHereConfirmed(testProblem.getCandidateBoard(), 3, 3));
        TestCase.assertFalse(JuniorExplanation.isHereConfirmed(testProblem.getCandidateBoard(), 1, 1));

    }

    @Test
    public void candidateRemoval() {
        Element testElement = new Element();

        JuniorExplanation.candidateRemoval( testElement, 3 );
        TestCase.assertEquals( 0, testElement.getCandidates()[2] );

        JuniorExplanation.candidateRemoval( testElement, 5 );
        TestCase.assertEquals( 0, testElement.getCandidates()[4] );

        JuniorExplanation.candidateRemoval( testElement, 9 );
        TestCase.assertEquals( 0, testElement.getCandidates()[8] );

        TestCase.assertEquals( 1, testElement.getCandidates()[0] );

        JuniorExplanation.candidateRemoval( testElement, 1 );
        TestCase.assertEquals( 0, testElement.getCandidates()[0] );

        TestCase.assertEquals( 5, testElement.getNumOfCandidates() );
    }

    @Test
    public void rowCandidateRemoval() {
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

        JuniorExplanation.rowCandidateRemoval ( testProblem.getCandidateBoard(), 1 );
        JuniorExplanation.rowCandidateRemoval ( testProblem.getCandidateBoard(), 2 );
        TestCase.assertEquals( 0, testProblem.getCandidateBoard()[0][2].getCandidates()[6] );
        TestCase.assertEquals(5, testProblem.getCandidateBoard()[1][1].getNumOfCandidates());
        TestCase.assertEquals( 5, testProblem.getCandidateBoard()[1][6].getNumOfCandidates() );
        TestCase.assertEquals( 5, testProblem.getCandidateBoard()[1][7].getNumOfCandidates() );
        TestCase.assertEquals( 5, testProblem.getCandidateBoard()[1][8].getNumOfCandidates() );

        JuniorExplanation.colCandidateRemoval(testProblem.getCandidateBoard(), 2);
        TestCase.assertEquals( 4, testProblem.getCandidateBoard()[1][1].getNumOfCandidates() );

    }

    @Test
    public void colCandidateRemoval() {
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

        JuniorExplanation.colCandidateRemoval( testProblem.getCandidateBoard(), 1 );
        TestCase.assertEquals( 0, testProblem.getCandidateBoard()[2][0].getCandidates()[7] );
        TestCase.assertEquals( 4, testProblem.getCandidateBoard()[2][0].getNumOfCandidates() );
        TestCase.assertEquals( 4, testProblem.getCandidateBoard()[6][0].getNumOfCandidates() );
        TestCase.assertEquals( 4, testProblem.getCandidateBoard()[7][0].getNumOfCandidates() );
        TestCase.assertEquals( 4, testProblem.getCandidateBoard()[8][0].getNumOfCandidates() );
    }

    @Test
    public void transformSingleCandidateToConfirmedElement () {
        Element testElement = new Element();
        for ( int i = 2; i <= 8; i ++ ) {
            testElement.removeACandidate( i );
        }
        TestCase.assertFalse(JuniorExplanation.transformSingleCandidateToConfirmedElement(testElement));
        testElement.removeACandidate( 9 );
        TestCase.assertTrue(JuniorExplanation.transformSingleCandidateToConfirmedElement(testElement));
        TestCase.assertEquals( 1, testElement.getConfirmedElement() );
    }

    @Test
    public void rowTranformSingleCandidateToConfirmedElement() {
        int[][] testArr1 = { { 1, 2, 3, 4, 5, 6, 7, 8, 0 } };
        int[][] testArr2 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 0},
                {0, 3, 4, 5, 6, 7, 8, 9, 1}
        };
        Problem testProblem1 = new Problem( testArr1 );
        Problem testProblem2 = new Problem( testArr2 );

        JuniorExplanation.rowCandidateRemoval( testProblem1.getCandidateBoard(), 1);
        JuniorExplanation.rowCandidateRemoval( testProblem2.getCandidateBoard(), 1);
        JuniorExplanation.rowCandidateRemoval( testProblem2.getCandidateBoard(), 2);

        JuniorExplanation.rowTransformSingleCandidtateToConfirmedElement( testProblem1, 1 );
        JuniorExplanation.rowTransformSingleCandidtateToConfirmedElement( testProblem2, 1 );
        JuniorExplanation.rowTransformSingleCandidtateToConfirmedElement( testProblem2, 2 );

        TestCase.assertEquals( 9, testProblem1.getCandidateBoard()[0][8].getConfirmedElement() );
        TestCase.assertEquals( 9, testProblem2.getCandidateBoard()[0][8].getConfirmedElement() );
        TestCase.assertEquals( 2, testProblem2.getCandidateBoard()[1][0].getConfirmedElement() );
    }

    @Test
    public void colTransformSingleCandidateToConfirmedElement() {
        int[][] testArr = {
                { 1, 2, 3 },
                { 2, 3, 0 },
                { 3, 4, 5 },
                { 4, 5, 6 },
                { 0, 6, 7 },
                { 6, 7, 8 },
                { 7, 0, 9 },
                { 8, 9, 1 },
                { 9, 1, 2 }

        };

        Problem testProblem = new Problem( testArr );

        JuniorExplanation.colCandidateRemoval( testProblem.getCandidateBoard(), 1);
        JuniorExplanation.colCandidateRemoval( testProblem.getCandidateBoard(), 2);
        JuniorExplanation.colCandidateRemoval( testProblem.getCandidateBoard(), 3);

        JuniorExplanation.colTransformSingleCandidateToConfirmedElement( testProblem, 1);
        JuniorExplanation.colTransformSingleCandidateToConfirmedElement( testProblem, 2);
        JuniorExplanation.colTransformSingleCandidateToConfirmedElement( testProblem, 3);

        TestCase.assertEquals( 5, testProblem.getCandidateBoard()[4][0].getConfirmedElement() );
        TestCase.assertEquals( 8, testProblem.getCandidateBoard()[6][1].getConfirmedElement() );
        TestCase.assertEquals( 4, testProblem.getCandidateBoard()[1][2].getConfirmedElement() );

    }

    @Test
    public void solveSingleCandidate() {
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

        JuniorExplanation.solveSingleCandidate( testProblem );

    }









}
