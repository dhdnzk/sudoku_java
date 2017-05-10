package sudoku;

class JRSolveHiddenSingleCandidate extends JuniorExplanation {

    private static JRSolveHiddenSingleCandidate jrSolveHiddenSingleCandidate;

    private JRSolveHiddenSingleCandidate() {}

    static JRSolveHiddenSingleCandidate getInstance() {
        if(jrSolveHiddenSingleCandidate == null) {
            jrSolveHiddenSingleCandidate = new JRSolveHiddenSingleCandidate();
        }
        return jrSolveHiddenSingleCandidate;
    }

    void solve ( ProblemSolver solver ) {
        rowSolveHiddenSingleCandidate(solver);
        colSolveHiddenSingleCandidate(solver);
        sectionSolveHiddenSingleCandidate(solver);
    }

    private boolean transformThisCandidateToConfirmedElement ( GameBoardElement
                                                                      element, int candidate ) {
        if ( element.getCandidates() == null ) return false;
        if ( element.getCandidates()[candidate - 1] == candidate  ) {
            element.setConfirmedElement( candidate );
            return true;
        }
        return false;
    }

    private int rowSearchHiddenSingleCandidate(ProblemSolver solver, int row) {
        rowCandidateRemoval( solver.getGameBoard(), row );
        for ( int number = 1; number <= 9; number ++ ) {
            int candidateCount = 0;
            for (int col = 0; col < 9; col ++ ) {
                if ( solver.getGameBoard()[ row - 1][ col ].getConfirmedElement() == 0 &&
                        solver.getGameBoard()[ row - 1][ col ].getCandidates()[number -
                                1] != 0 )
                   candidateCount ++;
                if ( candidateCount > 1 )
                    break;
            }
            if ( candidateCount == 1 )
                return number;
        }
        return 0;
    }

    private void rowSolveHiddenSingleCandidate(ProblemSolver solver) {
        for ( int row = 1; row <= solver.getGameBoard().length; row ++ ) {
            int hiddenSingleCandidate = rowSearchHiddenSingleCandidate( solver,
                    row );
            if ( hiddenSingleCandidate != 0 ) {
                for ( int col = 1; col < solver.getGameBoard()[row -1].length; col ++ ) {
                    if ( transformThisCandidateToConfirmedElement( solver
                            .getGameBoard()[row - 1][col - 1], hiddenSingleCandidate ) ) {
                        solver.minusOneNumOfZero();
                        return;
                    }

                }
            }
        }
    }

    private int colSearchHiddenSingleCandidate(ProblemSolver solver, int col) {
        colCandidateRemoval( solver.getGameBoard(), col );
        for ( int number = 1; number <= 9; number ++ ) {
            int candidateCount = 0;
            for (int row = 0; row < 9; row ++ ) {
                if (solver.getGameBoard()[ row ][ col - 1 ].getConfirmedElement() == 0 &&
                        solver.getGameBoard()[ row ][ col - 1 ].getCandidates()[number -
                                1] != 0)
                    candidateCount ++;
                if ( candidateCount > 1 )
                    break;
            }
            if ( candidateCount == 1 )
                return number;
        }
        return 0;
    }

    private void colSolveHiddenSingleCandidate(ProblemSolver solver) {
        for ( int col = 1; col <= solver.getGameBoard()[0].length; col ++ ) {
            int hiddenSingleCandidate = colSearchHiddenSingleCandidate(solver,
                    col);
            if ( hiddenSingleCandidate != 0 ) {
                for ( int row = 1; row < solver.getGameBoard().length; row ++ ) {
                    if( transformThisCandidateToConfirmedElement( solver
                            .getGameBoard()[row - 1][col - 1], hiddenSingleCandidate ) ) {
                        solver.minusOneNumOfZero();
                        return;
                    }
                }
            }
        }
    }

    // FIXME switch문 간단하게 리펙토링 요망(section별로 case구분하지 않고 간결한 코드로 흐름 분기될 수 있도록)
    private int sectionSearchHiddenSingleCandidate(ProblemSolver solver,
                                                          int section ) {
        sectionCandidateRemoval(solver, section );
        int candidateCount = 0;
        switch ( section ) {
            case 1:
                for (int number = 1; number <= 9; number++) {
                    for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                        for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                            if (solver.getGameBoard()[row][col].getConfirmedElement() == 0 && solver.getGameBoard()[row][col].getCandidates()[number - 1] != 0)
                                candidateCount++;
                            if (candidateCount > 1)
                                break;
                        }
                        if ( candidateCount > 1 )
                            break;
                    }
                    if (candidateCount == 1)
                        return number;
                }
                break;

