package annotations;

import java.io.PrintStream;

public class Printer {

    private PrintStream out;


    public Printer(PrintStream out){
        this.out = out;
    }


    public void print(String input){
        this.out.println(input);
    }

}
