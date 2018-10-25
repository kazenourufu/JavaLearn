package SwingFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.concurrent.Flow;

public class MyJFrameComponents extends JFrame {
    Container container;

    public MyJFrameComponents(){
        container = getContentPane();
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        container.setBackground(Color.pink);
    }

    public void testButton(){
        container.removeAll();
        setLayout(new GridLayout(1,2,50,50));
        URL url = MyJFrameComponents.class.getResource("icon_2.png");
        Icon icon = new ImageIcon(url);
        //创建第一个按钮
        JButton jb_1 = new JButton("按钮1",icon);
        JButton jb_2 = new JButton();

        jb_1.setMaximumSize(new Dimension(20,20));
        jb_2.setMaximumSize(new Dimension(20,20));
        jb_2.setIcon(icon);
        jb_2.setHideActionText(true);
        jb_2.setToolTipText("图片按钮");
        jb_2.setBorderPainted(false);
        jb_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"成功！");
            }
        });
        container.add(jb_1);
        container.add(jb_2);
    }

    public void testComboBox(){
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        container.removeAll();
        JLabel jl = new JLabel("请选择你的出生地");
        JComboBox<String> jc = new JComboBox<>(new MyComboBox());
        container.add(jc);
        container.add(jl);
    }

    public void testJList(){
        container.removeAll();
        setLayout(new FlowLayout());
        JList<String> jl = new JList<String>(new MyListModel());
        JScrollPane jp = new JScrollPane(jl);
        container.add(jl);
    }

    public void testJText(){
        container.removeAll();
        setLayout(new FlowLayout());
        JTextField jt = new JTextField("JTextField文本",20);
        jt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setText("触发事件");
            }
        });
        JButton jb = new JButton("清除");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setText("");
                jt.requestFocus();
            }
        });
        container.add(jt);
        container.add(jb);
    }


}
