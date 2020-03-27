package file_streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        String output = "output.txt";
        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream fos = new FileOutputStream(output);
        //1024 bits
        int oneByte = inputStream.read();
        int space = ' ';

        while(oneByte != -1) {
            String representation = String.valueOf(oneByte);
            for (int i = 0; i < representation.length(); i++) {
                int numRepr = representation.charAt(i);
                if (oneByte == space)
                    fos.write(oneByte);
            else {
                    fos.write(numRepr);
                }
            }
            oneByte = inputStream.read();
        }
            //nie prochitame eding byte i trqbva da zapishem kato string chisloto

        }

}
