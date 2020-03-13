import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StackIterator stackIterator = new StackIterator();
        while (!"END".equals(input = reader.readLine())) {
            String[] commands = input.split("\\s|,\\s+");
            switch (commands[0]) {
                case "Push":
                    for (int i = 1; i < commands.length; i++) {
                        stackIterator.push(Integer.valueOf(commands[i]));
                    }
                    break;
                case "Pop":
                    try {
                      stackIterator.pop();
                    } catch (UnsupportedOperationException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        int value;
        List<Integer> hack = new ArrayList<>();
        while(!stackIterator.isEmpty()){
            System.out.println(stackIterator.peek());
            value = stackIterator.pop();
            hack.add(value);
        }
        hack.forEach(System.out::println);


    }
}
