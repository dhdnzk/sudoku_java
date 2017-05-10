package sudoku;

abstract class JuniorExplanation {

    abstract void solve(ProblemSolver solver);

    void rowCandidateRemoval(GameBoardElement[][]
                                     candidateTwoDArr, int row) {
        for (int i = 0; i < candidateTwoDArr[row - 1].length; i++) {
            if (isHereConfirmed(candidateTwoDArr, row, i + 1)) {
                for (int j = 0; j < candidateTwoDArr[row - 1].length; j++) {
                    candidateRemoval(candidateTwoDArr[row - 1][j], candidateTwoDArr[row - 1][i].getConfirmedElement());
                }
            }
        }
    }

    void colCandidateRemoval(GameBoardElement[][]
                                     candidateTwoDArr, int col) {
        for (int i = 0; i < candidateTwoDArr.length; i++) {
            if (isHereConfirmed(candidateTwoDArr, i + 1, col)) {
                for (GameBoardElement[] aCandidateTwoDArr : candidateTwoDArr) {
                    candidateRemoval(aCandidateTwoDArr[col - 1], candidateTwoDArr[i][col - 1].getConfirmedElement());
                }
            }
        }
    }
    void rowTransformSingleCandidtateToConfirmedElement(ProblemSolver
                                                                solver,
                                                        int row) {
        for (int i = 0; i < solver.getGameBoard()[row - 1].length; i++)
            if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[row - 1][i])) {
                solver.minusOneNumOfZero();
                ScreenOut.showState(solver.getGameBoard());
            }
    }

    void colTransformSingleCandidateToConfirmedElement(ProblemSolver
                                                               solver,
                                                       int col) {
        for (int i = 0; i < solver.getGameBoard().length; i++)
            if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[i][col - 1])) {
                solver.minusOneNumOfZero();
                ScreenOut.showState(solver.getGameBoard());
            }
    }

    // FIXME switch문 간단하게 리펙토링 요망(section별로 case구분하지 않고 간결한 코드로 흐름 분기될 수 있도록)
    void sectionTransformSingleCandidateToConfirmedElement
    (ProblemSolver solver, int section) {
        switch (section) {
            case 1:
                for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                    for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                        if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[row][col])) {
                            solver.minusOneNumOfZero();
                        }
                    }
                }
                break;

            case 2:
                for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                    for (int col = (solver.getGameBoard().length / 3); col <
                            2 * (solver.getGameBoard()[row].length / 3); col++) {
                        if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[row][col])) {
                            solver.minusOneNumOfZero();
                        }
                    }
                }

                break;

            case 3:
                for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                    for (int col = 2 * (solver.getGameBoard().length / 3);
                         col < 3 * (solver.getGameBoard()[row].length / 3); col++) {
                        if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[row][col])) {
                            solver.minusOneNumOfZero();
                        }
                    }
                }
                break;

            case 4:
                for (int row = (solver.getGameBoard().length / 3); row < 2 *
                        (solver.getGameBoard().length / 3); row++) {
                    for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                        if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[row][col])) {
                            solver.minusOneNumOfZero();
                        }
                    }
                }
                break;

            case 5:
                for (int row = (solver.getGameBoard().length / 3); row < 2 *
                        (solver.getGameBoard().length / 3); row++) {
                    for (int col = (solver.getGameBoard().length / 3); col <
                            2 * (solver.getGameBoard()[row].length / 3); col++) {
                        if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[row][col])) {
                            solver.minusOneNumOfZero();
                        }
                    }
                }
                break;

            case 6:
                for (int row = (solver.getGameBoard().length / 3); row < 2 *
                        (solver.getGameBoard().length / 3); row++) {
                    for (int col = 2 * (solver.getGameBoard().length / 3);
                         col < 3 * (solver.getGameBoard()[row].length / 3); col++) {
                        if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[row][col])) {
                            solver.minusOneNumOfZero();
                        }
                    }
                }
                break;

            case 7:
                for (int row = 2 * (solver.getGameBoard().length / 3); row <
                        3 * (solver.getGameBoard().length / 3); row++) {
                    for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                        if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[row][col])) {
                            solver.minusOneNumOfZero();
                        }
                    }
                }
                break;

            case 8:
                for (int row = 2 * (solver.getGameBoard().length / 3); row <
                        3 * (solver.getGameBoard().length / 3); row++) {
                    for (int col = (solver.getGameBoard().length / 3); col <
                            2 * (solver.getGameBoard()[row].length / 3); col++) {
                        if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[row][col])) {
                            solver.minusOneNumOfZero();
                        }
                    }
                }
                break;

            case 9:
                for (int row = 2 * (solver.getGameBoard().length / 3); row <
                        3 * (solver.getGameBoard().length / 3); row++) {
                    for (int col = 2 * (solver.getGameBoard().length / 3);
                         col < 3 * (solver.getGameBoard()[row].length / 3); col++) {
                        if (transformSingleCandidateToConfirmedElement(solver.getGameBoard()[row][col])) {
                            solver.minusOneNumOfZero();
                        }
                    }
                }
                break;
        }
        ScreenOut.showState(solver.getGameBoard());
    }

    // FIXME switch문 간단하게 리펙토링 요망(section별로 case구분하지 않고 간결한 코드로 흐름 분기될 수 있도록)
    void sectionCandidateRemoval(ProblemSolver solver, int section) {
        switch (section) {
            case 1:
                for (int i = 0; i < (solver.getGameBoard().length / 3); i++) {
                    for (int j = 0; j < (solver.getGameBoard()[i].length
                            / 3); j++) {
                        for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                            for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                                candidateRemoval(solver.getGameBoard()
                                        [row][col], solver.getGameBoard()[i][j]
                                        .getConfirmedElement());
                            }
                        }
                    }
                }
                break;

            case 2:
                for (int i = 0; i < (solver.getGameBoard().length / 3); i++) {
                    for (int j = (solver.getGameBoard().length / 3); j < 2 *
                            (solver.getGameBoard()[i].length / 3); j++) {
                        for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                            for (int col = (solver.getGameBoard().length / 3)
                                 ; col < 2 * (solver.getGameBoard()[row].length / 3);
                                 col++) {
                                candidateRemoval(solver.getGameBoard()
                                        [row][col], solver.getGameBoard()[i][j]
                                        .getConfirmedElement());
                            }
                        }
                    }
                }

                break;

            case 3:
                for (int i = 0; i < (solver.getGameBoard().length / 3); i++) {
                    for (int j = 2 * (solver.getGameBoard().length / 3); j <
                            3 * (solver.getGameBoard()[i].length / 3); j++) {
                        for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                            for (int col = 2 * (solver.getGameBoard().length
                                    / 3); col < 3 * (solver.getGameBoard()[row].length /
                                    3); col++) {
                                candidateRemoval(solver.getGameBoard()
                                        [row][col], solver.getGameBoard()[i][j]
                                        .getConfirmedElement());
                            }
                        }
                    }
                }
                break;

            case 4:
                for (int i = (solver.getGameBoard().length / 3); i < 2 *
                        (solver.getGameBoard().length / 3); i++) {
                    for (int j = 0; j < (solver.getGameBoard()[i].length / 3); j++) {
                        for (int row = (solver.getGameBoard().length / 3);
                             row < 2 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                                candidateRemoval(solver.getGameBoard()
                                        [row][col], solver.getGameBoard()[i][j].getConfirmedElement());
                            }
                        }
                    }
                }
                break;

            case 5:
                for (int i = (solver.getGameBoard().length / 3); i < 2 *
                        (solver.getGameBoard().length / 3); i++) {
                    for (int j = (solver.getGameBoard().length / 3); j < 2 *
                            (solver.getGameBoard()[i].length / 3); j++) {
                        for (int row = (solver.getGameBoard().length / 3);
                             row < 2 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = (solver.getGameBoard().length / 3)
                                 ; col < 2 * (solver.getGameBoard()[row].length / 3);
                                 col++) {
                                candidateRemoval(solver.getGameBoard()
                                        [row][col], solver.getGameBoard()[i][j]
                                        .getConfirmedElement());
                            }
                        }
                    }
                }
                break;

            case 6:
                for (int i = (solver.getGameBoard().length / 3); i < 2 *
                        (solver.getGameBoard().length / 3); i++) {
                    for (int j = 2 * (solver.getGameBoard().length / 3); j <
                            3 * (solver.getGameBoard()[i].length / 3); j++) {
                        for (int row = (solver.getGameBoard().length / 3);
                             row < 2 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = 2 * (solver.getGameBoard().length
                                    / 3); col < 3 * (solver.getGameBoard()[row].length /
                                    3); col++) {
                                candidateRemoval(solver.getGameBoard()
                                        [row][col], solver.getGameBoard()[i][j]
                                        .getConfirmedElement());
                            }
                        }
                    }
                }
                break;

            case 7:
                for (int i = 2 * (solver.getGameBoard().length / 3); i < 3 *
                        (solver.getGameBoard().length / 3); i++) {
                    for (int j = 0; j < (solver.getGameBoard()[i].length / 3); j++) {
                        for (int row = 2 * (solver.getGameBoard().length / 3)
                             ; row < 3 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                                candidateRemoval(solver.getGameBoard()
                                        [row][col], solver.getGameBoard()[i][j]
                                        .getConfirmedElement());
                            }
                        }
                    }
                }
                break;

            case 8:
                for (int i = 2 * (solver.getGameBoard().length / 3); i < 3 *
                        (solver.getGameBoard().length / 3); i++) {
                    for (int j = (solver.getGameBoard().length / 3); j < 2 *
                            (solver.getGameBoard()[i].length / 3); j++) {
                        for (int row = 2 * (solver.getGameBoard().length / 3)
                             ; row < 3 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = (solver.getGameBoard().length / 3)
                                 ; col < 2 * (solver.getGameBoard()[row].length / 3);
                                 col++) {
                                candidateRemoval(solver.getGameBoard()
                                        [row][col], solver.getGameBoard()[i][j]
                                        .getConfirmedElement());
                            }
                        }
                    }
                }
                break;

            case 9:
                for (int i = 2 * (solver.getGameBoard().length / 3); i < 3 *
                        (solver.getGameBoard().length / 3); i++) {
                    for (int j = 2 * (solver.getGameBoard().length / 3); j <
                            3 * (solver.getGameBoard()[i].length / 3); j++) {
                        for (int row = 2 * (solver.getGameBoard().length / 3)
                             ; row < 3 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = 2 * (solver.getGameBoard().length
                                    / 3); col < 3 * (solver.getGameBoard()[row].length /
                                    3); col++) {
                                candidateRemoval(solver.getGameBoard()
                                        [row][col], solver.getGameBoard()[i][j]
                                        .getConfirmedElement());
                            }
                        }
                    }
                }
                break;
        }
    }

    /***********************************************************************/
    /************** 여기부터 클래스 내부에서만 사용되는 private method들 **************/
    /***********************************************************************/
    private int howManyThisNumberInThisRow(GameBoardElement[][] candidateTwoDArr,
                                           int row, int number) {
        int numOfNumber = 0;
        for (int i = 0; i < candidateTwoDArr[row - 1].length; i++) {
            if (isHereThisNumber(candidateTwoDArr, row, i + 1, number))
                numOfNumber++;
        }
        return numOfNumber;
    }

    private int howManyThisNumberInThisCol(GameBoardElement[][]
                                                   candidateTwoDArr, int col, int number) {
        int numOfNumber = 0;
        for (int i = 0; i < candidateTwoDArr.length; i++) {
            if (isHereThisNumber(candidateTwoDArr, i + 1, col, number))
                numOfNumber++;
        }
        return numOfNumber;
    }

    // FIXME switch문 간단하게 리펙토링 요망(section별로 case구분하지 않고 간결한 코드로 흐름 분기될 수 있도록)
    private int howManyThisNumberInThisSection(GameBoardElement[][] candidateTwoDArr,
                                               int section, int number) {
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
                for (int i = (candidateTwoDArr.length / 3); i < 2 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = 0; j < (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 5:
                for (int i = (candidateTwoDArr.length / 3); i < 2 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = (candidateTwoDArr.length / 3); j < 2 * (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 6:
                for (int i = (candidateTwoDArr.length / 3); i < 2 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = 2 * (candidateTwoDArr.length / 3); j < 3 * (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 7:
                for (int i = 2 * (candidateTwoDArr.length / 3); i < 3 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = 0; j < (candidateTwoDArr[i].length / 3); j++) {
                        if (candidateTwoDArr[i][j].getConfirmedElement() == number)
                            amountOfNumber++;
                    }
                }
                break;

            case 8:
                for (int i = 2 * (candidateTwoDArr.length / 3); i < 3 * (candidateTwoDArr.length / 3); i++) {
                    for (int j = (candidateTwoDArr.length / 3); j < 2 * (candidateTwoDArr[i].length / 3); j++) {
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

    private boolean isHereZero(GameBoardElement[][] candidateTwoDArr,
                               int row, int col) {
        return candidateTwoDArr[row - 1][col - 1].getConfirmedElement() == 0;
    }

    private boolean isHereThisNumber(GameBoardElement[][] candidateTwoDArr,
                                     int row, int col, int number) {
        return candidateTwoDArr[row - 1][col - 1].getConfirmedElement() == number;
    }

    private boolean isHereUpperRowSection(GameBoardElement[][] twoDArr, int row) {
        return 0 < row && row <= twoDArr.length / 3;
    }

    private boolean isHereMiddleRowSection(GameBoardElement[][]
                                                   candidateTwoDArr, int row) {
        return candidateTwoDArr.length / 3 < row && row <= 2 * (candidateTwoDArr.length / 3);
    }

    private boolean isHereLowerRowSection(GameBoardElement[][]
                                                  candidateTwoDArr, int row) {
        return 2 * (candidateTwoDArr.length / 3) < row && row <= 3 * (candidateTwoDArr.length / 3);
    }

    private boolean isHereLeftColSection(GameBoardElement[][]
                                                 candidateTwoDArr, int col) {
        return 0 < col && col <= candidateTwoDArr[0].length / 3;
    }

    private boolean isHereMiddleColSection(GameBoardElement[][]
                                                   candidateTwoDArr, int col) {
        return candidateTwoDArr[0].length / 3 < col && col <= 2 * (candidateTwoDArr[0].length / 3);
    }

    private boolean isHereRightColSection(GameBoardElement[][]
                                                  candidateTwoDArr, int col) {
        return 2 * (candidateTwoDArr[0].length / 3) < col && col <= 3 * (candidateTwoDArr[0].length / 3);
    }

    private boolean isHereThisCandidate(GameBoardElement element, int number) {
        return element.getCandidates() != null && element.getCandidates()[number - 1] != 0;
    }

    private boolean isHereConfirmed(GameBoardElement[][]
                                            candidateTwoDArr, int row, int col) {
        if (!inTheArrayBoundary(candidateTwoDArr, row, col)) return false;
        if (candidateTwoDArr[row - 1][col - 1].getConfirmedElement() != 0) return true;
        // singleCandidate 메소드 작성해서 후보자 수가 하나 남았을때 처리해서 true 반환하도록 기능 확장
        return false;
    }

    private int whatSectionIsThisSpot(GameBoardElement[][]
                                              candidateTwoDArr, int row, int col) {
        int section = 0;
        if (!(inTheArrayBoundary(candidateTwoDArr, row, col))) return -1;
        if (isHereUpperRowSection(candidateTwoDArr, row)) section++;
        if (isHereMiddleRowSection(candidateTwoDArr, row)) section += 4;
        if (isHereLowerRowSection(candidateTwoDArr, row)) section += 7;
        if (isHereMiddleColSection(candidateTwoDArr, col)) section++;
        if (isHereRightColSection(candidateTwoDArr, col)) section += 2;
        return section;
    }

    private boolean inTheArrayBoundary(GameBoardElement[][]
                                               candidateTwoDArr, int row, int col) {
        if (row < 1 || candidateTwoDArr[0].length < row) return false;
        return !(col < 1 || candidateTwoDArr.length < col);
    }

    private void candidateRemoval(GameBoardElement element, int number) {
        if (9 < number || number < 1) return;
        if (element.getConfirmedElement() != 0) return;
        if (element.getCandidates()[number - 1] != 0) {
            element.getCandidates()[number - 1] = 0;
            element.decreaseNumOfCandidates();
        }
    }

    private boolean transformSingleCandidateToConfirmedElement
            (GameBoardElement element) {
        if (element.getNumOfCandidates() == 1) {
            for (int i = 0; i < element.getCandidates().length; i++) {
                if (element.getCandidates()[i] != 0) {
                    element.setConfirmedElement(i + 1);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canBeCenterOfThisCross(GameBoardElement[][]
                                                   candidateTwoDArr, int row, int col, int number) {
        if (!(isHereZero(candidateTwoDArr, row, col))) return false;
        if (howManyThisNumberInThisRow(candidateTwoDArr, row, number) != 0) return false;
        if (howManyThisNumberInThisCol(candidateTwoDArr, col, number) != 0) return false;
        return true;
    }

    private int searchEasySectionToSolve(GameBoardElement[][]
                                                 candidateTwoDArr) {
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

    private boolean couldBeHereInThisSection(GameBoardElement[][]
                                                     candidateTwoDArr, int row, int col, int number) {
        if (!isHereZero(candidateTwoDArr, row, col)) return false;
        int section = whatSectionIsThisSpot(candidateTwoDArr, row, col);
        if (howManyThisNumberInThisSection(candidateTwoDArr, section, number) == 0) return true;
        return false;
    }

}
// TODO 후보들 중에서 숨겨진 유일한 후보가 존재할 때 : solveHiddenSingleCandidate
// TODO 리펙토링 하고싶은 요소들 : showState 메소드를 메인메소드에서 호출하면, 여러 단계를 건너뛰어서 듬성듬성 보여주는 문제, switch문 간결화 문제
