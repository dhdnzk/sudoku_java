package sudoku;

public class SolveHiddenSingleCandidate extends JuniorExplanation {

    static boolean transformThisCandidateToConfirmedElement ( Element element, int candidate ) {
        if ( element.getCandidates() == null ) return false;
        if ( element.getCandidates()[candidate - 1] == candidate  ) {
            element.setConfirmedElement( candidate );
            return true;
        }
        return false;
    }

    static int rowSearchHiddenSingleCandidate( Problem problem, int row ) {
        rowCandidateRemoval( problem.getCandidateBoard(), row );
        for ( int number = 1; number <= 9; number ++ ) {
            int candidateCount = 0;
            for (int col = 0; col < 9; col ++ ) {
                if ( problem.getCandidateBoard()[ row - 1][ col ].getConfirmedElement() == 0 && problem.getCandidateBoard()[ row - 1][ col ].getCandidates()[number - 1] != 0 )
                   candidateCount ++;
                if ( candidateCount > 1 )
                    break;
            }
            if ( candidateCount == 1 )
                return number;
        }
        return 0;
    }

    static void rowSolveHiddenSingleCandidate( Problem problem ) {
        for ( int row = 1; row <= problem.getCandidateBoard().length; row ++ ) {
            int hiddenSingleCandidate = rowSearchHiddenSingleCandidate( problem, row );
            if ( hiddenSingleCandidate != 0 ) {
                for ( int col = 1; col < problem.getCandidateBoard()[row -1].length; col ++ ) {
                    if ( transformThisCandidateToConfirmedElement( problem.getCandidateBoard()[row - 1][col - 1], hiddenSingleCandidate ) ) {
                        problem.numOfZero --;
                        problem.showState();
                        return;
                    }

                }
            }
        }
    }

    static int colSearchHiddenSingleCandidate( Problem problem, int col ) {
        colCandidateRemoval( problem.getCandidateBoard(), col );
        for ( int number = 1; number <= 9; number ++ ) {
            int candidateCount = 0;
            for (int row = 0; row < 9; row ++ ) {
                if ( problem.getCandidateBoard()[ row ][ col - 1 ].getConfirmedElement() == 0 && problem.getCandidateBoard()[ row ][ col - 1 ].getCandidates()[number - 1] != 0 )
                    candidateCount ++;
                if ( candidateCount > 1 )
                    break;
            }
            if ( candidateCount == 1 )
                return number;
        }
        return 0;
    }

    static void colSolveHiddenSingleCandidate( Problem problem ) {
        for ( int col = 1; col <= problem.getCandidateBoard()[0].length; col ++ ) {
            int hiddenSingleCandidate = colSearchHiddenSingleCandidate( problem, col );
            if ( hiddenSingleCandidate != 0 ) {
                for ( int row = 1; row < problem.getCandidateBoard().length; row ++ ) {
                    if( transformThisCandidateToConfirmedElement( problem.getCandidateBoard()[row - 1][col - 1], hiddenSingleCandidate ) ) {
                        problem.numOfZero --;
                        problem.showState();
                        return;
                    }
                }
            }
        }
    }

