package SwingFrame;

import javax.swing.*;
import java.awt.*;

public class DrawIcon implements Icon {
    private int width;
    private int height;

    public DrawIcon(int width,int hight){
        this.width = width;
        this.height = hight;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}
