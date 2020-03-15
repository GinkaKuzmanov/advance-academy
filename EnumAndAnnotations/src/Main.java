import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Logger logger = new Logger(reader.readLine());
        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] cmdArgs = input.split(": ");
            Message message = new Message(cmdArgs[0], cmdArgs[1]);
            logger.log(message);
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }
    }
}
