package jhahn.panels;

import javax.swing.*;
import java.awt.*;

public class MeinPanel extends JPanel {
    public MeinPanel() {
        JLabel label = new JLabel("Jason Hahn", SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(new Color(8,12,210));
        label.setPreferredSize(new Dimension(200,180));
        add(label);
    }
}
