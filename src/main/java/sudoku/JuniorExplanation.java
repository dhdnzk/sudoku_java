package sudoku;

public class JuniorExplanation {

    public static int calcNumOfZeroOfRow(int[][] TwoDArr, int numOfRow) {
        int numOfZero = 0;
        for (int i = 0; i < TwoDArr[numOfRow - 1].length; i++) {
            if (TwoDArr[numOfRow - 1][i] == 0)
                numOfZero++;
        }
        return numOfZero;
    }

    public static int calcNumOfZeroOfCol(int[][] TwoDArr, int numOfColumn) {
        int numOfZero = 0;
        for (int i = 0; i < TwoDArr.length; i++) {
            if (TwoDArr[i][numOfColumn - 1] == 0)
                numOfZero++;
        }
        return numOfZero;
    }

    public static int calcNumOfZeroOfThreeByThreeSection(int[][] TwoDArr, int numOfSection) {
        int numOfZero = 0;
        switch (numOfSection) {
            case 1:
                for (int i = 0 * (TwoDArr.length / 3); i < 1 * (TwoDArr.length / 3); i++) {
                    for (int j = 0 * (TwoDArr.length / 3); j < 1 * (TwoDArr[i].length / 3); j++) {
                        if (TwoDArr[i][j] == 0)
                            numOfZero++;
                    }
                }
                break;

            case 2:
                for (int i = 0 * (TwoDArr.length / 3); i < 1 * (TwoDArr.length / 3); i++) {
                    for (int j = 1 * (TwoDArr.length / 3); j < 2 * (TwoDArr[i].length / 3); j++) {
                        if (TwoDArr[i][j] == 0)
                            numOfZero++;
                    }
                }

                break;

            case 3:
                for (int i = 0 * (TwoDArr.length / 3); i < 1 * (TwoDArr.length / 3); i++) {
                    for (int j = 2 * (TwoDArr.length / 3); j < 3 * (TwoDArr[i].length / 3); j++) {
                        if (TwoDArr[i][j] == 0)
                            numOfZero++;
                    }
                }
                break;

            case 4:
                for (int i = 1 * (TwoDArr.length / 3); i < 2 * (TwoDArr.length / 3); i++) {
                    for (int j = 0 * (TwoDArr.length / 3); j < 1 * (TwoDArr[i].length / 3); j++) {
                        if (TwoDArr[i][j] == 0)
                            numOfZero++;
                    }
                }
                break;

            case 5:
                for (int i = 1 * (TwoDArr.length / 3); i < 2 * (TwoDArr.length / 3); i++) {
                    for (int j = 1 * (TwoDArr.length / 3); j < 2 * (TwoDArr[i].length / 3); j++) {
                        if (TwoDArr[i][j] == 0)
                            numOfZero++;
                    }
                }
                break;

            case 6:
                for (int i = 1 * (TwoDArr.length / 3); i < 2 * (TwoDArr.length / 3); i++) {
                    for (int j = 2 * (TwoDArr.length / 3); j < 3 * (TwoDArr[i].length / 3); j++) {
                        if (TwoDArr[i][j] == 0)
                            numOfZero++;
                    }
                }
                break;

            case 7:
                for (int i = 2 * (TwoDArr.length / 3); i < 3 * (TwoDArr.length / 3); i++) {
                    for (int j = 0 * (TwoDArr.length / 3); j < 1 * (TwoDArr[i].length / 3); j++) {
                        if (TwoDArr[i][j] == 0)
                            numOfZero++;
                    }
                }
                break;

            case 8:
                for (int i = 2 * (TwoDArr.length / 3); i < 3 * (TwoDArr.length / 3); i++) {
                    for (int j = 1 * (TwoDArr.length / 3); j < 2 * (TwoDArr[i].length / 3); j++) {
                        if (TwoDArr[i][j] == 0)
                            numOfZero++;
                    }
                }
                break;

            case 9:
                for (int i = 2 * (TwoDArr.length / 3); i < 3 * (TwoDArr.length / 3); i++) {
                    for (int j = 2 * (TwoDArr.length / 3); j < 3 * (TwoDArr[i].length / 3); j++) {
                        if (TwoDArr[i][j] == 0)
                            numOfZero++;
                    }
                }
                break;
        }
        return numOfZero;
    }

    public static int whatSectionIsThisSpot(int[][] TwoDArr, int row, int col) {
        int section = 0;

        if (0 * (TwoDArr.length / 3) < row && row <= 1 * (TwoDArr.length / 3))
            section++;
        else if (1 * (TwoDArr.length / 3) < row && row <= 2 * (TwoDArr.length / 3))
            section += 4;
        else if (2 * (TwoDArr.length / 3) < row && row <= 3 * (TwoDArr.length / 3))
            section += 7;
        else {
            return -1;
        }

        if (0 * (TwoDArr[row - 1].length / 3) < col && col <= 1 * (TwoDArr[row - 1].length / 3)) {
        } else if (1 * (TwoDArr[row - 1].length / 3) < col && col <= 2 * (TwoDArr[row - 1].length / 3)) {
            section++;
        } else if (2 * (TwoDArr[row - 1].length / 3) < col && col <= 3 * (TwoDArr[row - 1].length / 3)) {
            section += 2;
        } else {
            return -1;
        }
        return section;
    }

    //매개변수 입력 순서 : 2차원 배열 주소, 행 번호, 열 번호, 계산할 숫자
    //반환형 : 해당 십자가에 입력한 숫자가 없으면 true를 반환 해당 십자가에 입력한 숫자가 존재하면 false를 반환
    public static boolean couldBePlacedOnTheCenterOfThisCross(int[][] TwoDArr, int row, int col, int number) {

        for (int i = 0; i < TwoDArr[row - 1].length; i++) {
            if (TwoDArr[row - 1][i] == number)
                return false;
        }
        for (int i = 0; i < TwoDArr.length; i++) {
            if (TwoDArr[i][col - 1] == number)
                return false;
        }
        return true;
    }

    public static int returnSectionMinimumNumberOfZero(int[][] TwoDArr) {
        int minSection = 1;
        for (int i = 0; i < 9; i++) {
            if (calcNumOfZeroOfThreeByThreeSection(TwoDArr, i + 1) == 0)
                continue;
            else if (calcNumOfZeroOfThreeByThreeSection(TwoDArr, i + 1) == 1)
                return i + 1;

            if ((calcNumOfZeroOfThreeByThreeSection(TwoDArr, i + 1) < calcNumOfZeroOfThreeByThreeSection(TwoDArr, minSection)) ||
                    calcNumOfZeroOfThreeByThreeSection(TwoDArr, minSection) == 0) {
                minSection = i + 1;
            }
        }
        return minSection;
    }
}






// TODO 2차원 배열로 문제가 주어지면 후보자 수를 도입한 문제풀이에 적합한 형태의 매서드 생성
//
//
/*
 * 행 하나 탐색해서 0 개수 반환해주는 메소드
 * 열 하나 탐색해서 0 개수 반환해주는 메소드
 * 3x3 한 섹션에서 0 개수 반환해주는 메소드
 * 한 점을 찍으면 그 점이 어느 섹션인지를 반환해주는 메소드
 * 배열, 행, 열, 구하고자 하는 숫자를 매개변수로 입력하면 십자가 상에 그 수가 이미 있는지 여부 반환
 *
 */
