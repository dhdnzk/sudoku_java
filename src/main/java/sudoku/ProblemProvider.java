package sudoku;

class ProblemProvider <E> {

    private static int READ_PROBLEM_FROM_TEXTFILE = 0;
    private static int READ_PROBLEM_FROM_STRING = 1;
    private static int READ_PROBLEM_FROM_ONE_DEM_ARRAY = 2;
    private static int READ_PROBLEM_FROM_TWO_DEM_ARRAY = 3;

    private static ProblemProvider problemProvider = null;

    private int[][] gameBoard;

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

    private void setGameBoard(E e) {
        // FIXME : 제네릭스 타입 확인 후에 루틴 분기하는 코드 작성 요

        if (e.getClass().getName().equals("Java.lang.String")) {
            setGameBoard(((String) e));
        }
        else if (e.getClass().getName().equals("[I")) {
            setGameBoard(((int[]) e));
        }
        else if (e.getClass().getName().equals("[[I")) {
            setGameBoard(((int[][]) e));
        }

//            String str = "a";
//            int[] iArr = new int[2];
//            int[][] iArr2 = new int[2][2];
//
//            setGameBoard(str);
//            setGameBoard(iArr);
//            setGameBoard(iArr2);

    }

    private void setGameBoard(String str) {

        int[][] tmp = new int[9][9];

        int j = 0;
        for(int i = 0; i < str.length(); i ++) {
            if(i%9 == 0) {
                j++;
            }
            tmp[j][i%9] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        this.gameBoard = tmp;
    }

    private void setGameBoard(int[] ary){

        int[][] tmp = new int[9][9];

        int j = 0;
        for(int i = 0; i < ary.length; i ++) {
            if(i%9 == 0) {
                j++;
            }
            tmp[j][i%9] = ary[i];
        }
        this.gameBoard = tmp;
    }

    private void setGameBoard(int[][] ary){
        this.gameBoard = ary;
    }

    int[][] getGameBoard() {
        return this.gameBoard;
    }

    int[][] getNewGameBoard(E e) {

        setGameBoard(e);

        return getGameBoard();
    }


}


