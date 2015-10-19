package sudoku;

import junit.framework.TestCase;
import org.junit.Test;

//TODO 뭉쳐있는 9개 칸에 0 개수 확인 후 가능하면 푸는 방법
//TODO 가로로 한줄 검사 후에 풀 수 있으면 푸는 방법
//TODO 세로로 한줄 검사 후에 풀 수 있으면 푸는 방법
//TODO 기타 풀이법 생각날때마다 하나씩 추가

public class FunctionTest {

    @Test
    public void returnNumOfZeroOfRow() {
        int[] testArr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 0};
        int[] testArr2 = { 1, 0, 3, 4, 5, 6, 7, 8, 0};
        int[] testArr3 = { 1, 2, 0, 0, 5, 6, 7, 8, 0};
        int[] testArr4 = { 0, 2, 0, 0, 5, 6, 7, 8, 0};
        int[][] testArr5 = {
                { 1, 7, 0, 0, 5, 0, 2, 0, 0 },
                { 1, 2, 3, 4, 5, 6, 7, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        TestCase.assertEquals( 1, Function.returnNumOfZeroOfRow( testArr1 ) );
        TestCase.assertEquals( 2, Function.returnNumOfZeroOfRow( testArr2 ) );
        TestCase.assertEquals( 3, Function.returnNumOfZeroOfRow( testArr3 ) );
        TestCase.assertEquals( 4, Function.returnNumOfZeroOfRow( testArr4 ) );
        TestCase.assertEquals( 5, Function.returnNumOfZeroOfRow( testArr5, 1 ) );
        TestCase.assertEquals( 2, Function.returnNumOfZeroOfRow( testArr5, 2 ) );
        TestCase.assertEquals( 9, Function.returnNumOfZeroOfRow( testArr5, 3 ) );
    }

    @Test
    public void returnNumOfZeroOfCol() {
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

        TestCase.assertEquals ( 1, Function.returnNumOfZeroOfCol( testArr, 1 ) );
        TestCase.assertEquals ( 3, Function.returnNumOfZeroOfCol( testArr, 2 ) );
        TestCase.assertEquals ( 5, Function.returnNumOfZeroOfCol( testArr, 3 ) );
        TestCase.assertEquals ( 2, Function.returnNumOfZeroOfCol( testArr, 9 ) );
    }

    @Test
    public void solveWhenNumOfZeroIsOneOfCol() {

    }

}
