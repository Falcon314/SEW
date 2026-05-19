package jhahn.view;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {
    private Form form;
    private Color color;
    private boolean filled;

    public FormPanel(Form form, Color color, boolean filled) {
        this.form = form;
        this.color = color;
        this.filled = filled;
    }
    public void draw() {
        repaint();
    }
    public void clear() {
        this.form = Form.NONE;
        this.color = Color.WHITE;
        this.filled = true;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        g.setColor(this.color);
        int size = Math.min(getWidth()-2, getHeight());
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;
        switch(form) {
            case CIRCLE:
                if (filled) g.fillOval(x, y, size, size);
                else g.drawOval(x, y, size, size);
                break;
            case SQUARE:
                if (filled) g.fillRect(x, y, size, size);
                else g.drawRect(x, y, size, size);
                break;
            case TRIANGLE:
                int side = size;
                int height = (int)(Math.sqrt(3) / 2 * side);
                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int topY = centerY - height / 2;

                int[] xs = {
                        centerX,
                        centerX - side / 2,
                        centerX + side /2
                };
                int[] ys = {
                        topY,
                        topY + height,
                        topY + height
                };
                if (filled) g.fillPolygon(xs, ys, 3);
                else g.drawPolygon(xs, ys, 3);
                break;
            case NONE:
            default:
                break;
        }
    }

    public Form getForm() {
        return form;
    }
    public void setForm(Form form) {
        this.form = form;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) throws NullPointerException {
        if (color != null) {
            this.color = color;
        } else throw new NullPointerException("Color cannot be null");
    }

    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
