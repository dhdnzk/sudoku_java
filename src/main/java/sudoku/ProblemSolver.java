package sudoku;

import java.io.IOException;

/**
 * 인스턴스가 생성될 때 매개변수로 문제를 제공받고, 제공받은 문제를 풀어나가는 클래스
 * 인스턴스를 생성할때 파일명을 입력받거나, int[], int[][]형 데이터를 매개변수로 받는다.
 *
 */
public class ProblemSolver {

    private GameBoardElement[][] gameBoard;
    private int numOfZeroOnGameBoard;
    private JRSolveSingleCandidate jrSolveSingleCandidate;
    private JRSolveHiddenSingleCandidate jrSolveHiddenSingleCandidate;

    ProblemSolver(String fileName) throws IOException {

        int[][] tmpGameBoard = ProblemProvider.getInstance()
                .getGameBoardByFileName(fileName);
        resetGameBoard(tmpGameBoard);
        checkNumOfZeroOnGameBoard();
        jrSolveSingleCandidate = JRSolveSingleCandidate.getInstance();
        jrSolveHiddenSingleCandidate = JRSolveHiddenSingleCandidate.getInstance();
    }

    ProblemSolver(int[] oneDimArray) {
        setGameBoard(ProblemProvider.getInstance().setNewGameBoard(oneDimArray));
    }

    ProblemSolver(int[][] twoDimArray) {
        setGameBoard(ProblemProvider.getInstance().setNewGameBoard(twoDimArray));
    }

    int[][] solve() {
        int counter = 0;
        while(numOfZeroOnGameBoard != 0) {
            JuniorSolve();
            SeniorSolve();
            counter ++;
            if(counter > 81) {
                break;
            }
        }
        return extractSimpleBoardFromElementGameBoard();
    }

    private void JuniorSolve() {
        jrSolveSingleCandidate.solve(this);
        jrSolveHiddenSingleCandidate.solve(this);
    }

    private void SeniorSolve() {
        // TODO 고급 풀이법 구현하기
    }

    private int[][] extractSimpleBoardFromElementGameBoard() {
        int[][] tmpAry = new int[9][9];
        for(int i = 0; i < this.getGameBoard().length; i ++) {
            for(int j = 0; j < this.getGameBoard()[i].length; j ++) {
                tmpAry[i][j] = getGameBoard()[i][j].getConfirmedElement();
            }
        }
        return tmpAry;
    }

    private void resetGameBoard(int[][] board) {
        if(this.gameBoard == null) {
            this.gameBoard = new GameBoardElement[9][9];
            for (int i=0; i<9; i++) {
                for (int j = 0; j < 9; j++) {
                    this.gameBoard[i][j] = new GameBoardElement();
                }
            }
        }
        setGameBoard(board);
    }

    private void setGameBoard(int[][] board) {
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[i].length; j++) {
                getGameBoard()[i][j].setConfirmedElement(board[i][j]);
            }
        }
    }

    private void checkNumOfZeroOnGameBoard() {

        int counter = 0;
        for(GameBoardElement[] eAry : this.gameBoard) {

            for (GameBoardElement e : eAry) {
                if(e.getConfirmedElement() == 0) {
                    counter ++;
                }
            }
        }
        this.numOfZeroOnGameBoard = counter;
    }

    void minusOneNumOfZero(){
        this.numOfZeroOnGameBoard --;
    }

    GameBoardElement[][] getGameBoard() {
        return this.gameBoard;
    }

}
