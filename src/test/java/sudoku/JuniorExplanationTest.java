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

        TestCase.assertEquals( 1, JuniorExplanation.howManyThisNumberInThisRow(testArr1, 1, 0) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisRow(testArr2, 1, 0) );
        TestCase.assertEquals( 3, JuniorExplanation.howManyThisNumberInThisRow(testArr2, 2, 0) );
        TestCase.assertEquals( 5, JuniorExplanation.howManyThisNumberInThisRow(testArr3, 1, 0) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisRow(testArr3, 2, 0) );
        TestCase.assertEquals( 9, JuniorExplanation.howManyThisNumberInThisRow(testArr3, 3, 0) );
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

        TestCase.assertEquals ( 1, JuniorExplanation.howManyThisNumberInThisCol(testArr, 1, 0) );
        TestCase.assertEquals ( 3, JuniorExplanation.howManyThisNumberInThisCol(testArr, 2, 0) );
        TestCase.assertEquals ( 5, JuniorExplanation.howManyThisNumberInThisCol(testArr, 3, 0) );
        TestCase.assertEquals ( 2, JuniorExplanation.howManyThisNumberInThisCol(testArr, 9, 0) );
    }

    @Test
    public void hoManyThisNumbersInThisSection() {
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

        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisSection(testArr, 1, 0) );
        TestCase.assertEquals( 4, JuniorExplanation.howManyThisNumberInThisSection(testArr, 2, 0) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisSection(testArr, 3, 0) );
        TestCase.assertEquals( 3, JuniorExplanation.howManyThisNumberInThisSection(testArr, 4, 0) );
        TestCase.assertEquals( 3, JuniorExplanation.howManyThisNumberInThisSection(testArr, 3, 9) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisSection(testArr, 6, 0) );
        TestCase.assertEquals( 7, JuniorExplanation.howManyThisNumberInThisSection(testArr, 7, 0) );
        TestCase.assertEquals( 0, JuniorExplanation.howManyThisNumberInThisSection(testArr, 8, 0) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisSection(testArr, 9, 0) );
        TestCase.assertEquals( 3, JuniorExplanation.howManyThisNumberInThisSection(testArr, 1, 3) );
        TestCase.assertEquals( 2, JuniorExplanation.howManyThisNumberInThisSection(testArr, 9, 5) );
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

        TestCase.assertTrue( JuniorExplanation.canBeCenterOfThisCross(testArr, 9, 9, 6) );
        TestCase.assertTrue( JuniorExplanation.canBeCenterOfThisCross(testArr, 5, 6, 7));
        TestCase.assertTrue( JuniorExplanation.canBeCenterOfThisCross(testArr, 2, 3, 4) );
        TestCase.assertTrue( JuniorExplanation.canBeCenterOfThisCross(testArr, 4, 2, 2));
        TestCase.assertFalse( JuniorExplanation.canBeCenterOfThisCross(testArr, 4, 1, 9) );
        TestCase.assertFalse( JuniorExplanation.canBeCenterOfThisCross(testArr, 8, 8, 5) );
        TestCase.assertFalse( JuniorExplanation.canBeCenterOfThisCross(testArr, 1, 9, 4) );
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

