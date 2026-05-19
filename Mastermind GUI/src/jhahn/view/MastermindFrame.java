package jhahn.view;

import javax.swing.*;
import java.awt.*;

public class MastermindFrame extends JFrame {
    private MastermindLayout panel;
    public MastermindFrame() {
        this.setTitle("Mastermind");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new MastermindLayout();
        getContentPane().add(panel);

        this.setVisible(true);
    }
    public MastermindLayout getMastermindLayout() {
        return panel;
    }
}
