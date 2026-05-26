package jhahn.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MastermindLayout extends JPanel {
    private JButton checkBtn, neuBtn, losungBtn;
    private JTextField[] tf;
    private JLabel statusleiste;

    private JPanel row1, row2;
    private FormPanel[][] formPanels; // 2 Reihen x 5 Spalten

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
        for(int i=0;i<5;i++){
            tf[i] = new JTextField();
            tf[i].setFont(new Font("Arial", Font.PLAIN, 20));
            tf[i].setHorizontalAlignment(JTextField.CENTER);
            eingabefelder.add(tf[i]);
        }
        add(eingabefelder, BorderLayout.NORTH);


        // --------- FormPanels (2 Reihen x 5 Spalten) ---------
        JPanel centerPanel = new JPanel(new GridLayout(2,1));
        centerPanel.setBackground(Color.WHITE);

        formPanels = new FormPanel[2][5];

        row1 = new JPanel(new GridLayout(1,5,10,10));
        row2 = new JPanel(new GridLayout(1,5,10,10));
        row1.setBackground(Color.WHITE);
        row2.setBackground(Color.WHITE);

        // ROW 1: grün + gefüllt
        for (int i = 0; i < 5; i++) {
            formPanels[0][i] = new FormPanel(typesrow1[i], Color.GREEN, true);
            row1.add(formPanels[0][i]);
        }
        // ROW 2: orange + hohl
        for (int i = 0; i < 5; i++) {
            formPanels[1][i] = new FormPanel(typesrow2[i], Color.ORANGE, false);
            row2.add(formPanels[1][i]);
        }

        row1.setVisible(false);
        row2.setVisible(false);
        centerPanel.add(row1);
        centerPanel.add(row2);
        add(centerPanel, BorderLayout.CENTER);


        // --------- Buttons ---------
        checkBtn = new JButton("Check");
        neuBtn = new JButton("Neu");
        losungBtn = new JButton("Lösung");

        checkBtn.setActionCommand("check");
        neuBtn.setActionCommand("neu");
        losungBtn.setActionCommand("losung");

        JPanel btnPanel = new JPanel(new BorderLayout());
        JPanel btns = new JPanel(new GridLayout(3,1,5,5));
        btns.setBorder(BorderFactory.createEmptyBorder(5,5,0,5));
        btns.setBackground(bgColor);
        btns.add(checkBtn);
        btns.add(losungBtn);
        btns.add(neuBtn);

        btnPanel.setBackground(bgColor);
        btnPanel.add(btns, BorderLayout.NORTH);

        JButtonHandler jbh = new JButtonHandler();
        checkBtn.addActionListener(jbh);
        neuBtn.addActionListener(jbh);
        losungBtn.addActionListener(jbh);

        add(btnPanel, BorderLayout.EAST);


        // --------- Statusleiste ---------
        statusleiste = new JLabel("Gewonnen, du hast meine Zahlen erraten!", SwingConstants.CENTER);
        statusleiste.setBackground(bgColor);
        add(statusleiste, BorderLayout.SOUTH);
    }


    // --------- Controller ---------
    private class JButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()){
                case "check": clearAll(); break;
                case "losung": drawRow(2); break;
                case "neu": drawRow(1); break;
            }
        }
    }

    private void drawRow(int row){
        switch (row) {
            case 1: row1.setVisible(true); break;
            case 2: row2.setVisible(true); break;
        }
    }

    private void clearAll(){
        row1.setVisible(false);
        row2.setVisible(false);
    }

    // Getter für Controller / Tests
    public JTextField[] getTextFields(){ return tf; }
    public FormPanel[][] getFormPanel(){return formPanels; }
    public JLabel getStatusleiste(){ return statusleiste; }
    public JButton getCheckBtn(){ return checkBtn; }
    public JButton getNeuBtn(){ return neuBtn; }
    public JButton getLosungBtn(){ return losungBtn; }
}