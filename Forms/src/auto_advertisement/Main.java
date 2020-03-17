package auto_advertisement;


import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        AdFrame adFrame = new AdFrame();
        adFrame.setLayout(new FlowLayout());
        adFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        adFrame.setSize(600, 300);
        adFrame.setVisible(true);
    }
}
