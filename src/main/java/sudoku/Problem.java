package sudoku;

public class Problem {
    int numOfZero;
    private Element[][] candidateBoard;

    Problem(int[][] simpleBoard) {
        this.numOfZero = 81;
        this.candidateBoard = matchSimpleBoardToCandidateBoard(simpleBoard);
    }

    public Element[][] matchSimpleBoardToCandidateBoard(int[][] simpleBoard) {
        Element[][] tmp = new Element[9][9];
        for (int row = 0; row < simpleBoard.length; row++) {
            for (int col = 0; col < simpleBoard[row].length; col++) {
                tmp[row][col] = new Element();
                tmp[row][col].setConfirmedElement(simpleBoard[row][col]);
                if (tmp[row][col].getConfirmedElement() != 0) this.numOfZero--;
            }
        }
        return tmp;
    }

    public int getNumOfZero() {
        return this.numOfZero;
    }

    public Element[][] getCandidateBoard() {
        return this.candidateBoard;
    }

    public void showState() {

        for (int i = 0; i < 100; i ++ ) {
            System.out.println("");
        }

        for (int row = 0; row < this.candidateBoard.length; row++) {
            if ( row % 3 == 0 && row > 1 )
                System.out.println( "━━━━━━━━━━━━━━━━" );
            for (int col = 0; col < this.candidateBoard[row].length; col++) {
                if ( col % 3 == 0 && col > 1 )
                    System.out.print( "┃ " );
                if (candidateBoard[row][col].getConfirmedElement() != 0) {
                    System.out.print( candidateBoard[row][col].getConfirmedElement() + " " );
                }
                else
                    System.out.print("  ");
            }
            System.out.println("");
        }
        System.out.println("\n\n");
        try {
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

}


class Element {

    private int[] candidates;
    private int confirmedElement;
    private int numOfCandidates;

    Element () {
        this.candidates = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.confirmedElement = 0;
        this.numOfCandidates = 9;
    }

    public int[] getCandidates () {
        return this.candidates;
    }

    public int getConfirmedElement() {
        return this.confirmedElement;
    }

    public int getNumOfCandidates () {
        return this.numOfCandidates;
    }

    public int removeACandidate( int number ) {
        this.candidates[number - 1] = 0;
        decreaseNumOfCandidates();
        return number;
    }

    public void setConfirmedElement( int number ) {
        if (1 <= number && number <= 9) {
            this.confirmedElement = number;
            this.candidates = null;
            this.numOfCandidates = 0;
        }
    }

    public int decreaseNumOfCandidates() {
        this.numOfCandidates --;
        return this.numOfCandidates;
    }
}