    // FIXME switch문 간단하게 리펙토링 요망(section별로 case구분하지 않고 간결한 코드로 흐름 분기될 수 있도록)
    public static int sectionSearchHiddenSingleCandidate( Problem problem, int section ) {
        sectionCandidateRemoval( problem, section );
        int candidateCount = 0;
        switch ( section ) {
            case 1:
                for (int number = 1; number <= 9; number++) {
                    for (int row = 0; row < (problem.getCandidateBoard().length / 3); row++) {
                        for (int col = 0; col < (problem.getCandidateBoard()[row].length / 3); col++) {
                            if (problem.getCandidateBoard()[row][col].getConfirmedElement() == 0 && problem.getCandidateBoard()[row][col].getCandidates()[number - 1] != 0)
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
                    for (int row = 0; row < (problem.getCandidateBoard().length / 3); row++) {
                        for (int col = (problem.getCandidateBoard().length / 3); col < 2 * (problem.getCandidateBoard()[row].length / 3); col++) {
                            if (problem.getCandidateBoard()[row][col].getConfirmedElement() == 0 && problem.getCandidateBoard()[row][col].getCandidates()[number - 1] != 0)
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
                    for (int row = 0; row < (problem.getCandidateBoard().length / 3); row++) {
                        for (int col = 2 * (problem.getCandidateBoard().length / 3); col < 3 * (problem.getCandidateBoard()[row].length / 3); col++) {
                            if (problem.getCandidateBoard()[row][col].getConfirmedElement() == 0 && problem.getCandidateBoard()[row][col].getCandidates()[number - 1] != 0)
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
                    for (int row = 1 * (problem.getCandidateBoard().length / 3); row < 2 * (problem.getCandidateBoard().length / 3); row++) {
                        for (int col = 0 * (problem.getCandidateBoard().length / 3); col < 1 * (problem.getCandidateBoard()[row].length / 3); col++) {
                            if (problem.getCandidateBoard()[row][col].getConfirmedElement() == 0 && problem.getCandidateBoard()[row][col].getCandidates()[number - 1] != 0)
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
                    for (int row = 1 * (problem.getCandidateBoard().length / 3); row < 2 * (problem.getCandidateBoard().length / 3); row++) {
                        for (int col = 1 * (problem.getCandidateBoard().length / 3); col < 2 * (problem.getCandidateBoard()[row].length / 3); col++) {
                            if (problem.getCandidateBoard()[row][col].getConfirmedElement() == 0 && problem.getCandidateBoard()[row][col].getCandidates()[number - 1] != 0)
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
                    for (int row = 1 * (problem.getCandidateBoard().length / 3); row < 2 * (problem.getCandidateBoard().length / 3); row++) {
                        for (int col = 2 * (problem.getCandidateBoard().length / 3); col < 3 * (problem.getCandidateBoard()[row].length / 3); col++) {
                            if (problem.getCandidateBoard()[row][col].getConfirmedElement() == 0 && problem.getCandidateBoard()[row][col].getCandidates()[number - 1] != 0)
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
                    for (int row = 2 * (problem.getCandidateBoard().length / 3); row < 3 * (problem.getCandidateBoard().length / 3); row++) {
                        for (int col = 0 * (problem.getCandidateBoard().length / 3); col < 1 * (problem.getCandidateBoard()[row].length / 3); col++) {
                            if (problem.getCandidateBoard()[row][col].getConfirmedElement() == 0 && problem.getCandidateBoard()[row][col].getCandidates()[number - 1] != 0)
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
                    for (int row = 2 * (problem.getCandidateBoard().length / 3); row < 3 * (problem.getCandidateBoard().length / 3); row++) {
                        for (int col = 1 * (problem.getCandidateBoard().length / 3); col < 2 * (problem.getCandidateBoard()[row].length / 3); col++) {
                            if (problem.getCandidateBoard()[row][col].getConfirmedElement() == 0 && problem.getCandidateBoard()[row][col].getCandidates()[number - 1] != 0)
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
                    for (int row = 2 * (problem.getCandidateBoard().length / 3); row < 3 * (problem.getCandidateBoard().length / 3); row++) {
                        for (int col = 2 * (problem.getCandidateBoard().length / 3); col < 3 * (problem.getCandidateBoard()[row].length / 3); col++) {
                            if (problem.getCandidateBoard()[row][col].getConfirmedElement() == 0 && problem.getCandidateBoard()[row][col].getCandidates()[number - 1] != 0)
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
    static void sectionSolveHiddenSingleCandidate( Problem problem ) {
        for ( int section = 1; section <= 9; section ++ ) {

            int hiddenSingleCanndidate = sectionSearchHiddenSingleCandidate( problem, section );
            if ( hiddenSingleCanndidate != 0 ) {
                switch (section) {
                    case 1:
                        for (int row = 0; row < (problem.getCandidateBoard().length / 3); row++) {
                            for (int col = 0; col < (problem.getCandidateBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(problem.getCandidateBoard()[row][col], hiddenSingleCanndidate)) {
                                    problem.numOfZero--;
                                    problem.showState();
                                    return;
                                }
                            }
                        }
                        break;

                    case 2:
                        for (int row = 0; row < (problem.getCandidateBoard().length / 3); row++) {
                            for (int col = (problem.getCandidateBoard().length / 3); col < 2 * (problem.getCandidateBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(problem.getCandidateBoard()[row][col], hiddenSingleCanndidate)) {
                                    problem.numOfZero--;
                                    problem.showState();
                                    return;
                                }
                            }
                        }
                        break;


                    case 3:
                        for (int row = 0; row < (problem.getCandidateBoard().length / 3); row++) {
                            for (int col = 2 * (problem.getCandidateBoard().length / 3); col < 3 * (problem.getCandidateBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(problem.getCandidateBoard()[row][col], hiddenSingleCanndidate)) {
                                    problem.numOfZero--;
                                    problem.showState();
                                    return;
                                }
                            }
                        }
                        break;

                    case 4:
                        for (int row = 1 * (problem.getCandidateBoard().length / 3); row < 2 * (problem.getCandidateBoard().length / 3); row++) {
                            for (int col = 0 * (problem.getCandidateBoard().length / 3); col < 1 * (problem.getCandidateBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(problem.getCandidateBoard()[row][col], hiddenSingleCanndidate)) {
                                    problem.numOfZero--;
                                    problem.showState();
                                    return;
                                }
                            }
                        }
                        break;


                    case 5:
                        for (int row = 1 * (problem.getCandidateBoard().length / 3); row < 2 * (problem.getCandidateBoard().length / 3); row++) {
                            for (int col = 1 * (problem.getCandidateBoard().length / 3); col < 2 * (problem.getCandidateBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(problem.getCandidateBoard()[row][col], hiddenSingleCanndidate)) {
                                    problem.numOfZero--;
                                    problem.showState();
                                    return;
                                }
                            }
                        }
                        break;


                    case 6:
                        for (int row = 1 * (problem.getCandidateBoard().length / 3); row < 2 * (problem.getCandidateBoard().length / 3); row++) {
                            for (int col = 2 * (problem.getCandidateBoard().length / 3); col < 3 * (problem.getCandidateBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(problem.getCandidateBoard()[row][col], hiddenSingleCanndidate)) {
                                    problem.numOfZero--;
                                    problem.showState();
                                    return;
                                }
                            }
                        }
                        break;


                    case 7:
                        for (int row = 2 * (problem.getCandidateBoard().length / 3); row < 3 * (problem.getCandidateBoard().length / 3); row++) {
                            for (int col = 0 * (problem.getCandidateBoard().length / 3); col < 1 * (problem.getCandidateBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(problem.getCandidateBoard()[row][col], hiddenSingleCanndidate)) {
                                    problem.numOfZero--;
                                    problem.showState();
                                    return;
                                }
                            }
                        }
                        break;


                    case 8:
                        for (int row = 2 * (problem.getCandidateBoard().length / 3); row < 3 * (problem.getCandidateBoard().length / 3); row++) {
                            for (int col = 1 * (problem.getCandidateBoard().length / 3); col < 2 * (problem.getCandidateBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(problem.getCandidateBoard()[row][col], hiddenSingleCanndidate)) {
                                    problem.numOfZero--;
                                    problem.showState();
                                    return;
                                }
                            }
                        }
                        break;


                    case 9:
                        for (int row = 2 * (problem.getCandidateBoard().length / 3); row < 3 * (problem.getCandidateBoard().length / 3); row++) {
                            for (int col = 2 * (problem.getCandidateBoard().length / 3); col < 3 * (problem.getCandidateBoard()[row].length / 3); col++) {
                                if (transformThisCandidateToConfirmedElement(problem.getCandidateBoard()[row][col], hiddenSingleCanndidate)) {
                                    problem.numOfZero--;
                                    problem.showState();
                                    return;
                                }
                            }
                        }
                        break;

                }
            }
        }
    }

    public static void solve ( Problem problem ) {
        rowSolveHiddenSingleCandidate( problem );
        colSolveHiddenSingleCandidate( problem );
        sectionSolveHiddenSingleCandidate( problem );
    }

}
