package SwingFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MyJFrame extends JFrame {
    private Container container;
    LayoutManager defaultLayout;

    public MyJFrame(String title){
        super(title);
        container = getContentPane();
        defaultLayout = getLayout();
    }

    public void initFrame(){
        //初始化窗体的大小和可见
        setSize(1000,800);
        setVisible(true);
        //设置容器，并添加一个标签
        container.setBackground(Color.yellow);
        JLabel centerInfo = new JLabel("这是一个简单的JFrame窗体",SwingConstants.CENTER);
        container.add(centerInfo);
        //设置窗体默认关闭方式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void addTestJButton(){
        //关闭布局管理器（绝对布局）
        setLayout(null);

        //创建并定义按钮外观
        JButton jb = new JButton("测试按钮",new DrawIcon(25,25));
        jb.setBounds(500,400,150,50);

        //创建事件监听
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDialog(MyJFrame.this,"新建JDialog").setVisible(true);
            }
        };

        //绑定事件监听器
        jb.addActionListener(listener);

        //加入容器
        container.add(jb);
    }

    //添加图片标签
    public void addIconLabel(){
        setLayout(defaultLayout);
        URL url = MyJFrame.class.getResource("jb_icon.jpg");
        System.out.println(url);
        Icon icon = new ImageIcon(url);
        JLabel jl = new JLabel("这是一个图片标签",icon,SwingConstants.CENTER);
        container.add(jl);
        System.out.println("done");
        container.add(jl);
    }

    public void cleanContainer(){
        container.removeAll();
    }


}
