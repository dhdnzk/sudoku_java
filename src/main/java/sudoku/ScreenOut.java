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

    static void showBoard(GameBoardElement[][] board) {

        System.out.println("------------------------------------");
        for(int i = 0; i < 9; i ++) {
            System.out.print("|");
            for(int j = 0; j < 9; j ++) {
                if(board[i][j].getConfirmedElement() == 0) {
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

    static void showState(GameBoardElement[][] gameBoard) {

        for (int row = 0; row < gameBoard.length; row++) {
            if ( row % 3 == 0 && row > 1 )
                System.out.println( "━━━━━━━━━━━━━━━━" );
            for (int col = 0; col < gameBoard[row].length; col++) {
                if ( col % 3 == 0 && col > 1 )
                    System.out.print( "┃ " );
                if (gameBoard[row][col].getConfirmedElement() != 0) {
                    System.out.print( gameBoard[row][col].getConfirmedElement() + " " );
                }
                else
                    System.out.print("  ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }

    static void showState(int[][] gameBoard) {

        for (int row = 0; row < gameBoard.length; row++) {
            if ( row % 3 == 0 && row > 1 )
                System.out.println( "━━━━━━━━━━━━━━━━" );
            for (int col = 0; col < gameBoard[row].length; col++) {
                if ( col % 3 == 0 && col > 1 )
                    System.out.print( "┃ " );
                if (gameBoard[row][col] != 0) {
                    System.out.print( gameBoard[row][col] + " " );
                }
                else
                    System.out.print("  ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }

    static void clearScreen() {

        for (int i = 0; i < 100; i ++ ) {
            System.out.println("");
        }
    }

}
