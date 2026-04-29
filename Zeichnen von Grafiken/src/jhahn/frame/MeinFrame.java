package jhahn.frame;

import jhahn.panels.MeinPanel;

import javax.swing.*;
import java.awt.*;

public class MeinFrame extends JFrame {
    public MeinFrame() {
        super("Muster");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new MeinPanel());
        this.setSize(new Dimension(200,200));
        this.setVisible(true);
    }
}
