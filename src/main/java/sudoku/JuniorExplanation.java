package sudoku;

public class JuniorExplanation {

    public static int calcNumOfZeroOfRow(int[][] twoDArr, int numOfRow) {
        int numOfZero = 0;
        for (int i = 0; i < twoDArr[numOfRow - 1].length; i++) {
            if ( elementZero( twoDArr, numOfRow, i + 1 ))
                numOfZero++;
        }
        return numOfZero;
    }

    public static int calcNumOfZeroOfCol(int[][] twoDArr, int numOfColumn) {
        int numOfZero = 0;
        for (int i = 0; i < twoDArr.length; i++) {
            if ( elementZero( twoDArr, i + 1, numOfColumn ))
                numOfZero++;
        }
        return numOfZero;
    }

    public static int calcAmountOfNumberOfThreeByThreeSection(int[][] twoDArr, int numOfSection, int number) {
        int amountOfNumber = 0;
        switch (numOfSection) {
            case 1:
                for (int i = 0 * (twoDArr.length / 3); i < 1 * (twoDArr.length / 3); i++) {
                    for (int j = 0 * (twoDArr.length / 3); j < 1 * (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 2:
                for (int i = 0 * (twoDArr.length / 3); i < 1 * (twoDArr.length / 3); i++) {
                    for (int j = 1 * (twoDArr.length / 3); j < 2 * (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }

                break;

            case 3:
                for (int i = 0 * (twoDArr.length / 3); i < 1 * (twoDArr.length / 3); i++) {
                    for (int j = 2 * (twoDArr.length / 3); j < 3 * (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 4:
                for (int i = 1 * (twoDArr.length / 3); i < 2 * (twoDArr.length / 3); i++) {
                    for (int j = 0 * (twoDArr.length / 3); j < 1 * (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 5:
                for (int i = 1 * (twoDArr.length / 3); i < 2 * (twoDArr.length / 3); i++) {
                    for (int j = 1 * (twoDArr.length / 3); j < 2 * (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 6:
                for (int i = 1 * (twoDArr.length / 3); i < 2 * (twoDArr.length / 3); i++) {
                    for (int j = 2 * (twoDArr.length / 3); j < 3 * (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 7:
                for (int i = 2 * (twoDArr.length / 3); i < 3 * (twoDArr.length / 3); i++) {
                    for (int j = 0 * (twoDArr.length / 3); j < 1 * (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 8:
                for (int i = 2 * (twoDArr.length / 3); i < 3 * (twoDArr.length / 3); i++) {
                    for (int j = 1 * (twoDArr.length / 3); j < 2 * (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 9:
                for (int i = 2 * (twoDArr.length / 3); i < 3 * (twoDArr.length / 3); i++) {
                    for (int j = 2 * (twoDArr.length / 3); j < 3 * (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }
                break;
        }
        return amountOfNumber;
    }

    public static int whatSectionIsThisSpot(int[][] twoDArr, int row, int col) {
        int section = 0;

        if (0 * (twoDArr.length / 3) < row && row <= 1 * (twoDArr.length / 3))
            section++;
        else if (1 * (twoDArr.length / 3) < row && row <= 2 * (twoDArr.length / 3))
            section += 4;
        else if (2 * (twoDArr.length / 3) < row && row <= 3 * (twoDArr.length / 3))
            section += 7;
        else {
            return -1;
        }

        if (0 * (twoDArr[row - 1].length / 3) < col && col <= 1 * (twoDArr[row - 1].length / 3)) {
        } else if (1 * (twoDArr[row - 1].length / 3) < col && col <= 2 * (twoDArr[row - 1].length / 3)) {
            section++;
        } else if (2 * (twoDArr[row - 1].length / 3) < col && col <= 3 * (twoDArr[row - 1].length / 3)) {
            section += 2;
        } else {
            return -1;
        }
        return section;
    }

    //매개변수 입력 순서 : 2차원 배열 주소, 행 번호, 열 번호, 계산할 숫자
    //반환형 : 해당 십자가에 입력한 숫자가 없으면 true를 반환 해당 십자가에 입력한 숫자가 존재하면 false를 반환
    public static boolean couldBePlacedOnTheCenterOfThisCross(int[][] twoDArr, int row, int col, int number) {

        if ( twoDArr[row - 1][col - 1] != 0 )
            return false;

        for (int i = 0; i < twoDArr[row - 1].length; i++) {
            if (twoDArr[row - 1][i] == number)
                return false;
        }
        for (int i = 0; i < twoDArr.length; i++) {
            if (twoDArr[i][col - 1] == number)
                return false;
        }
        return true;
    }

    public static int returnSectionMinimumNumberOfZero(int[][] twoDArr) {
        int minSection = 1;
        for (int i = 0; i < 9; i++) {
            if (calcAmountOfNumberOfThreeByThreeSection(twoDArr, i + 1, 0) == 1)
                return i + 1;
            if (calcAmountOfNumberOfThreeByThreeSection(twoDArr, i + 1, 0) == 0)
                continue;
            if ( ( calcAmountOfNumberOfThreeByThreeSection(twoDArr, i + 1, 0) < calcAmountOfNumberOfThreeByThreeSection(twoDArr, minSection, 0) ) ||
                    calcAmountOfNumberOfThreeByThreeSection(twoDArr, minSection, 0) == 0 )
                minSection = i + 1;
        }
        return minSection;
    }

    public static boolean couldBePlacedOnThreeByThree(int[][] twoDArr, int row, int col, int number) {
        if ( !elementZero( twoDArr, row, col) )
            return false;
        int section = whatSectionIsThisSpot( twoDArr, row, col );
        if ( calcAmountOfNumberOfThreeByThreeSection( twoDArr, section, number ) == 0 )
            return true;
        else
            return false;
    }



    public static boolean otherCrossesCheckInThreeByThreeBoundary(int[][] twoDArr, int row, int col, int number) {


        switch ( whatSectionIsThisSpot( twoDArr, row, col ) ) {
            case 1:
                for (int i = 0 * (twoDArr.length / 3); i < 1 * (twoDArr.length / 3); i++) {
                    for (int j = 0 * (twoDArr.length / 3); j < 1 * (twoDArr[i].length / 3); j++) {
                        if ( i == row - 1 && j == col - 1 )
                            continue;
                        if ( couldBePlacedOnTheCenterOfThisCross( twoDArr, i, j, number ) )
                            return false;
                    }
                }
                break;

            case 2:
                for (int i = 0 * (twoDArr.length / 3); i < 1 * (twoDArr.length / 3); i++) {
                    for (int j = 1 * (twoDArr.length / 3); j < 2 * (twoDArr[i].length / 3); j++) {
                        if ( i == row - 1 && j == col - 1 )
                            continue;
                        if ( couldBePlacedOnTheCenterOfThisCross( twoDArr, i, j, number ) )
                            return false;
                    }
                }
                break;

            case 3:
                for (int i = 0 * (twoDArr.length / 3); i < 1 * (twoDArr.length / 3); i++) {
                    for (int j = 2 * (twoDArr.length / 3); j < 3 * (twoDArr[i].length / 3); j++) {
                        if ( i == row - 1 && j == col - 1 )
                            continue;
                        if ( couldBePlacedOnTheCenterOfThisCross( twoDArr, i, j, number ) )
                            return false;
                    }
                }
                break;

            case 4:
                for (int i = 1 * (twoDArr.length / 3); i < 2 * (twoDArr.length / 3); i++) {
                    for (int j = 0 * (twoDArr.length / 3); j < 1 * (twoDArr[i].length / 3); j++) {
                        if ( i == row - 1 && j == col - 1 )
                            continue;
                        if ( couldBePlacedOnTheCenterOfThisCross( twoDArr, i, j, number ) )
                            return false;
                    }
                }
                break;

            case 5:
                for (int i = 1 * (twoDArr.length / 3); i < 2 * (twoDArr.length / 3); i++) {
                    for (int j = 1 * (twoDArr.length / 3); j < 2 * (twoDArr[i].length / 3); j++) {
                        if ( i == row - 1 && j == col - 1 )
                            continue;
                        if ( couldBePlacedOnTheCenterOfThisCross( twoDArr, i, j, number ) )
                            return false;
                    }
                }
                break;

            case 6:
                for (int i = 1 * (twoDArr.length / 3); i < 2 * (twoDArr.length / 3); i++) {
                    for (int j = 2 * (twoDArr.length / 3); j < 3 * (twoDArr[i].length / 3); j++) {
                        if ( i == row - 1 && j == col - 1 )
                            continue;
                        if ( couldBePlacedOnTheCenterOfThisCross( twoDArr, i, j, number ) )
                            return false;
                    }
                }
                break;

            case 7:
                for (int i = 2 * (twoDArr.length / 3); i < 3 * (twoDArr.length / 3); i++) {
                    for (int j = 0 * (twoDArr.length / 3); j < 1 * (twoDArr[i].length / 3); j++) {
                        if ( i == row - 1 && j == col - 1 )
                            continue;
                        if ( couldBePlacedOnTheCenterOfThisCross( twoDArr, i, j, number ) )
                            return false;
                    }
                }
                break;

            case 8:
                for (int i = 2 * (twoDArr.length / 3); i < 3 * (twoDArr.length / 3); i++) {
                    for (int j = 1 * (twoDArr.length / 3); j < 2 * (twoDArr[i].length / 3); j++) {
                        if ( i == row - 1 && j == col - 1 )
                            continue;
                        if ( couldBePlacedOnTheCenterOfThisCross( twoDArr, i, j, number ) )
                            return false;
                    }
                }
                break;

            case 9:
                for (int i = 2 * (twoDArr.length / 3); i < 3 * (twoDArr.length / 3); i++) {
                    for (int j = 2 * (twoDArr.length / 3); j < 3 * (twoDArr[i].length / 3); j++) {
                        if ( i == row - 1 && j == col - 1 )
                            continue;
                        if ( couldBePlacedOnTheCenterOfThisCross( twoDArr, i, j, number ) )
                            return false;
                    }
                }
                break;
        }
        return true;
    }

    public static boolean elementZero(int[][] twoDArr, int row, int col) {
        if ( twoDArr[row - 1][col - 1] == 0)
            return true;
        else
            return false;
    }
}

// TODO 2차원 배열로 문제가 주어지면 후보자 수를 도입한 문제풀이에 적합한 형태의 매서드 생성
//
//
/*
 * 행 하나 탐색해서 0 개수 반환해주는 메소드
 * 열 하나 탐색해서 0 개수 반환해주는 메소드
 * 3x3 섹션에서 입력한 수의 개수 반환해주는 메소드
 * 한 점을 찍으면 그 점이 어느 섹션인지를 반환해주는 메소드
 * 배열, 행, 열, 구하고자 하는 숫자를 매개변수로 입력하면 십자가 상에 그 수가 이미 있는지 여부 반환
 * 배열을 매개변수로 받으면 어느 3x3섹션이 제일 빈칸이 적은지(풀만한지) 반환해주는 메소드
 *
 */