            case 2:
                for (int number = 1; number <= 9; number++) {
                    for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                        for (int col = (solver.getGameBoard().length / 3); col < 2 * (solver.getGameBoard()[row].length / 3); col++) {
                            if (solver.getGameBoard()[row][col].getConfirmedElement() == 0 && solver.getGameBoard()[row][col].getCandidates()[number - 1] != 0)
                                candidateCount++;
                            if (candidateCount > 1)
                                break;
                        }
                        if ( candidateCount > 1 )
                            break;
                    }

                    if (candidateCount == 1)
                        return number;
                }

                break;

            case 3:
                for (int number = 1; number <= 9; number++) {
                    for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                        for (int col = 2 * (solver.getGameBoard().length / 3); col < 3 * (solver.getGameBoard()[row].length / 3); col++) {
                            if (solver.getGameBoard()[row][col].getConfirmedElement() == 0 && solver.getGameBoard()[row][col].getCandidates()[number - 1] != 0)
                                candidateCount++;
                            if (candidateCount > 1)
                                break;
                        }
                        if ( candidateCount > 1 )
                            break;
                    }
                    if (candidateCount == 1)
                        return number;
                }
                break;

            case 4:
                for (int number = 1; number <= 9; number++) {
                    for (int row = (solver.getGameBoard().length / 3); row < 2 * (solver.getGameBoard().length / 3); row++) {
                        for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                            if (solver.getGameBoard()[row][col].getConfirmedElement() == 0 && solver.getGameBoard()[row][col].getCandidates()[number - 1] != 0)
                                candidateCount++;
                            if (candidateCount > 1)
                                break;
                        }
                        if ( candidateCount > 1 )
                            break;
                    }
                    if (candidateCount == 1)
                        return number;
                }
                break;

            case 5:
                for (int number = 1; number <= 9; number++) {
                    for (int row = (solver.getGameBoard().length / 3); row < 2 * (solver.getGameBoard().length / 3); row++) {
                        for (int col = (solver.getGameBoard().length / 3); col < 2 * (solver.getGameBoard()[row].length / 3); col++) {
                            if (solver.getGameBoard()[row][col].getConfirmedElement() == 0 && solver.getGameBoard()[row][col].getCandidates()[number - 1] != 0)
                                candidateCount++;
                            if (candidateCount > 1)
                                break;
                        }
                        if ( candidateCount > 1 )
                            break;
                    }
                    if (candidateCount == 1)
                        return number;
                }
                break;

            case 6:
                for (int number = 1; number <= 9; number++) {
                    for (int row = (solver.getGameBoard().length / 3); row < 2 * (solver.getGameBoard().length / 3); row++) {
                        for (int col = 2 * (solver.getGameBoard().length / 3); col < 3 * (solver.getGameBoard()[row].length / 3); col++) {
                            if (solver.getGameBoard()[row][col].getConfirmedElement() == 0 && solver.getGameBoard()[row][col].getCandidates()[number - 1] != 0)
                                candidateCount++;
                            if (candidateCount > 1)
                                break;
                        }
                        if ( candidateCount > 1 )
                            break;
                    }
                    if (candidateCount == 1)
                        return number;
                }
                break;

            case 7:
                for (int number = 1; number <= 9; number++) {
                    for (int row = 2 * (solver.getGameBoard().length / 3); row < 3 * (solver.getGameBoard().length / 3); row++) {
                        for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                            if (solver.getGameBoard()[row][col].getConfirmedElement() == 0 && solver.getGameBoard()[row][col].getCandidates()[number - 1] != 0)
                                candidateCount++;
                            if (candidateCount > 1)
                                break;
                        }
                        if ( candidateCount > 1 )
                            break;
                    }
                    if (candidateCount == 1)
                        return number;
                }
                break;

            case 8:
                for (int number = 1; number <= 9; number++) {
                    for (int row = 2 * (solver.getGameBoard().length / 3); row < 3 * (solver.getGameBoard().length / 3); row++) {
                        for (int col = (solver.getGameBoard().length / 3); col < 2 * (solver.getGameBoard()[row].length / 3); col++) {
                            if (solver.getGameBoard()[row][col].getConfirmedElement() == 0 && solver.getGameBoard()[row][col].getCandidates()[number - 1] != 0)
                                candidateCount++;
                            if (candidateCount > 1)
                                break;
                        }
                        if ( candidateCount > 1 )
                            break;
                    }
                    if (candidateCount == 1)
                        return number;
                }
                break;

            case 9:
                for (int number = 1; number <= 9; number++) {
                    for (int row = 2 * (solver.getGameBoard().length / 3); row < 3 * (solver.getGameBoard().length / 3); row++) {
                        for (int col = 2 * (solver.getGameBoard().length / 3); col < 3 * (solver.getGameBoard()[row].length / 3); col++) {
                            if (solver.getGameBoard()[row][col].getConfirmedElement() == 0 && solver.getGameBoard()[row][col].getCandidates()[number - 1] != 0)
                                candidateCount++;
                            if (candidateCount > 1)
                                break;
                        }
                        if ( candidateCount > 1 )
                            break;
                    }
                    if (candidateCount == 1)
                        return number;
                }
                break;
        }
        return 0;
    }

    // FIXME switch문 간단하게 리펙토링 요망(section별로 case구분하지 않고 간결한 코드로 흐름 분기될 수 있도록)
    private void sectionSolveHiddenSingleCandidate( ProblemSolver solver ) {
        for ( int section = 1; section <= 9; section ++ ) {

            int hiddenSingleCanndidate = sectionSearchHiddenSingleCandidate(
                    solver, section );
            if ( hiddenSingleCanndidate != 0 ) {
                switch (section) {
                    case 1:
                        for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                            for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(solver.getGameBoard()[row][col], hiddenSingleCanndidate)) {
                                    solver.minusOneNumOfZero();
                                    return;
                                }
                            }
                        }
                        break;

                    case 2:
                        for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                            for (int col = (solver.getGameBoard().length / 3); col < 2 * (solver.getGameBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(solver.getGameBoard()[row][col], hiddenSingleCanndidate)) {
                                    solver.minusOneNumOfZero();
                                    return;
                                }
                            }
                        }
                        break;


                    case 3:
                        for (int row = 0; row < (solver.getGameBoard().length / 3); row++) {
                            for (int col = 2 * (solver.getGameBoard().length / 3); col < 3 * (solver.getGameBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(solver.getGameBoard()[row][col], hiddenSingleCanndidate)) {
                                    solver.minusOneNumOfZero();
                                    return;
                                }
                            }
                        }
                        break;

                    case 4:
                        for (int row = (solver.getGameBoard().length / 3); row < 2 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(solver.getGameBoard()[row][col], hiddenSingleCanndidate)) {
                                    solver.minusOneNumOfZero();
                                    return;
                                }
                            }
                        }
                        break;


                    case 5:
                        for (int row = (solver.getGameBoard().length / 3); row < 2 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = (solver.getGameBoard().length / 3); col < 2 * (solver.getGameBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(solver.getGameBoard()[row][col], hiddenSingleCanndidate)) {
                                    solver.minusOneNumOfZero();
                                    return;
                                }
                            }
                        }
                        break;


                    case 6:
                        for (int row = (solver.getGameBoard().length / 3); row < 2 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = 2 * (solver.getGameBoard().length / 3); col < 3 * (solver.getGameBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(solver.getGameBoard()[row][col], hiddenSingleCanndidate)) {
                                    solver.minusOneNumOfZero();
                                    return;
                                }
                            }
                        }
                        break;


                    case 7:
                        for (int row = 2 * (solver.getGameBoard().length / 3); row < 3 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = 0; col < (solver.getGameBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(solver.getGameBoard()[row][col], hiddenSingleCanndidate)) {
                                    solver.minusOneNumOfZero();
                                    return;
                                }
                            }
                        }
                        break;


                    case 8:
                        for (int row = 2 * (solver.getGameBoard().length / 3); row < 3 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = (solver.getGameBoard().length / 3); col < 2 * (solver.getGameBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(solver.getGameBoard()[row][col], hiddenSingleCanndidate)) {
                                    solver.minusOneNumOfZero();
                                    return;
                                }
                            }
                        }
                        break;


                    case 9:
                        for (int row = 2 * (solver.getGameBoard().length / 3); row < 3 * (solver.getGameBoard().length / 3); row++) {
                            for (int col = 2 * (solver.getGameBoard().length / 3); col < 3 * (solver.getGameBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(solver.getGameBoard()[row][col], hiddenSingleCanndidate)) {
                                    solver.minusOneNumOfZero();
                                    return;
                                }
                            }
                        }
                        break;

                }
            }
        }
    }

}
