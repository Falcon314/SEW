package jhahn.controller;

import jhahn.view.*;
import java.awt.event.*;

/**
 * Controller-Klasse für Ziffernfeld
 * @author Lisa Vittori
 * @version 2019-05-16
 */
public class ZiffernControl implements ActionListener {
    private final ZiffernPanel zp;
    private final ZiffernFrame zf;

    /**
     * Erstellt ein neues ZiffernControl-Objekt, registriert dieses bei der View
     * zur Verwendung als Ereignissteuerung und initialisert
     */
    public ZiffernControl() {
        this.zp = new ZiffernPanel(this);
        this.zf = new ZiffernFrame(zp);
    }

    /**
     * Ereignissteuerung für die Ziffern-Buttons, sowie den +/- Button und das Komma
     * @param e das übergebene ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "+/-":
                zp.vorzeichenAendern();
                break;
            case ",":
                zp.fuegeKommaHinzu();
                break;
            default:
                zp.fuegeZifferHinzu(e.getActionCommand());
        }
    }

    /**
     * Startet die GUI
     * @param args nicht verwendet
     */
    public static void main(String[] args) {
        new ZiffernControl();
    }
}