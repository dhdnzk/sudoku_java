package sudoku;

public class JuniorExplanation {

    public static int howManyThisNumberInThisRow(Element[][] candidateTwoDArr, int row, int number) {
        int numOfNumber = 0;
        for (int i = 0; i < candidateTwoDArr[row - 1].length; i++) {
            if (isHereThisNumber(candidateTwoDArr, row, i + 1, number))
                numOfNumber++;
        }
        return numOfNumber;
    }

    public static int howManyThisNumberInThisCol(Element[][] candidateTwoDArr, int col, int number) {
        int numOfNumber = 0;
        for (int i = 0; i < candidateTwoDArr.length; i++) {
            if (isHereThisNumber(candidateTwoDArr, i + 1, col, number))
                numOfNumber++;
        }
        return numOfNumber;
    }

    // FIXME switch문 간단하게 리펙토링 요망(section별로 case구분하지 않고 흐름 분기될 수 있도록)
    public static int howManyThisNumberInThisSection(Element[][] candidateTwoDArr, int section, int number) {
        int amountOfNumber = 0;
        switch (section) {
            case 1:
                for (int i = 0; i < (candidateTwoDArr.length / 3); i++) {
                    for (int j = 0; j < (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 2:
                for (int i = 0; i < (candidateTwoDArr.length / 3); i++) {
                    for (int j = (candidateTwoDArr.length / 3); j < 2 * (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }

                break;

            case 3:
                for (int i = 0; i < (candidateTwoDArr.length / 3); i++) {
                    for (int j = 2 * (candidateTwoDArr.length / 3); j < 3 * (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 4:
                for (int i = 1 * (candidateTwoDArr.length / 3); i < 2 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = 0 * (candidateTwoDArr.length / 3); j < 1 * (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 5:
                for (int i = 1 * (candidateTwoDArr.length / 3); i < 2 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = 1 * (candidateTwoDArr.length / 3); j < 2 * (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 6:
                for (int i = 1 * (candidateTwoDArr.length / 3); i < 2 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = 2 * (candidateTwoDArr.length / 3); j < 3 * (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 7:
                for (int i = 2 * (candidateTwoDArr.length / 3); i < 3 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = 0 * (candidateTwoDArr.length / 3); j < 1 * (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 8:
                for (int i = 2 * (candidateTwoDArr.length / 3); i < 3 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = 1 * (candidateTwoDArr.length / 3); j < 2 * (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 9:
                for (int i = 2 * (candidateTwoDArr.length / 3); i < 3 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = 2 * (candidateTwoDArr.length / 3); j < 3 * (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;
        }
        return amountOfNumber;
    }

    public static int whatSectionIsThisSpot(Element[][] candidateTwoDArr, int row, int col) {
        int section = 0;
        if (!(inTheArrayBoundary(candidateTwoDArr, row, col))) return -1;
        if (isHereUpperRowSection(candidateTwoDArr, row)) section++;
        if (isHereMiddleRowSection(candidateTwoDArr, row)) section += 4;
        if (isHereLowerRowSection(candidateTwoDArr, row)) section += 7;
        if (isHereMiddleColSection(candidateTwoDArr, col)) section++;
        if (isHereRightColSection(candidateTwoDArr, col)) section += 2;
        return section;
    }

    public static boolean canBeCenterOfThisCross(Element[][] candidateTwoDArr, int row, int col, int number) {
        if (!(isHereZero(candidateTwoDArr, row, col))) return false;
        if (howManyThisNumberInThisRow(candidateTwoDArr, row, number) != 0) return false;
        if (howManyThisNumberInThisCol(candidateTwoDArr, col, number) != 0) return false;
        return true;
    }

    public static int searchEasySectionToSolve(Element[][] candidateTwoDArr) {
        int minSection = 1;
        for (int i = 0; i < 9; i++) {
            if (howManyThisNumberInThisSection(candidateTwoDArr, i + 1, 0) == 1) return i + 1;
            if (howManyThisNumberInThisSection(candidateTwoDArr, i + 1, 0) == 0) continue;
            if ((howManyThisNumberInThisSection(candidateTwoDArr, i + 1, 0) < howManyThisNumberInThisSection(candidateTwoDArr, minSection, 0)) ||
                    howManyThisNumberInThisSection(candidateTwoDArr, minSection, 0) == 0)
                minSection = i + 1;
        }
        return minSection;
    }

    public static boolean couldBeHereInThisSection(Element[][] candidateTwoDArr, int row, int col, int number) {
        if (!isHereZero(candidateTwoDArr, row, col)) return false;
        int section = whatSectionIsThisSpot(candidateTwoDArr, row, col);
        if (howManyThisNumberInThisSection(candidateTwoDArr, section, number) == 0) return true;
        return false;
    }

    public static boolean isHereZero(Element[][] candidateTwoDArr, int row, int col) {
        if (candidateTwoDArr[row - 1][col - 1].getConfirmedElement() == 0) return true;
        return false;
    }

    public static boolean isHereThisNumber(Element[][] candidateTwoDArr, int row, int col, int number) {
        if (candidateTwoDArr[row - 1][col - 1].getConfirmedElement() == number) return true;
        else return false;
    }

    public static boolean isHereUpperRowSection(Element[][] twoDArr, int row) {
        if (0 < row && row <= twoDArr.length / 3) return true;
        return false;
    }

    public static boolean isHereMiddleRowSection(Element[][] candidateTwoDArr, int row) {
        if (candidateTwoDArr.length / 3 < row && row <= 2 * (candidateTwoDArr.length / 3)) return true;
        return false;
    }

    public static boolean isHereLowerRowSection(Element[][] candidateTwoDArr, int row) {
        if (2 * (candidateTwoDArr.length / 3) < row && row <= 3 * (candidateTwoDArr.length / 3))
            return true;
        return false;
    }

    public static boolean isHereLeftColSection(Element[][] candidateTwoDArr, int col) {
        if (0 < col && col <= candidateTwoDArr[0].length / 3)
            return true;
        return false;
    }

    public static boolean isHereMiddleColSection(Element[][] candidateTwoDArr, int col) {
        if (candidateTwoDArr[0].length / 3 < col && col <= 2 * (candidateTwoDArr[0].length / 3))
            return true;
        return false;
    }

    public static boolean isHereRightColSection(Element[][] candidateTwoDArr, int col) {
        if (2 * (candidateTwoDArr[0].length / 3) < col && col <= 3 * (candidateTwoDArr[0].length / 3))
            return true;
        return false;
    }

    public static boolean inTheArrayBoundary(Element[][] candidateTwoDArr, int row, int col) {
        if (row < 1 || candidateTwoDArr[0].length < row) return false;
        if (col < 1 || candidateTwoDArr.length < col) return false;
        return true;
    }

    public static boolean isHereThisCandidate(Element[][] candidateTwoDArr, int row, int col, int number) {
        if (!inTheArrayBoundary(candidateTwoDArr, row, col)) return false;
        if (candidateTwoDArr[row - 1][col - 1].getCandidates() == null) return false;
        if (candidateTwoDArr[row - 1][col - 1].getCandidates()[number - 1] == 0) return false;
        return true;
    }

    public static boolean isHereConfirmed(Element[][] candidateTwoDArr, int row, int col) {
        if (!inTheArrayBoundary(candidateTwoDArr, row, col)) return false;
        if (candidateTwoDArr[row - 1][col - 1].getConfirmedElement() != 0) return true;
        // singleCandidate 메소드 작성해서 후보자 수가 하나 남았을때 처리해서 true 반환하도록 기능 확장
        return false;
    }

    public static void candidateRemoval(Element element, int number) {
        if (9 < number || number < 1) return;
        if (element.getConfirmedElement() != 0) return;
        if (element.getCandidates()[number - 1] != 0) {
            element.getCandidates()[number - 1] = 0;
            element.decreaseNumOfCandidates();
        }
    }

    public static void rowCandidateRemoval(Element[][] candidateTwoDArr, int row) {
        for (int i = 0; i < candidateTwoDArr[row - 1].length; i++) {
            if (isHereConfirmed(candidateTwoDArr, row, i + 1)) {
                for (int j = 0; j < candidateTwoDArr[row - 1].length; j++) {
                    candidateRemoval(candidateTwoDArr[row - 1][j], candidateTwoDArr[row - 1][i].getConfirmedElement());
                }
            }
        }
    }

    public static void colCandidateRemoval(Element[][] candidateTwoDArr, int col) {
        for (int i = 0; i < candidateTwoDArr.length; i++) {
            if (isHereConfirmed(candidateTwoDArr, i + 1, col)) {
                for (int j = 0; j < candidateTwoDArr.length; j++) {
                    candidateRemoval(candidateTwoDArr[j][col - 1], candidateTwoDArr[i][col - 1].getConfirmedElement());
                }
            }
        }
    }

    public static boolean transformSingleCandidateToConfirmedElement( Element element ) {

        if ( element.getNumOfCandidates() == 1 ) {
            for ( int i = 0; i < element.getCandidates().length; i ++ ) {
                if ( element.getCandidates()[i] != 0 ) {
                    element.setConfirmedElement( i + 1 );
                    return true;
                }
            }
        }
        return false;
    }



// TODO solveSingleCandidate
// TODO solveHiddenSingleCandidate



}



