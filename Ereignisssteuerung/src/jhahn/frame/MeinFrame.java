package jhahn.frame;

import javax.swing.*;
import java.awt.*;

import jhahn.panel.*;

public class MeinFrame extends JFrame{
    public MeinFrame() {
        super("Ereignisssteuerung");

        setDefaultCloseOperation(3);

        add(new MeinPanel());

        pack();
        setVisible(true);
    }
}
