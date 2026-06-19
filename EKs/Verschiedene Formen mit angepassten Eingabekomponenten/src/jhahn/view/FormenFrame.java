package jhahn.view;

import jhahn.controller.Formen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

public class FormenFrame extends JFrame {
    private FormenGrafik formenGrafik;
    private JRadioButton[] rBtns = new JRadioButton[3];
    private JCheckBox cb;
    private JSlider[] sliders = new JSlider[3];
    private JTextField[] tf = new JTextField[2];
    private JLabel status;

    public FormenFrame(Formen controller) {
        setTitle("Verschiedene Formen Hahn Jason");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(550,300));
        setResizable(false);
        this.setLayout(new BorderLayout());

        formenGrafik = new FormenGrafik(Form.TRIANGLE, Color.BLACK, true, new Dimension(50,50));

        Font font = new Font("Arial", Font.PLAIN, 20);
        for (int i = 0; i < tf.length; i++) {
            tf[i] = new JTextField();
            tf[i].setHorizontalAlignment(JTextField.CENTER);
            tf[i].setFont(font);
            tf[i].setText("50");
            tf[i].setPreferredSize(new Dimension(100, 30));
            tf[i].setMinimumSize(new Dimension(100, 30));
            tf[i].setMaximumSize(new Dimension(100, 30));
        }

        JPanel cp = new JPanel();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel row41 = new JPanel();
        row41.setLayout(new BoxLayout(row41, BoxLayout.Y_AXIS));
        JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        row1.add(new JLabel("Form: "));
        rBtns[0] = new JRadioButton("Dreieck", true);
        rBtns[1] = new JRadioButton("Raute");
        rBtns[2] = new JRadioButton("Rechteck");
        rBtns[0].addActionListener(controller);
        rBtns[1].addActionListener(controller);
        rBtns[2].addActionListener(controller);
        ButtonGroup formBtns = new ButtonGroup();
        formBtns.add(rBtns[0]);
        formBtns.add(rBtns[1]);
        formBtns.add(rBtns[2]);
        row1.add(rBtns[0]);
        row1.add(rBtns[1]);
        row1.add(rBtns[2]);

        row2.add(new JLabel("Höhe"));
        row2.add(tf[0]);
        row3.add(new JLabel("Breite:"));
        row3.add(tf[1]);

        row4.add(new JLabel("Farbe:"));
        row4.add(row41);
        sliders[0] = new JSlider(0, 255,0);
        sliders[1] = new JSlider(0, 255,0);
        sliders[2] = new JSlider(0, 255,0);
        sliders[0].addChangeListener(controller);
        sliders[1].addChangeListener(controller);
        sliders[2].addChangeListener(controller);
        row41.add(new JLabel("Red"));
        row41.add(sliders[0]);
        row41.add(new JLabel("Green"));
        row41.add(sliders[1]);
        row41.add(new JLabel("Blue"));
        row41.add(sliders[2]);

        row5.add(new JLabel("Füllung:"));
        cb = new JCheckBox("Gefüllt", true);
        cb.addActionListener(controller);
        row5.add(cb);

        cp.add(row1);
        cp.add(row2);
        cp.add(row3);
        cp.add(row4);
        cp.add(row5);



        JPanel statusPanel = new JPanel(new BorderLayout());
        status = new JLabel("Status: Bereit", SwingConstants.LEFT);
        statusPanel.add(status);
        add(formenGrafik, BorderLayout.WEST);
        add(cp, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);





        setVisible(true);
        setSize(500, 300);
    }





    public JRadioButton[] getRadioBtns() {
        return this.rBtns;
    }
    public JTextField[] getTextFields() {
        return this.tf;
    }
    public JSlider getRedSlider() {
        return sliders[0];
    }
    public JSlider getGreenSlider() {
        return sliders[1];
    }
    public JSlider getBlueSlider() {
        return sliders[2];
    }
    public JLabel getStatusLabel() {
        return status;
    }

    public FormenGrafik getFormenGrafik() {
        return this.formenGrafik;
    }
}
