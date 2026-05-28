package jhahn.view;

import jhahn.controller.ZiffernControl;

import javax.swing.*;
import java.awt.*;

public class ZiffernPanel extends JPanel {
    private JLabel zifferLabel;
    private final JButton[][] ziffern;
    private boolean setcomma = false;

    public ZiffernPanel(ZiffernControl control) {
        this.setLayout(new BorderLayout());
        this.zifferLabel = new JLabel(" ", SwingConstants.RIGHT);
        zifferLabel.setFont(new Font("Arial", Font.BOLD, 32));
        JPanel btnPanel = new JPanel(new GridLayout(4,3,1,1));
        ziffern = new JButton[][]{
            {new JButton("7"), new JButton("8"), new JButton("9")},
            {new JButton("4"), new JButton("5"), new JButton("6")},
            {new JButton("1"), new JButton("2"), new JButton("3")},
            {new JButton("+/-"), new JButton("0"), new JButton(",")}
        };
        for (int i=0; i<ziffern.length;i++) {
            for (int j=0; j< ziffern[i].length;j++) {
                ziffern[i][j].setActionCommand(ziffern[i][j].getText());
                ziffern[i][j].addActionListener(control);
                ziffern[i][j].setFont(new Font("Arial", Font.PLAIN, 32));
                btnPanel.add(ziffern[i][j]);
            }
        }
        this.add(zifferLabel, BorderLayout.CENTER);
        this.add(btnPanel, BorderLayout.SOUTH);
    }
    public void vorzeichenAendern() {
        JLabel zl = zifferLabel;
        String zlt = zl.getText();
        if (zlt.charAt(0) == '-') {
            zl.setText(zlt.substring(1));
        } else {
            zl.setText('-'+zlt);
        }
    }

    public void fuegeKommaHinzu() {
        JLabel zl = zifferLabel;
        String zlt = zl.getText();
        if (!setcomma) {
            zl.setText(zlt+',');
            setcomma=true;
        }
    }

    public void fuegeZifferHinzu(String number) {
        this.zifferLabel.setText(this.zifferLabel.getText()+number);
    }
}

