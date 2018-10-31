package MultiThread;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SwingAndThread extends JFrame {
    private JLabel jLabel = new JLabel();
    private static Thread t;
    private int count = 0;
    private Container container = getContentPane();

    public SwingAndThread(){
        setBounds(300,200,250,100);
        container.setLayout(null);
        URL url = SwingAndThread.class.getResource("\\miao.png");
        Icon icon = new ImageIcon(url);
        jLabel.setIcon(icon);
        //设置图片在标签的最左边
        jLabel.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel.setBounds(10,10,20,50);
        jLabel.setOpaque(true);
        /*t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count<=200){
                    jLabel.setBounds(count,10,200,50);
                    try{
                        Thread.sleep(100);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    count+=5;
                    if(count == 200){
                        count = 10;
                    }
                }
            }
        });*/

        t = new MyThread();
        t.start();
        container.add(jLabel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SwingAndThread();
    }

    class MyThread extends Thread{

        public void run() {
            while (count<=200){
                jLabel.setBounds(count,10,200,50);
                try{
                    Thread.sleep(100);
                } catch (Exception e){
                    e.printStackTrace();
                }
                count+=5;
                if(count == 200){
                    count = 10;
                }
            }
        }
    }
}
