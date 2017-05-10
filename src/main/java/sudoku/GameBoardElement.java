package sudoku;

/**
 * 후보자 개념이 도입된 게임판의 원소 한개.
 * <code>ProblemSolver</code> 클래스의 인스턴스가 생성될 때 이 원소를 9x9 배열로 생성한 뒤,
 * 그 원소들을 활용해서 문제를 풀어나간다
 *
 */
class GameBoardElement {

    private int[] candidates;
    private int confirmedElement;
    private int numOfCandidates;

    GameBoardElement () {
        this.candidates = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.confirmedElement = 0;
        this.numOfCandidates = 9;
    }

    int[] getCandidates () {
        return this.candidates;
    }

    int getConfirmedElement() {
        return this.confirmedElement;
    }

    int getNumOfCandidates () {
        return this.numOfCandidates;
    }

    int removeACandidate(int number) {
        this.candidates[number - 1] = 0;
        decreaseNumOfCandidates();
        return number;
    }

    void setConfirmedElement(int number) {
        if (1 <= number && number <= 9) {
            this.confirmedElement = number;
            this.candidates = null;
            this.numOfCandidates = 0;
        }
    }

    int decreaseNumOfCandidates() {
        this.numOfCandidates --;
        return this.numOfCandidates;
    }
}
