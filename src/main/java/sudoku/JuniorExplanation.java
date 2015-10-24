package sudoku;

public class JuniorExplanation {

    public static int howManyThisNumberInThisRow(int[][] twoDArr, int row, int number) {
        int numOfNumber = 0;
        for (int i = 0; i < twoDArr[row - 1].length; i++) {
            if (isHereThisNumber(twoDArr, row, i + 1, number))
                numOfNumber++;
        }
        return numOfNumber;
    }

    public static int howManyThisNumberInThisCol(int[][] twoDArr, int col, int number) {
        int numOfNumber = 0;
        for (int i = 0; i < twoDArr.length; i++) {
            if (isHereThisNumber(twoDArr, i + 1, col, number))
                numOfNumber++;
        }
        return numOfNumber;
    }

    public static int howManyThisNumberInThisSection(int[][] twoDArr, int section, int number) {
        int amountOfNumber = 0;
        switch (section) {
            case 1:
                for (int i = 0; i < (twoDArr.length / 3); i++) {
                    for (int j = 0; j < (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 2:
                for (int i = 0; i < (twoDArr.length / 3); i++) {
                    for (int j = (twoDArr.length / 3); j < 2 * (twoDArr[i].length / 3); j++) {
                        if (twoDArr[i][j] == number)
                            amountOfNumber++;
                    }
                }

                break;

            case 3:
                for (int i = 0; i < (twoDArr.length / 3); i++) {
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
        if ( !(inTheArrayBoundary( twoDArr, row, col ) ) ) return -1;
        if ( isHereUpperRowSection(twoDArr, row) ) section ++;
        if ( isHereMiddleRowSection(twoDArr, row) ) section += 4;
        if ( isHereLowerRowSection(twoDArr, row) ) section += 7;
        if ( isHereMiddleColSection(twoDArr, col) ) section ++;
        if ( isHereRightColSection(twoDArr, col) ) section += 2;
        return section;
    }

    public static boolean canBeCenterOfThisCross(int[][] twoDArr, int row, int col, int number) {
        if ( !( isHereZero(twoDArr, row, col ) ) ) return false;
        if ( howManyThisNumberInThisRow( twoDArr, row, number ) != 0 ) return false;
        if ( howManyThisNumberInThisCol(twoDArr, col, number) != 0 ) return false;
        return true;
    }

    public static int searchEasySectionToSolve(int[][] twoDArr) {
        int minSection = 1;
        for (int i = 0; i < 9; i++) {
            if (howManyThisNumberInThisSection(twoDArr, i + 1, 0) == 1) return i + 1;
            if (howManyThisNumberInThisSection(twoDArr, i + 1, 0) == 0) continue;
            if ( ( howManyThisNumberInThisSection(twoDArr, i + 1, 0) < howManyThisNumberInThisSection(twoDArr, minSection, 0)) ||
                   howManyThisNumberInThisSection(twoDArr, minSection, 0) == 0)
                minSection = i + 1;
        }
        return minSection;
    }

    public static boolean couldBeHereInThisSection(int[][] twoDArr, int row, int col, int number) {
        if (!isHereZero(twoDArr, row, col)) return false;
        int section = whatSectionIsThisSpot(twoDArr, row, col);
        if (howManyThisNumberInThisSection(twoDArr, section, number) == 0) return true;
        return false;
    }

    public static boolean otherCrossesCheckInThreeByThreeBoundary(int[][] twoDArr, int row, int col, int number) {
        switch (whatSectionIsThisSpot(twoDArr, row, col)) {
            case 1:
                for (int i = 0; i < (twoDArr.length / 3); i++) {
                    for (int j = 0; j < twoDArr[i].length / 3; j++) {
                        if (i == row - 1 && j == col - 1)
                            continue;
                        if (canBeCenterOfThisCross(twoDArr, i, j, number))
                            return false;
                    }
                }
                break;

            case 2:
                for (int i = 0; i < twoDArr.length / 3; i++) {
                    for (int j = twoDArr.length / 3; j < 2 * (twoDArr[i].length / 3); j++) {
                        if (i == row - 1 && j == col - 1)
                            continue;
                        if (canBeCenterOfThisCross(twoDArr, i, j, number))
                            return false;
                    }
                }
                break;

            case 3:
                for (int i = 0; i < twoDArr.length / 3; i++) {
                    for (int j = 2 * (twoDArr.length / 3); j < 3 * (twoDArr[i].length / 3); j++) {
                        if (i == row - 1 && j == col - 1)
                            continue;
                        if (canBeCenterOfThisCross(twoDArr, i, j, number))
                            return false;
                    }
                }
                break;

            case 4:
                for (int i = twoDArr.length / 3; i < 2 * (twoDArr.length / 3); i++) {
                    for (int j = 0; j < twoDArr[i].length / 3; j++) {
                        if (i == row - 1 && j == col - 1)
                            continue;
                        if (canBeCenterOfThisCross(twoDArr, i, j, number))
                            return false;
                    }
                }
                break;

            case 5:
                for (int i = twoDArr.length / 3; i < 2 * (twoDArr.length / 3); i++) {
                    for (int j = twoDArr.length / 3; j < 2 * (twoDArr[i].length / 3); j++) {
                        if (i == row - 1 && j == col - 1)
                            continue;
                        if (canBeCenterOfThisCross(twoDArr, i, j, number))
                            return false;
                    }
                }
                break;

            case 6:
                for (int i = twoDArr.length / 3; i < 2 * (twoDArr.length / 3); i++) {
                    for (int j = 2 * (twoDArr.length / 3); j < 3 * (twoDArr[i].length / 3); j++) {
                        if (i == row - 1 && j == col - 1)
                            continue;
                        if (canBeCenterOfThisCross(twoDArr, i, j, number))
                            return false;
                    }
                }
                break;

            case 7:
                for (int i = 2 * (twoDArr.length / 3); i < 3 * (twoDArr.length / 3); i++) {
                    for (int j = 0; j < twoDArr[i].length / 3; j++) {
                        if (i == row - 1 && j == col - 1)
                            continue;
                        if (canBeCenterOfThisCross(twoDArr, i, j, number))
                            return false;
                    }
                }
                break;

            case 8:
                for (int i = 2 * (twoDArr.length / 3); i < 3 * (twoDArr.length / 3); i++) {
                    for (int j = twoDArr.length / 3; j < 2 * (twoDArr[i].length / 3); j++) {
                        if (i == row - 1 && j == col - 1)
                            continue;
                        if (canBeCenterOfThisCross(twoDArr, i, j, number))
                            return false;
                    }
                }
                break;

            case 9:
                for (int i = 2 * (twoDArr.length / 3); i < 3 * (twoDArr.length / 3); i++) {
                    for (int j = 2 * (twoDArr.length / 3); j < 3 * (twoDArr[i].length / 3); j++) {
                        if (i == row - 1 && j == col - 1)
                            continue;
                        if (canBeCenterOfThisCross(twoDArr, i, j, number))
                            return false;
                    }
                }
                break;
        }
        return true;
    }

    public static boolean isHereZero(int[][] twoDArr, int row, int col) {
        if (twoDArr[row - 1][col - 1] == 0) return true;
        return false;
    }

    public static boolean isHereThisNumber(int[][] twoDArr, int row, int col, int number) {
        if (twoDArr[row - 1][col - 1] == number) return true;
        else return false;
    }

    public static boolean isHereUpperRowSection(int[][] twoDArr, int row) {
        if ( 0 < row && row <= twoDArr.length / 3 ) return true;
        return false;
    }

    public static boolean isHereMiddleRowSection(int[][] twoDArr, int row) {
        if ( twoDArr.length / 3 < row && row <= 2 * ( twoDArr.length / 3 ) ) return true;
        return false;
    }

    public static boolean isHereLowerRowSection(int[][] twoDArr, int row) {
        if (2 * (twoDArr.length / 3) < row && row <= 3 * (twoDArr.length / 3))
            return true;
        return false;
    }

    public static boolean isHereLeftColSection(int[][] twoDArr, int col) {
        if ( 0 < col && col <= twoDArr[0].length / 3 )
            return true;
        return false;
    }

    public static boolean isHereMiddleColSection(int[][] twoDArr, int col) {
        if (twoDArr[0].length / 3 < col && col <= 2 * (twoDArr[0].length / 3))
            return true;
        return false;
    }

    public static boolean isHereRightColSection(int[][] twoDArr, int col) {
        if (2 * (twoDArr[0].length / 3) < col && col <= 3 * ( twoDArr[0].length / 3 ) )
            return true;
        return false;
    }

    public static boolean inTheArrayBoundary(int[][] twoDArr, int row, int col) {
        if ( row < 1 || twoDArr[0].length < row ) return false;
        if ( col < 1 || twoDArr.length < col ) return false;
        return true;
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
