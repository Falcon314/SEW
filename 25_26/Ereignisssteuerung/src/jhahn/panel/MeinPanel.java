package jhahn.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeinPanel extends JPanel {
    private JLabel lAusgabe;
    private JButton bVname, bNname, bClear;

    public MeinPanel() {
        this.setLayout(new BorderLayout());
        this.lAusgabe = new JLabel("Name");

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 3,4));
        this.bVname = new JButton("Vorname");
        this.bNname = new JButton("Nachname");
        this.bClear = new JButton("Clear");
        buttonPanel.add(this.bVname);
        buttonPanel.add(this.bNname);
        buttonPanel.add(this.bClear);

        lAusgabe.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(lAusgabe, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);


        JButtonHandler jbh = new JButtonHandler();
        this.bVname.addActionListener(jbh);
        System.out.println(this.bVname.getActionCommand());
        this.bNname.addActionListener(jbh);
        this.bClear.addActionListener(jbh);
    }

    private class JButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            if (o == bVname) {
                lAusgabe.setText("Jason");
            } else if (o == bNname) {
                lAusgabe.setText("Hahn");
            } else if (o == bClear) {
                lAusgabe.setText("Name");
            }
        }
    }
}
