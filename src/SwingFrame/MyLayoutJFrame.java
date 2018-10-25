package SwingFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyLayoutJFrame extends JFrame {
    Container container;

    public MyLayoutJFrame(String title){
        super(title);
        container=getContentPane();

        container.setBackground(Color.pink);
        setSize(1000,800);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setFlowLayout(int alignment){
        cleanContainer();
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        for(int i=0;i<10;i++){
            container.add(new JButton("第"+i+"个按钮"));
        }
    }

    public void setBorderLayout(){
        cleanContainer();

        String[] positions = {BorderLayout.CENTER,BorderLayout.EAST,BorderLayout.WEST,
                BorderLayout.SOUTH,BorderLayout.NORTH};
        setLayout(new BorderLayout());
        for(int i=0;i<positions.length;i++){
            container.add(positions[i],new JButton(positions[i]+"按钮"));
        }
    }

    public void setGridLayOut(int rows, int columns,int horizGap, int vertGap){
        cleanContainer();
        setLayout(new GridLayout(rows,columns,horizGap,vertGap));
        for(int i = 0; i<rows;i++){
            for(int j = 0; j<columns+10; j++){
                container.add(new JButton("这是第"+(i+1)+"行第"+(j+1)+"个按钮"));
            }
        }
    }

    public void setPanels(){
        cleanContainer();
        setLayout(new GridLayout(2,2,10,10));
        JPanel p1 = new JPanel(new GridLayout(2,2,10,10));
        JPanel p2 = new JPanel(new BorderLayout());
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        for(int i=0;i<4;i++){
            p1.add(new JButton("面板1："+i));
        }

            p2.add(new JButton("面板2"),BorderLayout.NORTH);
            p2.add(new JButton("面板2"),BorderLayout.SOUTH);

        for(int i=0;i<6;i++){
            p3.add(new JButton("面板3："+i));
        }
        container.add(p1);
        container.add(p2);
        container.add(p3);


    }

    public void setScrollPanel(){
        cleanContainer();
        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        container.add(jsp);
    }

    public void cleanContainer(){
        container.removeAll();
    }
}
