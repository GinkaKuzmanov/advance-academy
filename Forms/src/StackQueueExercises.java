public class StackQueueExercises {

    public static void main(String[] args) {
        int[][] matrix =
                {{1, 0, 0, 0, 1, 1},
                        {2, 3, 1, 0, 0, 1},
                        {1, 4, 5, 2, 0, 1}
                };


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1 && hasOneOnPos(matrix, row, col)) {
                    System.out.println(row + " " + col);
                }
            }
        }

    }

    private static boolean hasOneOnPos(int[][] matrix, int row, int col) {
        //for rows
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == 1) {
                return true;
            }
        }

        //upper left diagonal- zashtoto shte se vrashta nazade zatova se vodi upper left gore imame cikal zatova
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j] == 1) {
                return true;
            }
        }

        //lower left diagonal
        for (int i = row, j = col; i < matrix.length && j >= 0; i++, j--) {
            if (matrix[i][j] == 1) {
                return true;
            }
        }
        return false;
    }
}
