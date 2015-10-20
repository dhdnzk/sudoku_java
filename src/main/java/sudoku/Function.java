package sudoku;

public class Function {

    public static int calcNumOfZeroOfRow(int[][] TwoDArr, int numOfRow) {
        int numOfZero = 0;
        for ( int i = 0; i < TwoDArr[numOfRow - 1].length; i ++ ) {
            if( TwoDArr[numOfRow - 1][i] == 0 )
                numOfZero ++;
        }
        return numOfZero;
    }

    public static int calcNumOfZeroOfCol(int[][] TwoDArr, int numOfColumn) {
        int numOfZero = 0;
        for ( int i = 0; i < TwoDArr.length; i ++ ) {
            if ( TwoDArr[i][numOfColumn - 1] == 0 )
                numOfZero ++;
        }
        return numOfZero;
    }

    public static int calcNumOfZeroOfThreeByThreeSection(int[][] TwoDArr, int numOfSection) {
        int numOfZero = 0;
        switch ( numOfSection ) {
            case 1:
                for ( int i = 0 * ( TwoDArr.length / 3 ); i < 1 * ( TwoDArr.length / 3 ); i ++ ) {
                   for ( int j = 0 * (TwoDArr.length / 3 ); j < 1 * ( TwoDArr[i].length / 3 ); j ++ ) {
                      if ( TwoDArr[i][j] == 0 )
                          numOfZero ++;
                   }
                }
                break;

            case 2:
                for ( int i = 0 * (TwoDArr.length / 3 ); i < 1 * ( TwoDArr.length / 3 ); i ++ ) {
                    for ( int j = 1 * ( TwoDArr.length / 3 ); j < 2 * ( TwoDArr[i].length / 3); j ++ ) {
                        if ( TwoDArr[i][j] == 0 )
                            numOfZero ++;
                    }
                }

                break;

            case 3:
                for ( int i = 0 * (TwoDArr.length / 3 ); i < 1 * ( TwoDArr.length / 3 ); i ++ ) {
                    for ( int j = 2 * ( TwoDArr.length / 3 ); j < 3 * ( TwoDArr[i].length / 3); j ++ ) {
                        if ( TwoDArr[i][j] == 0 )
                            numOfZero ++;
                    }
                }
                break;

            case 4:
                for ( int i = 1 * (TwoDArr.length / 3 ); i < 2 * ( TwoDArr.length / 3 ); i ++ ) {
                    for ( int j = 0 * ( TwoDArr.length / 3 ); j < 1 * ( TwoDArr[i].length / 3); j ++ ) {
                        if ( TwoDArr[i][j] == 0 )
                            numOfZero ++;
                    }
                }
                break;

            case 5:
                for ( int i = 1 * (TwoDArr.length / 3 ); i < 2 * ( TwoDArr.length / 3 ); i ++ ) {
                    for ( int j = 1 * ( TwoDArr.length / 3 ); j < 2 * ( TwoDArr[i].length / 3); j ++ ) {
                        if ( TwoDArr[i][j] == 0 )
                            numOfZero ++;
                    }
                }
                break;

            case 6:
                for ( int i = 1 * (TwoDArr.length / 3 ); i < 2 * ( TwoDArr.length / 3 ); i ++ ) {
                    for ( int j = 2 * ( TwoDArr.length / 3 ); j < 3 * ( TwoDArr[i].length / 3); j ++ ) {
                        if ( TwoDArr[i][j] == 0 )
                            numOfZero ++;
                    }
                }
                break;

            case 7:
                for ( int i = 2 * (TwoDArr.length / 3 ); i < 3 * ( TwoDArr.length / 3 ); i ++ ) {
                    for ( int j = 0 * ( TwoDArr.length / 3 ); j < 1 * ( TwoDArr[i].length / 3); j ++ ) {
                        if ( TwoDArr[i][j] == 0 )
                            numOfZero ++;
                    }
                }
                break;

            case 8:
                for ( int i = 2 * (TwoDArr.length / 3 ); i < 3 * ( TwoDArr.length / 3 ); i ++ ) {
                    for ( int j = 1 * ( TwoDArr.length / 3 ); j < 2 * ( TwoDArr[i].length / 3); j ++ ) {
                        if ( TwoDArr[i][j] == 0 )
                            numOfZero ++;
                    }
                }
                break;

            case 9:
                for ( int i = 2 * (TwoDArr.length / 3 ); i < 3 * ( TwoDArr.length / 3 ); i ++ ) {
                    for ( int j = 2 * ( TwoDArr.length / 3 ); j < 3 * ( TwoDArr[i].length / 3); j ++ ) {
                        if ( TwoDArr[i][j] == 0 )
                            numOfZero ++;
                    }
                }
                break;
        }
        return numOfZero;
    }



    //매개변수 입력 순서 : 2차원 배열 주소, 행 번호, 열 번호, 계산할 숫자
    //반환형 : 해당 십자가에 입력한 숫자가 없으면 true를 반환 해당 십자가에 입력한 숫자가 존재하면 false를 반환
    public static boolean couldBePlacedOnTheCenterOfThisCross(int[][] TwoDArr, int row, int col, int number) {

        for (int i = 0; i < TwoDArr[row - 1].length; i ++ ) {
            if ( TwoDArr[row - 1][i] == number )
                return false;
        }
        for ( int i = 0; i < TwoDArr.length; i ++ ) {
            if ( TwoDArr[i][col - 1] == number )
                return false;
        }
        return true;
    }

    public static int whatSectionIsThisSpot(int[][] TwoDArr, int row, int col) {
        int section = 1;

        // 세로 길이 /3을 해서 나온 값*0 <= row <세로 길이/3을 해서 나온 값*1
        // 

        // 세로 길이 /3을 해서 나온 값*1 <= row < 세로 길이/3을 해서 나온 값*2
        //

        //세로 길이 /3을 해서 나온 값2 <= row < 세로 길이/3을 해서 나온 값 *3
        //


        section +=








        return section;
    }
}


