package sudoku;

public class SolveSingleCandidate extends JuniorExplanation {

    public static void rowSolveSingleCandidate(Problem problem) {
        for (int row = 0; row < problem.getCandidateBoard().length; row++) {
            rowCandidateRemoval(problem.getCandidateBoard(), row + 1);
            rowTransformSingleCandidtateToConfirmedElement(problem, row + 1);
        }
    }

    public static void colSolveSingleCandidate(Problem problem) {
        for (int col = 0; col < problem.getCandidateBoard()[0].length; col++) {
            colCandidateRemoval(problem.getCandidateBoard(), col + 1);
            colTransformSingleCandidateToConfirmedElement(problem, col + 1);
        }
    }

    public static void sectionSolveSingleCandidate(Problem problem) {
        for (int section = 1; section <= 9; section++) {
            sectionCandidateRemoval(problem, section);
            sectionTransformSingleCandidateToConfirmedElement(problem, section);
        }
    }

    public static void solveSingleCandidate(Problem problem) {
        rowSolveSingleCandidate(problem);
        colSolveSingleCandidate(problem);
        sectionSolveSingleCandidate(problem);
    }

}
