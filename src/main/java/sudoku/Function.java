package sudoku;

public class Function {

    public static int returnNumOfZeroOfRow(int[] arr) {
        int numOfZero = 0;
        for (int i = 0; i < arr.length; i ++ ) {
            if ( arr[i] == 0 )
                numOfZero ++;
        }
        return numOfZero;
    }

    public static int returnNumOfZeroOfRow(int[][] TwoDArr, int numOfRow) {
        int numOfZero = 0;
        for ( int i = 0; i < TwoDArr[numOfRow - 1].length; i ++ ) {
            if( TwoDArr[numOfRow - 1][i] == 0 )
                numOfZero ++;
        }
        return numOfZero;
    }

    public static int returnNumOfZeroOfCol(int[][] TwoDArr, int numOfColumn) {
        int numOfZero = 0;
        for ( int i = 0; i < TwoDArr.length; i ++ ) {
            if ( TwoDArr[i][numOfColumn - 1] == 0 )
                numOfZero ++;
        }
        return numOfZero;
    }

}
