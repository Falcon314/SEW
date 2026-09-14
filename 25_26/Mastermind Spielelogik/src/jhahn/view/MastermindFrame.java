package jhahn.view;

import jhahn.controller.*;
import jhahn.model.MastermindState; // weil setStage den datentyp braucht

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MastermindFrame extends JFrame implements MastermindGUI {
    private MastermindLayout panel;
    public MastermindFrame(ActionListener controller) {
        this.setTitle("Mastermind");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new MastermindLayout();

        JButton nBtn = panel.getNeuBtn();
        JButton cBtn = panel.getCheckBtn();
        JButton lBtn = panel.getLosungBtn();
        nBtn.addActionListener(controller);
        cBtn.addActionListener(controller);
        lBtn.addActionListener(controller);
        cBtn.setActionCommand("check");
        nBtn.setActionCommand("neu");
        lBtn.setActionCommand("losung");

        getContentPane().add(panel);

        this.setVisible(true);
    }

    public MastermindLayout getMastermindLayout() {
        return panel;
    }

    /**
     * bereitet die GUI auf ein neues Spiel vor.
     * alle Textfelder werden geleert und aktiviert.
     * "Neu"-Button wird deaktiviert, "Check"- und "Lösung"-Button werden aktiviert.
     * In der Statuszeile wird "Los geht's!" angezeigt.
     * OPTIONAL: für die FormenPanels wird eine zufällige Form und Farbe gesetzt.
     */
    @Override
    public void startGame() {
        JTextField[] tf = panel.getTextFields();
        for (int i = 0; i < tf.length; i++) {
            tf[i].setText("");
            tf[i].setEnabled(true);
        }
        FormPanel[][] fp = panel.getFormPanel();
        for (int i = 0; i < fp.length; i++) { // löschen zum neu zeichnen
            for (int j = 0; j < fp[i].length; j++) {
                fp[i][j].clear();
            }
        }
        JButton nBtn = panel.getNeuBtn();
        JButton cBtn = panel.getCheckBtn();
        JButton lBtn = panel.getLosungBtn();
        nBtn.setEnabled(false);
        cBtn.setEnabled(true);
        lBtn.setEnabled(true);

        JLabel statusLeiste = panel.getStatusleiste();
        statusLeiste.setText("Los geht's!");
        statusLeiste.setForeground(Color.BLACK);
    }

    /**
     * stellt die vom Parameter 'state' erhaltenen Werte dar.
     * Für jede erratene Zahl an der richtigen Position soll eine form in der oberen Zeile angezeigt werden,
     * für jede erratene Zahl an falscher Position wird eine Form in der unteren Zeile angezeigt.
     * Wurde das Spiel gewonnen, soll in der Statuszeile "Hurra! Gewonnen!" angezeigt werden, die Textfelder, "Check"- und "Lösung"-Button deaktiviert werden und der "Neu"-Button aktiviert werden.
     * @param state enthält die Werte die angezeigt werden sollen.
     */
    @Override
    public void setState(MastermindState state) {
        if (state.isWon()) {
            panel.getStatusleiste().setText("Hurra! Gewonnen");
            JTextField[] tf = panel.getTextFields();
            for (int i = 0; i < tf.length; i++) {
                tf[i].setEnabled(false);
            }
            panel.getCheckBtn().setEnabled(false);
            panel.getLosungBtn().setEnabled(false);
            panel.getNeuBtn().setEnabled(true);

        } else {
            panel.getStatusleiste().setForeground(Color.BLACK);
            panel.getStatusleiste().setText("Runde: " + state.getRound());
            FormPanel[][] fp = panel.getFormPanel();
            for (int i = 0; i < fp.length; i++) { // löschen zum neu zeichnen
                for (int j = 0; j < fp[i].length; j++) {
                    fp[i][j].clear();
                }
            }
            for (int i = 0; i < state.getCorrectnumber(); i++) { // unten
                fp[1][i].draw();
            }
            for (int i = 0; i < state.getCorrectplace(); i++) { // oben
                fp[0][i].draw();
            }
        }
    }

    /**
     * zeigt die Nummern-Kombination aus dem Parameter in den Textfeldern an.
     * Die Textfelder, "Check"- und "Lösung"-Button werden deaktiviert, der "Neu"-Button aktiviert.
     * In der Statusleiste wird "Cheater, verloren" angezeigt.
     * @param numbers Nummern-Kombination die in den Textfeldern angezeigt werden sollen
     */
    @Override
    public void showSolution(int[] numbers) {
        JTextField[] tf = panel.getTextFields();
        for (int i = 0; i < tf.length; i++) {
            tf[i].setText(String.valueOf(numbers[i]));
            tf[i].setEnabled(false);
        }
        JButton nBtn = panel.getNeuBtn();
        JButton cBtn = panel.getCheckBtn();
        JButton lBtn = panel.getLosungBtn();
        nBtn.setEnabled(true);
        cBtn.setEnabled(false);
        lBtn.setEnabled(false);

        JLabel statusLeiste = panel.getStatusleiste();
        statusLeiste.setText("Cheater, verloren!");
        statusLeiste.setForeground(Color.RED);
    }

    /**
     * liefert die in den Textfeldern eingegebenen Zahlen als Array zurück.
     * @return das Zahlen Array von den Textfeldern.
     */
    @Override
    public int[] getNumbers() throws NumberFormatException {
        JTextField[] tf = panel.getTextFields();
        int[] numArr = new int[tf.length];
        for (int i = 0; i < tf.length; i++) {
            numArr[i] = Integer.parseInt(tf[i].getText());
        }
        return numArr;
    }

    /**
     * zeigt die übergebene Nachricht in der Statusleiste an.
     * OPTIONAL: Error=ROT; normal=Schwarz
     * @param message Nachricht die angezeigt werden soll
     */
    @Override
    public void showError(String message) {
        JLabel statusLeiste = panel.getStatusleiste();
        statusLeiste.setText(message);
        statusLeiste.setForeground(Color.RED);
    }
}
