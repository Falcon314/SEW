package jhahn.view;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final JButton schereBtn; // Attribut für Button für Schere
    private final JButton steinBtn; // Attribut für Button für Stein
    private final JButton papierBtn; // Attribut für Button für Papier
    private final JLabel resultLabel; // Attribut für Label für resultat

    public GamePanel() {
        JPanel btnPanel = new JPanel();

        schereBtn = new JButton("Schere");
        steinBtn = new JButton("Stein");
        papierBtn = new JButton("Papier");
        btnPanel.add(schereBtn);
        btnPanel.add(steinBtn);
        btnPanel.add(papierBtn);

        resultLabel = new JLabel("Wähle deine Option!", SwingConstants.CENTER); // Erstellung eines Labels
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Setzen vom Font für das Label

        add(btnPanel, BorderLayout.CENTER); // Hinzufügen vom btnPanel zum Frame
        add(resultLabel, BorderLayout.SOUTH); // Hinzufügen vom Label zum Frame
    }

    public JButton[] getBtn() {
        return new JButton[] {this.schereBtn, this.steinBtn, this.papierBtn};
    }

    public JLabel getResultLabel() {
        return this.resultLabel;
    }
}
