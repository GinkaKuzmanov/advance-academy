import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class PathFinding {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String [] rowo = reader.readLine().split(", ");
//        int rows = Integer.parseInt(rowo[0]);
//        int cols = Integer.parseInt(rowo[1]);
//
//        int[][] matrix = new int[rows][cols];
//
//        for (int row = 0; row < matrix.length; row++) {
//            int[] masiv = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
//            matrix[row] = masiv;
//        }
//
//        //deklarirame taka zaradi possibility of negative values in matrix
//        int sum = Integer.MIN_VALUE;
//        int maxRow = 0;
//        int maxCol = 0;
////zashtoto ni trqbva elementa
//        for (int row = 0; row < matrix.length - 1 ; row++) {
//            for (int col = 0; col < matrix[row].length - 1; col++) {
//                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
//
//                if(currentSum > sum){
//                    sum = currentSum;
//                    maxRow = row;
//                    maxCol = col;
//                }
//            }
//        }
//
//
//
//        System.out.println(matrix[maxRow][maxCol] + " " + matrix[maxRow][maxCol + 1]);
//        System.out.println(matrix[maxRow + 1][maxCol] + " " + matrix[maxRow + 1][maxCol + 1]);
//        System.out.println(sum);

        Set<String> vips = new HashSet<>();
        vips.add("Ginka");
        vips.add("John");
        vips.add("pen");
        vips.add("5Mofmw");

        for (String vip : vips) {
            if(vip.startsWith("5"))
            {
                System.out.println(vip);
            }
        }
    }
}
