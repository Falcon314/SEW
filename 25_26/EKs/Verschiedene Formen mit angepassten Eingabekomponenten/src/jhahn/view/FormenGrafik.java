package jhahn.view;

import javax.swing.*;
import java.awt.*;
public class FormenGrafik extends JPanel {
    private Form form;
    private Color color;
    private Dimension dm;
    private boolean filled;

    public FormenGrafik(Form form, Color color, boolean filled, Dimension dm) {

        this.form = form;
        this.color = color;
        this.filled = filled;
        this.dm = dm;
        setPreferredSize(new Dimension(200,250));
        setMaximumSize(new Dimension(200,250));
        setMaximumSize(new Dimension(200,250));
        setBackground(Color.WHITE);
    }
    public void setColor(Color color) {
        this.color = color;
        repaint();
    }
    public void setForm(Form form) {
        this.form = form;
        repaint();
    }
    public void setDimension(Dimension dm) {
        this.dm = dm;
        repaint();
    }
    public void toggleFilled(boolean checked) {
        this.filled = checked;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        int xCenter = getWidth()/2;
        int yCenter = getHeight()/2;
        int width = (int)dm.getWidth();
        int height = (int)dm.getHeight();
        switch (form) {
            case RECTANGLE:
                if (filled) g.fillRect(xCenter-(width/2),yCenter-(height/2), width, height);
                else g.drawRect(xCenter-(width/2),yCenter-(height/2), width, height);
                break;
            case TRIANGLE:
                int[] xTriangle = {xCenter-(width/2), xCenter+(width/2), xCenter+(width/2)};
                int[] yTriangle = {yCenter-(height/2), yCenter-(height/2), yCenter+(height/2)};
                if (filled) g.fillPolygon(xTriangle, yTriangle, 3);
                else g.drawPolygon(xTriangle, yTriangle, 3);
                break;
            case RHOMBUS:
                int[] xRhombus = {xCenter, xCenter+(width/2), xCenter, xCenter-(width/2)};
                int[] yRhombus = {yCenter-(height/2), yCenter, yCenter+(height/2),yCenter};
                if (filled) g.fillPolygon(xRhombus, yRhombus, 4);
                else g.drawPolygon(xRhombus, yRhombus, 4);
        }
    }
}
