package sudoku;

import java.io.*;

class ProblemProvider <E> {

    private static ProblemProvider problemProvider = null;

    private int[][] gameBoard;

    /**
     * Singleton pattern
     */
    static ProblemProvider getInstance() {
        if(problemProvider == null) {
            setProblemProvider(new ProblemProvider());
        }
        return problemProvider;
    }

    private ProblemProvider() {
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
            return;
        }

        if (e instanceof int[]) {
            setGameBoard(((int[]) e));
            return;
        }

        if (e instanceof int[][]) {
            setGameBoard(((int[][]) e));
            return;
        }

    }

    /**
     *
     * @param trimmedStr : 공백, 줄바꿈 등이 제거되고 81개의 숫자만으로 이루어진 문자열을 매개변수로 받는다.
     */
    private void setGameBoard(String trimmedStr) {

        int[][] tmp = new int[9][9];

        int j = -1;
        for(int i = 0; i < trimmedStr.length(); i ++) {
            if(i%9 == 0) {
                j++;
            }
            tmp[j][i%9] = Integer.parseInt(String.valueOf(trimmedStr.charAt(i)));
        }
        this.gameBoard = tmp;
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

    int[][] getGameBoard() {
        return this.gameBoard;
    }

    int[][] setNewGameBoard(E e) {

        setGameBoard(e);

        return getGameBoard();
    }

    /**
     *
     * @param fileName : "./sudokuProblems/"디렉토리상에 있는 문제들을 읽어들임
     * @throws IOException
     */
    void getGameBoardByFilePath(String fileName) throws IOException {

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
    }

}

