package jhahn.controller;

import jhahn.view.*;
import jhahn.model.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formen implements ActionListener, ChangeListener {
    private FormenFrame view;
    private FormenModel model;

    public Formen() {
        view = new FormenFrame(this);
        model = new FormenModel();

        JTextField[] tf = view.getTextFields();
        DocumentListener dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSize();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSize();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSize();
            }
        };
        tf[0].getDocument().addDocumentListener(dl);
        tf[1].getDocument().addDocumentListener(dl);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FormenGrafik fg = view.getFormenGrafik();
        Object source = e.getSource();
        if (source instanceof JRadioButton) {
            JRadioButton btn = (JRadioButton) source;
            switch (btn.getActionCommand()) {
                case "Dreieck":
                    fg.setForm(Form.TRIANGLE);
                    view.getStatusLabel().setText("Status: Form wurde als letztes geändert");
                    break;
                case "Raute":
                    fg.setForm(Form.RHOMBUS);
                    view.getStatusLabel().setText("Status: Form wurde als letztes geändert");
                    break;
                case "Rechteck":
                    fg.setForm(Form.RECTANGLE);
                    view.getStatusLabel().setText("Status: Form wurde als letztes geändert");
                    break;
            }
        } else if (source instanceof JCheckBox)  {
            JCheckBox cb = (JCheckBox) source;
            fg.toggleFilled(cb.isSelected());
            view.getStatusLabel().setText("Status: Füllung wurde als letztes geändert");
        }
    }

    private void updateSize() {
        JTextField[] tf = view.getTextFields();
        int hoehe = 1;
        int breite = 1;
        try{
            long h = Long.parseLong(tf[0].getText().trim());
            hoehe = (int) Math.min(h, Integer.MAX_VALUE);
        } catch (NumberFormatException ex) {
            hoehe = 0;
            view.getStatusLabel().setText("Status: Fehler bei der Eingabe! Wert wurde auf 0 gesetzt");
        }
        try{
            long b = Long.parseLong(tf[1].getText().trim());
            breite = (int) Math.min(b, Integer.MAX_VALUE);
        } catch (NumberFormatException ex) {
            breite = 0;
            view.getStatusLabel().setText("Status: Fehler bei der Eingabe! Wert wurde auf 0 gesetzt");
        }
        view.getFormenGrafik().setDimension(new Dimension(breite,hoehe));
        view.getStatusLabel().setText("Status: Größe wurde als letztes geändert");
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        FormenGrafik fg = view.getFormenGrafik();
        if (e.getSource() instanceof JSlider) {
            fg.setColor(new Color(view.getRedSlider().getValue(), view.getGreenSlider().getValue(), view.getBlueSlider().getValue()));
            view.getStatusLabel().setText("Status: Farbe wurde als letztes geändert");
        }
    }

    public static void main(String[] args) {
        new Formen();
    }
}
