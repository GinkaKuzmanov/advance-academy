package homework;
import java.util.Scanner;

public class AverageInArray {
    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int length = 5;
        int[] arr = new int[length];
        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
        }catch (IndexOutOfBoundsException iobe){
            System.out.println(iobe.getMessage());
        }
        //using stream;
        //Arrays.stream(arr).average().ifPresent(e-> System.out.println(e));
        //iterative
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }
        int average = sum /arr.length;
        System.out.println("Average is: "+ average);


    }
}
