package sudoku;

import java.io.*;

/**
 *
 * 다양한 방식으로 문제를 입력받은 뒤, int[][]형 배열로 게임판을 생성하는 클래스.
 * 싱글턴 패턴.
 * @param <E> : 제네릭을 통해서 문제를 입력받을 때 데이터타입을 판별하여 자동으로 메소드를 호출한다.
 */
public class ProblemProvider <E> {

    private static ProblemProvider problemProvider = null;

    private int[][] gameBoard;

    /**
     *
     * Singleton pattern
     */
    static ProblemProvider getInstance() {
        if(problemProvider == null) {
            setProblemProvider(new ProblemProvider());
        }
        return problemProvider;
    }

    public ProblemProvider() {
        gameBoard = new int[9][9];
    }

    private static void setProblemProvider(ProblemProvider problemProvider) {
        ProblemProvider.problemProvider = problemProvider;
    }

    /**
     *
     * 매개변수를 instanceof를 이용해서 형변환 해준 뒤,
     * 이를 매개변수로 하는 setGameBoard 메소드를 호출하는 메소드.
     * @param e : 데이터타입은 문자열, int[], int[][]중 한가지로만 받는다.
     */
    private void setGameBoard(E e) {

        if (e instanceof String) {
            setGameBoard((String)e);
        }

        else if (e instanceof int[]) {
            setGameBoard(((int[]) e));
        }

        else if (e instanceof int[][]) {
            setGameBoard(((int[][]) e));
        }
    }

    /**
     *
     * 숫자로 이루어진 문자열을 하나씩 잘라서 배열안에 배치해주는 메소드.
     * @param trimmedStr : 공백, 줄바꿈 등이 제거되고 81개의 숫자만으로 이루어진 문자열을 매개변수로 받는다.
     */
    private void setGameBoard(String trimmedStr) {

        int j = -1;
        for(int i = 0; i < trimmedStr.length(); i ++) {
            if(i%9 == 0) {
                j++;
            }
            gameBoard[j][i%9] = Integer.parseInt(String.valueOf(trimmedStr
                    .charAt(i)));
        }
    }

    /**
     *
     * @param ary : int[]형 매개변수를 받아서 <code>gameBoard<code/> 변수에 채워준다.
     */
    private void setGameBoard(int[] ary){

        int[][] tmp = new int[9][9];

        int j = -1;
        for(int i = 0; i < ary.length; i ++) {
            if(i%9 == 0) {
                j++;
            }
            tmp[j][i%9] = ary[i];
        }
        this.gameBoard = tmp;
    }

    /**
     *
     * @param ary : <code>gameBoard</code> 변수와 데이터타입이 같으므로 바로 대입해준다.
     */
    private void setGameBoard(int[][] ary){
        this.gameBoard = ary;
    }

    int[][] setNewGameBoard(E e) {

        setGameBoard(e);

        return getCurGameBoard();
    }

    private int[][] getCurGameBoard() {
        return this.gameBoard;
    }

    /**
     *
     * @param fileName : 프로젝트 홈을 루트로, "./sudokuProblems/"디렉토리상에 있는 문제들을 읽어들임
     * @throws IOException : throws IOException
     */
    int[][] getGameBoardByFileName(String fileName) throws IOException {

        BufferedReader bufferedReader
                = new BufferedReader
                (new FileReader("./sudokuProblems/" + fileName));
        String returnString = "";
        String tmpString = bufferedReader.readLine();

        while(tmpString != null) {
            returnString = returnString + tmpString;
            tmpString = bufferedReader.readLine();
        }

        setGameBoard(returnString.replaceAll(" ",""));
        return getCurGameBoard();
    }

}

