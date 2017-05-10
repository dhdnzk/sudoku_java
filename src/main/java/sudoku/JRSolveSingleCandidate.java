package sudoku;

class JRSolveSingleCandidate extends JuniorExplanation {

    private static JRSolveSingleCandidate jrSolveSingleCandidate;

    private JRSolveSingleCandidate() {}

    static JRSolveSingleCandidate getInstance() {
        if(jrSolveSingleCandidate == null) {
            jrSolveSingleCandidate = new JRSolveSingleCandidate();
        }
        return jrSolveSingleCandidate;
    }

    private void rowSolveSingleCandidate(ProblemSolver solver) {
        for (int row = 0; row < solver.getGameBoard().length; row++) {
            rowCandidateRemoval(solver.getGameBoard(), row + 1);
            rowTransformSingleCandidtateToConfirmedElement(solver, row + 1);
        }
    }

    private void colSolveSingleCandidate(ProblemSolver solver) {
        for (int col = 0; col < solver.getGameBoard()[0].length; col++) {
            colCandidateRemoval(solver.getGameBoard(), col + 1);
            colTransformSingleCandidateToConfirmedElement(solver, col + 1);
        }
    }

    private void sectionSolveSingleCandidate(ProblemSolver solver) {
        for (int section = 1; section <= 9; section++) {
            sectionCandidateRemoval(solver, section);
            sectionTransformSingleCandidateToConfirmedElement(solver, section);
        }
    }

    void solve(ProblemSolver solver) {
        rowSolveSingleCandidate(solver);
        colSolveSingleCandidate(solver);
        sectionSolveSingleCandidate(solver);
    }

}
