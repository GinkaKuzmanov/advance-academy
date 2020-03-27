package customlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> list = new CustomList<>();
        CommandInterpreter commandInterpreter = new CommandInterpreter(list);

        while(!commandInterpreter.isEndDispatch()){
            String [] varArgs = reader.readLine().split("\\s+");
            commandInterpreter.dispatch(varArgs);
        }
    }
}
