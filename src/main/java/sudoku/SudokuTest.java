package sudoku;

import java.io.IOException;

public class SudokuTest {
    public static void main ( String[] args ) throws IOException {

        ProblemSolver solver = new ProblemSolver("q_1");

        ScreenOut.showState(solver.solve());

    }
}

// TODO solve()메소드에 시간 옵션을 주면 그만큼 딜레이를 주면서 콘솔로 진행상황 출력하는 메소드 추가
// TODO 고급 풀이법 구현
