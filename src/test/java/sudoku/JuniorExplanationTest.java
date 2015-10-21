package sudoku;

import junit.framework.TestCase;
import org.junit.Test;

//TODO 1. 뭉쳐있는 9개 칸에 0 개수 확인 후 빈칸 1개면 푸는 방법
//TODO 2. 가로로 한줄 검사 후에 빈칸 1개면 푸는 방법
//TODO 3. 세로로 한줄 검사 후에 빈칸 1개면 푸는 방법
//TODO 4. 해당 자리에서 3x3 & 인접한 두 라인의 세로줄 고려
//TODO 5. 해당 자리에서 3x3 & 인접한 두 라인의 가로줄 고려
//TODO 6. 해당 자리에서 3x3 & 십자가 고려
//  현재 자리에서 3x3으로 가능하다 &&
//  현재 자리에서 십자가로 판단해서 가능하다 &&
//  3x3내의 모든 빈칸들 십자가 검사해서 전부 false 나오면 채우기
//TODO 기타 풀이법 생각날때마다 하나씩 추가

public class JuniorExplanationTest {

    @Test
    public void calcNumOfZeroOfRow() {
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

        TestCase.assertEquals( 1, JuniorExplanation.calcNumOfZeroOfRow(testArr1, 1) );
        TestCase.assertEquals( 2, JuniorExplanation.calcNumOfZeroOfRow(testArr2, 1) );
        TestCase.assertEquals( 3, JuniorExplanation.calcNumOfZeroOfRow(testArr2, 2) );
        TestCase.assertEquals( 5, JuniorExplanation.calcNumOfZeroOfRow(testArr3, 1) );
        TestCase.assertEquals( 2, JuniorExplanation.calcNumOfZeroOfRow(testArr3, 2) );
        TestCase.assertEquals( 9, JuniorExplanation.calcNumOfZeroOfRow(testArr3, 3) );
    }

    @Test
    public void calcNumOfZeroOfCol() {
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

        TestCase.assertEquals ( 1, JuniorExplanation.calcNumOfZeroOfCol(testArr, 1) );
        TestCase.assertEquals ( 3, JuniorExplanation.calcNumOfZeroOfCol(testArr, 2) );
        TestCase.assertEquals ( 5, JuniorExplanation.calcNumOfZeroOfCol(testArr, 3) );
        TestCase.assertEquals ( 2, JuniorExplanation.calcNumOfZeroOfCol(testArr, 9) );
    }

    @Test
    public void calcNumOfZeroOfThreeByThreeSection() {
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

        TestCase.assertEquals( 2, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 1, 0 ) );
        TestCase.assertEquals( 4, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 2, 0 ) );
        TestCase.assertEquals( 2, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 3, 0 ) );
        TestCase.assertEquals( 3, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 4, 0 ) );
        TestCase.assertEquals( 3, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 3, 9 ) );
        TestCase.assertEquals( 2, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 6, 0 ) );
        TestCase.assertEquals( 7, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 7, 0 ) );
        TestCase.assertEquals( 0, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 8, 0 ) );
        TestCase.assertEquals( 2, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 9, 0 ) );
        TestCase.assertEquals( 3, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 1, 3 ) );
        TestCase.assertEquals( 2, JuniorExplanation.calcAmountOfNumberOfThreeByThreeSection(testArr, 9, 5) );
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

        TestCase.assertEquals( 1, JuniorExplanation.whatSectionIsThisSpot(testArr, 1, 1) );
        TestCase.assertEquals( 3, JuniorExplanation.whatSectionIsThisSpot(testArr, 2, 7) );
        TestCase.assertEquals( 8, JuniorExplanation.whatSectionIsThisSpot(testArr, 7, 6) );
        TestCase.assertEquals( 4, JuniorExplanation.whatSectionIsThisSpot(testArr, 4, 3) );
        TestCase.assertEquals( 9, JuniorExplanation.whatSectionIsThisSpot(testArr, 7, 7) );
        TestCase.assertEquals( 6, JuniorExplanation.whatSectionIsThisSpot(testArr, 6, 7) );
        TestCase.assertEquals( -1, JuniorExplanation.whatSectionIsThisSpot(testArr, 0, 9) );
        TestCase.assertEquals( -1, JuniorExplanation.whatSectionIsThisSpot(testArr, 10, 3) );
        TestCase.assertEquals( -1, JuniorExplanation.whatSectionIsThisSpot(testArr, 1, 10) );
        TestCase.assertEquals( -1, JuniorExplanation.whatSectionIsThisSpot(testArr, 10, 10) );

    }

    @Test
    public void couldBePlacedOnTheCenterOfThisCross() {
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

        TestCase.assertTrue( JuniorExplanation.couldBePlacedOnTheCenterOfThisCross(testArr, 9, 9, 6) );
        TestCase.assertTrue( JuniorExplanation.couldBePlacedOnTheCenterOfThisCross(testArr, 5, 6, 7));
        TestCase.assertTrue( JuniorExplanation.couldBePlacedOnTheCenterOfThisCross(testArr, 2, 3, 4) );
        TestCase.assertTrue( JuniorExplanation.couldBePlacedOnTheCenterOfThisCross(testArr, 4, 2, 2));
        TestCase.assertFalse( JuniorExplanation.couldBePlacedOnTheCenterOfThisCross(testArr, 4, 1, 9) );
        TestCase.assertFalse( JuniorExplanation.couldBePlacedOnTheCenterOfThisCross(testArr, 8, 8, 5) );
        TestCase.assertFalse( JuniorExplanation.couldBePlacedOnTheCenterOfThisCross(testArr, 1, 9, 4) );
    }

    @Test
    public void returnSectionMinimumNumberOfZero() {
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
        TestCase.assertEquals( 5, JuniorExplanation.returnSectionMinimumNumberOfZero( testArr1 ) );
        TestCase.assertEquals( 8, JuniorExplanation.returnSectionMinimumNumberOfZero( testArr2 ) );
        TestCase.assertEquals( 1, JuniorExplanation.returnSectionMinimumNumberOfZero(testArr3) );
    }

    @Test
    public void couldBePlacedOnThreeByThree( ) {
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

        TestCase.assertTrue( JuniorExplanation.couldBePlacedOnThreeByThree( testArr, 1, 1, 9 ) );
        TestCase.assertFalse(JuniorExplanation.couldBePlacedOnThreeByThree(testArr, 7, 1, 9));
        TestCase.assertFalse(JuniorExplanation.couldBePlacedOnThreeByThree(testArr, 2, 6, 7));
        TestCase.assertFalse(JuniorExplanation.couldBePlacedOnThreeByThree(testArr, 4, 3, 9));
    }

    @Test
    public void otherCrossesCheckInThreeByThreeBoundary () {
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

        TestCase.assertTrue( JuniorExplanation.otherCrossesCheckInThreeByThreeBoundary( testArr, 1, 1, 1 ) );

    }

    @Test
    public void elementZero () {
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
        TestCase.assertTrue( JuniorExplanation.elementZero(testArr, 1, 1) );
        TestCase.assertTrue( JuniorExplanation.elementZero(testArr, 1, 2) );
        TestCase.assertFalse( JuniorExplanation.elementZero(testArr, 1, 3) );
        TestCase.assertFalse( JuniorExplanation.elementZero(testArr, 5, 5) );
        TestCase.assertFalse( JuniorExplanation.elementZero(testArr, 4, 4) );
        TestCase.assertFalse( JuniorExplanation.elementZero(testArr, 6, 9) );
    }




}
