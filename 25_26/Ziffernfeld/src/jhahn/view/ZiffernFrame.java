package jhahn.view;

import jhahn.controller.ZiffernControl;

import javax.swing.*;
import java.awt.*;

public class ZiffernFrame extends JFrame {
    public ZiffernFrame(ZiffernPanel panel) {
        this.setTitle("Ziffernfeld");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,400);
        this.add(panel);
        this.pack();

        this.setVisible(true);
    }
}
