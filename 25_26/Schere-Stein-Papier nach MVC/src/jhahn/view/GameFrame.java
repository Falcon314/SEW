package jhahn.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    public GamePanel panel;
    public GameFrame(ActionListener controller) {
        this.setTitle("Schere-Stein-Papier"); // Titel für das Fenster
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Aktion, wenn geschlossen
        this.setSize(400,100); // Standard Größe
        this.setLayout(new BorderLayout()); // Layout typ
        panel = new GamePanel();
        add(panel);
        JButton[] btns = panel.getBtn(); // 0 = Schere, 1 = Stein, 2 = Papier
        btns[0].addActionListener(controller); // Schere
        btns[1].addActionListener(controller); // Stein
        btns[2].addActionListener(controller); // Papier
        btns[0].setActionCommand("Schere"); // Schere
        btns[1].setActionCommand("Stein"); // Stein
        btns[2].setActionCommand("Papier"); // Papier

        this.setVisible(true); // Sichtbar machen
    }

    // Methode, um den Label up zu daten
    public void updateResult(String result) {
        if (result != null) panel.getResultLabel().setText(result);
    }
}
