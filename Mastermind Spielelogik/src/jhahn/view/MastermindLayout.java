package jhahn.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MastermindLayout extends JPanel {
    private JButton checkBtn, neuBtn, losungBtn;
    private JTextField[] tf;
    private JLabel statusleiste;

    private FormPanel[] topPanels, bottomPanels; // 2 Reihen x 5 Spalten

    private Form[] typesrow1 = {Form.CIRCLE,Form.SQUARE,Form.TRIANGLE,Form.SQUARE,Form.CIRCLE};
    private Form[] typesrow2 = {Form.CIRCLE,Form.SQUARE,Form.TRIANGLE,Form.SQUARE,Form.CIRCLE};

    public MastermindLayout() {
        setLayout(new BorderLayout());
        Color bgColor = new Color(200,200,200);
        setBackground(bgColor);

        // --------- Eingabefelder ---------
        tf = new JTextField[5];
        JPanel eingabefelder = new JPanel(new GridLayout(1,5,3,3));
        eingabefelder.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        eingabefelder.setBackground(bgColor);
        Font font = new Font("Arial", Font.PLAIN, 20);
        for(int i=0;i<5;i++){
            tf[i] = new JTextField();
            tf[i].setFont(font);
            tf[i].setHorizontalAlignment(JTextField.CENTER);
            eingabefelder.add(tf[i]);
        }
        add(eingabefelder, BorderLayout.NORTH);

        // --------- FormPanels ---------
        JPanel centerPanel = new JPanel(new GridLayout(2,5,5,5));
        topPanels = new FormPanel[5];
        bottomPanels = new FormPanel[5];

        for (int i = 0; i < 5; i++) {
            topPanels[i] = new FormPanel(typesrow1[i], Color.GREEN, true);
            centerPanel.add(topPanels[i]);
        }
        for (int i = 0; i < 5; i++) {
            bottomPanels[i] = new FormPanel(typesrow2[i], Color.ORANGE, false);
            centerPanel.add(bottomPanels[i]);
        }
        add(centerPanel, BorderLayout.CENTER);

        // --------- Buttons ---------
        checkBtn = new JButton("Check");
        neuBtn = new JButton("Neu");
        losungBtn = new JButton("Lösung");


        JPanel btnPanel = new JPanel(new BorderLayout());
        JPanel btns = new JPanel(new GridLayout(3,1,5,5));
        btns.setBorder(BorderFactory.createEmptyBorder(5,5,0,5));
        btns.setBackground(bgColor);
        btns.add(checkBtn);
        btns.add(losungBtn);
        btns.add(neuBtn);

        btnPanel.setBackground(bgColor);
        btnPanel.add(btns, BorderLayout.NORTH);

        add(btnPanel, BorderLayout.EAST);


        // --------- Statusleiste ---------
        statusleiste = new JLabel("Gewonnen, du hast meine Zahlen erraten!", SwingConstants.CENTER);
        statusleiste.setBackground(bgColor);
        add(statusleiste, BorderLayout.SOUTH);
    }

    // Getter für Controller / Tests
    public JTextField[] getTextFields(){ return tf; }

    public FormPanel[][] getFormPanel(){return new FormPanel[][] {topPanels, bottomPanels}; }

    public JLabel getStatusleiste(){ return statusleiste; }
    public JButton getCheckBtn(){ return checkBtn; }
    public JButton getNeuBtn(){ return neuBtn; }
    public JButton getLosungBtn(){ return losungBtn; }
}