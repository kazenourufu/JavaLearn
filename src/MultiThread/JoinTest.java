package MultiThread;

import javax.swing.*;
import java.awt.*;

public class JoinTest extends JFrame {
    private Thread thread_A;
    private Thread thread_B;
    final JProgressBar jbar1 = new JProgressBar();
    final JProgressBar jbar2 = new JProgressBar();
    int count = 0;

    public static void main(String[] args) {
        init(new JoinTest(), 100,100);
    }

    public static void init(JFrame frame, int width, int height){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setVisible(true);
    }

    public JoinTest(){
        super();
        getContentPane().add(jbar1,BorderLayout.NORTH);
        getContentPane().add(jbar2,BorderLayout.SOUTH);
        jbar1.setStringPainted(true);
        jbar2.setStringPainted(true);
        thread_A = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true){
                    jbar1.setValue(++count);
                    try {
                        Thread.sleep(100);
                        thread_B.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread_A.start();
        thread_B = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true){
                    jbar2.setValue(++count);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(count==100)
                        break;
                }
            }
        });
        thread_B.start();
    }
}
