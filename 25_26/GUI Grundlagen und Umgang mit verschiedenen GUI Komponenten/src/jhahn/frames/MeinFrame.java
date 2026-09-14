package jhahn.frames;

import javax.swing.*;
import java.awt.*;
import jhahn.panels.*;

public class MeinFrame extends JFrame {
    public MeinFrame() {
        super("Jason Hahn - MeinFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MeinPanel panel = new MeinPanel();
        add(panel);

        pack();
        setVisible(true);
    }
}
