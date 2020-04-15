import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class EightQueenAlgo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //2 //+ 3 - 4 + 7 - 14
        //implement using stack
       //greshka beshe da slagash vsichki elementi v stack nqma nujda zashtoto sa posledovatelni
        Deque<Integer> stack = new ArrayDeque<>();
        String [] input = reader.readLine().split("\\s+");
        if(input.length == 0){
            return;
        }
        stack.push(Integer.parseInt(input[0]));

        for (int i = 1; i < input.length; i+=2) {
              String operationSign = input[i];
              int operand = Integer.parseInt(input[i + 1]);
              int stackNum = stack.pop();

              if(operationSign.equals("+")){
                  stack.push(operand + stackNum);
              }
              else if(operationSign.equals("-")){
                  stack.push(stackNum - operand);
              }

        }

        System.out.println(stack.pop());
    }
}