//    @Test
//    public void otherCrossesCheckInThreeByThreeBoundary () {
//        int[][] testArr = {
//                { 0, 0, 7,   0, 0, 6,   0, 8, 9 },
//                { 2, 0, 1,   5, 6, 0,   8, 9, 0 },
//                { 3, 4, 5,   6, 7, 0,   9, 1, 2 },
//
//                { 4, 0, 0,   3, 3, 3,   1, 0, 3 },
//                { 5, 9, 0,   3, 3, 3,   2, 0, 4 },
//                { 6, 7, 0,   3, 3, 0,   3, 4, 5 },
//
//                { 7, 0, 0,   1, 2, 3,   4, 5, 0 },
//                { 1, 0, 0,   2, 3, 4,   5, 6, 7 },
//                { 0, 0, 0,   3, 4, 5,   0, 7, 8 }
//        };
//
//        TestCase.assertTrue( JuniorExplanation.otherCrossesCheckInThreeByThreeBoundary( testArr, 1, 1, 1 ) );
//
//    }

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
        TestCase.assertTrue( JuniorExplanation.isHereZero(testArr, 1, 1) );
        TestCase.assertTrue( JuniorExplanation.isHereZero(testArr, 1, 2) );
        TestCase.assertFalse( JuniorExplanation.isHereZero(testArr, 1, 3) );
        TestCase.assertFalse( JuniorExplanation.isHereZero(testArr, 5, 5) );
        TestCase.assertFalse( JuniorExplanation.isHereZero(testArr, 4, 4) );
        TestCase.assertFalse( JuniorExplanation.isHereZero(testArr, 6, 9) );
    }


    @Test
    public void elementNumber () {
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

        TestCase.assertTrue( JuniorExplanation.isHereThisNumber(testArr, 1, 3, 7) );
        TestCase.assertTrue( JuniorExplanation.isHereThisNumber(testArr, 2, 2, 0) );
        TestCase.assertTrue( JuniorExplanation.isHereThisNumber(testArr, 3, 3, 5) );
        TestCase.assertFalse(JuniorExplanation.isHereThisNumber(testArr, 1, 3, 3));
        TestCase.assertFalse(JuniorExplanation.isHereThisNumber(testArr, 9, 9, 9));
    }


    @Test
    public void isThisUpperRowSection () {
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

        TestCase.assertTrue( JuniorExplanation.isHereUpperRowSection(testArr, 1) );
        TestCase.assertTrue( JuniorExplanation.isHereUpperRowSection(testArr, 2) );
        TestCase.assertTrue( JuniorExplanation.isHereUpperRowSection(testArr, 3) );
        TestCase.assertFalse( JuniorExplanation.isHereUpperRowSection(testArr, -1) );
        TestCase.assertFalse( JuniorExplanation.isHereUpperRowSection(testArr, 5) );
        TestCase.assertFalse( JuniorExplanation.isHereUpperRowSection(testArr, 10) );
        TestCase.assertFalse( JuniorExplanation.isHereUpperRowSection(testArr, 0) );
    }

    @Test
    public void isThisMiddleRowSection() {
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

        TestCase.assertTrue( JuniorExplanation.isHereMiddleRowSection(testArr, 4) );
        TestCase.assertTrue( JuniorExplanation.isHereMiddleRowSection(testArr, 5) );
        TestCase.assertTrue( JuniorExplanation.isHereMiddleRowSection(testArr, 6) );
        TestCase.assertFalse( JuniorExplanation.isHereMiddleRowSection(testArr, 1) );
        TestCase.assertFalse( JuniorExplanation.isHereMiddleRowSection(testArr, -1) );
        TestCase.assertFalse( JuniorExplanation.isHereMiddleRowSection(testArr, 10) );
    }


    @Test
    public void isThisBottomRowSection() {
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

        TestCase.assertTrue( JuniorExplanation.isHereLowerRowSection(testArr, 7) );
        TestCase.assertTrue( JuniorExplanation.isHereLowerRowSection(testArr, 8) );
        TestCase.assertTrue( JuniorExplanation.isHereLowerRowSection(testArr, 9) );
        TestCase.assertFalse( JuniorExplanation.isHereLowerRowSection(testArr, 1) );
        TestCase.assertFalse( JuniorExplanation.isHereLowerRowSection(testArr, -1) );
        TestCase.assertFalse( JuniorExplanation.isHereLowerRowSection(testArr, 10) );

    }


    @Test
    public void isThisLeftColSection () {
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

        TestCase.assertTrue ( JuniorExplanation.isHereLeftColSection(testArr, 1) );
        TestCase.assertTrue ( JuniorExplanation.isHereLeftColSection(testArr, 2) );
        TestCase.assertTrue ( JuniorExplanation.isHereLeftColSection(testArr, 3) );
        TestCase.assertFalse ( JuniorExplanation.isHereLeftColSection(testArr, 0) );
        TestCase.assertFalse ( JuniorExplanation.isHereLeftColSection(testArr, 4) );
        TestCase.assertFalse ( JuniorExplanation.isHereLeftColSection(testArr, 10) );
        TestCase.assertFalse ( JuniorExplanation.isHereLeftColSection(testArr, -1) );
    }


    @Test
    public void isThisMiddleColSection () {
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

        TestCase.assertTrue ( JuniorExplanation.isHereMiddleColSection(testArr, 4) );
        TestCase.assertTrue ( JuniorExplanation.isHereMiddleColSection(testArr, 5) );
        TestCase.assertTrue ( JuniorExplanation.isHereMiddleColSection(testArr, 6) );
        TestCase.assertFalse ( JuniorExplanation.isHereMiddleColSection(testArr, 0) );
        TestCase.assertFalse ( JuniorExplanation.isHereMiddleColSection(testArr, 3) );
        TestCase.assertFalse ( JuniorExplanation.isHereMiddleColSection(testArr, 10) );
        TestCase.assertFalse ( JuniorExplanation.isHereMiddleColSection(testArr, -1) );
    }

   @Test
    public void isThisRightColSection () {
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

       TestCase.assertTrue ( JuniorExplanation.isHereRightColSection(testArr, 7) );
       TestCase.assertTrue ( JuniorExplanation.isHereRightColSection(testArr, 8) );
       TestCase.assertTrue ( JuniorExplanation.isHereRightColSection(testArr, 9) );
       TestCase.assertFalse ( JuniorExplanation.isHereRightColSection(testArr, 0) );
       TestCase.assertFalse ( JuniorExplanation.isHereRightColSection(testArr, 6) );
       TestCase.assertFalse ( JuniorExplanation.isHereRightColSection(testArr, 10) );
       TestCase.assertFalse ( JuniorExplanation.isHereRightColSection(testArr, -1) );
   }

    @Test
    public void inTheArrBoundary () {
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
        TestCase.assertTrue( JuniorExplanation.inTheArrayBoundary(testArr, 1, 1) );
        TestCase.assertTrue( JuniorExplanation.inTheArrayBoundary(testArr, 2, 2) );
        TestCase.assertTrue( JuniorExplanation.inTheArrayBoundary(testArr, 3, 3) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testArr, 0, 1) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testArr, 1, 0) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testArr, 10, 1) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testArr, 1, 10) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testArr, -1, 1) );
        TestCase.assertFalse( JuniorExplanation.inTheArrayBoundary(testArr, 1, -1));
    }





















}
