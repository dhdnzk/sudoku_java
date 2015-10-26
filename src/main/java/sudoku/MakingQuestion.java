package sudoku;

public class MakingQuestion {

    static int[][] arr1 = {
            { 0, 1, 0,  0, 0, 4,  0, 0, 0 },
            { 4, 0, 8,  0, 0, 0,  9, 0, 1 },
            { 0, 9, 0,  7, 0, 1,  2, 4, 5 },

            { 8, 6, 0,  0, 3, 0,  7, 0, 4 },
            { 0, 0, 0,  5, 0, 8,  0, 0, 0 },
            { 1, 0, 7,  0, 2, 0,  0, 8, 9 },

            { 5, 7, 6,  3, 0, 2,  0, 9, 0 },
            { 2, 0, 9,  0, 0, 0,  1, 0, 7 },
            { 0, 0, 0,  8, 0, 0,  0, 5, 0 },

    };

    static int[][] arr2 = {
            { 5, 3, 0,  0, 7, 0,  0, 0, 0 },
            { 6, 0, 0,  1, 9, 5,  0, 0, 0 },
            { 0, 9, 8,  0, 0, 0,  0, 6, 0 },

            { 8, 0, 0,  0, 6, 0,  0, 0, 3 },
            { 4, 0, 0,  8, 0, 3,  0, 0, 1 },
            { 7, 0, 0,  0, 2, 0,  0, 0, 6 },

            { 0, 6, 0,  0, 0, 0,  2, 8, 0 },
            { 0, 0, 0,  4, 1, 9,  0, 0, 5 },
            { 0, 0, 0,  0, 8, 0,  0, 7, 9 }
    };

    static int[][] arr3 = {
            { 0, 3, 0,  0, 0, 7,  0, 0, 4 },
            { 6, 0, 2,  0, 4, 1,  0, 0, 0 },
            { 0, 5, 0,  0, 3, 0,  9, 6, 7 },

            { 0, 4, 0,  0, 0, 3,  0, 0, 6 },
            { 0, 8, 7,  0, 0, 0,  3, 5, 0 },
            { 9, 0, 0,  7, 0, 0,  0, 2, 0 },

            { 7, 1, 8,  0, 2, 0,  0, 4, 0 },
            { 0, 0, 0,  1, 6, 0,  8, 0, 9 },
            { 4, 0, 0,  5, 0, 0,  0, 3, 0 }
    };

    public static int[][] makeQuiz() {
        switch ((int) (Math.random() * 2)) {
            case 1 :
                return arr1;
            case 2 :
                return arr2;
            default :
                return arr3;
        }
    }
}


