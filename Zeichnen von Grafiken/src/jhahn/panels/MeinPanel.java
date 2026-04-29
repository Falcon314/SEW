package jhahn.panels;

import javax.swing.*;
import java.awt.*;

public class MeinPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        int x = getWidth();
        int y = getHeight();
        int halfX = (int) x / 2;
        int halfY = (int) y / 2;
        for (int i = 0; i < 8; i++) {
            g.drawArc(10+(i*10), 10, x-(20+(i*20)), y-20, 0, 360);
        }
        g.drawLine(halfX,10, halfX,y-10);
        for (int i = 0; i < 8; i++) {
            g.drawRect(10+(i*10), 10, x-(20+(i*20)), y-20);
        }
    }
}
