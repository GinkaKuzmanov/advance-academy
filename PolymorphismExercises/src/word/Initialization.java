package word;

import word.commands.CommandImpl;
import word.commands.CommandInterface;

public class Initialization {

        //we initialize the implementation with command impl
    public static CommandInterface buildCommandInterface(StringBuilder text) {
        return new CommandImpl(text);
    }
}
