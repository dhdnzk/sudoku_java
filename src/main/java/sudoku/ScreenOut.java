package sudoku;

/**
 * Created by Loui on 2017. 5. 1..
 *
 */
class ScreenOut {

    static void showBoard(int[][] board) {

        System.out.println("------------------------------------");
        for(int i = 0; i < 9; i ++) {
            System.out.print("|");
            for(int j = 0; j < 9; j ++) {
                if(board[i][j] == 0) {
                    System.out.print("\t");
                }
                else {
                    System.out.print(" " + board[i][j] + "\t");
                }
                if((j+1)%3 == 0)
                    System.out.print("|");
            }
            System.out.println();
            if((i+1)%3 == 0)
                System.out.println("------------------------------------");
        }
    }
}
