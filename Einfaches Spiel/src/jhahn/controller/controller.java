package jhahn.controller;

import jhahn.model.GewinnModel;
import jhahn.view.GrafikFrame;
import jhahn.view.GrafikPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller implements ActionListener {
    private final GrafikFrame view;
    private final GewinnModel model;
    public controller() {
        this.view = new GrafikFrame(this);
        this.model = new GewinnModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GrafikPanel panel = view.getPanel();
        if (e.getActionCommand().equals("eingabe")) {
            int eingabe;
            try {
                eingabe = Integer.parseInt(panel.getEingabeValue());
            } catch (NumberFormatException ex) {
                return;
            }
            model.berechneRunde(eingabe);
            panel.setEingabeEditable(false);
            panel.setNochMalBtnEnabled(true);
            if (model.hatGewonnen()) {
                panel.setRundenErgebnis("Gewonnen");
                panel.setRundenErgebnis(Color.GREEN);
            }
            else if (model.hatVerloren()) {
                panel.setRundenErgebnis("Verloren");
                panel.setRundenErgebnis(Color.RED);
            }
            else {
                panel.setRundenErgebnis(Integer.toString(model.getRundenErgebnis()));
                if (model.getRundenErgebnis() > 0) {
                    panel.setRundenErgebnis(Color.GREEN);
                    panel.setGesamtPunkte(Color.GREEN);
                } else if (model.getRundenErgebnis() < 0) {
                    panel.setRundenErgebnis(Color.RED);
                    panel.setGesamtPunkte(Color.RED);
                }
            }
            panel.setComputerPunkte(Integer.toString(model.getComputerZahl()));
            panel.setGesamtPunkte(Integer.toString(model.getGesamtPunkte()));
        } else if (e.getActionCommand().equals("btn")) {
            panel.setEingabeEditable(true);
            panel.setNochMalBtnEnabled(false);
            panel.setComputerPunkte("");
            panel.setRundenErgebnis("");
            panel.setEingabeValue("");
            panel.setRundenErgebnis(Color.WHITE);
            panel.setGesamtPunkte(Color.WHITE);
        }
    }

    public static void main(String[] args) {new controller();}
}
