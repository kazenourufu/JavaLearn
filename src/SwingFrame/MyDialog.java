package SwingFrame;

import javax.swing.*;
import java.awt.*;

public class MyDialog extends JDialog {
    Container container;

    public MyDialog(JFrame frame, String title){
        super(frame,title,true);
        container = getContentPane();
        JLabel jl = new JLabel("这是一个JDialog窗口",SwingConstants.CENTER);
        container.add(jl);
        setBounds(400,500,500,500);
    }
}
