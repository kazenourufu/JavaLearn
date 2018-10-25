package IO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class DataIOStream extends JFrame {
    private JPanel jContentPanel = null;
    private Container container = null;
    private JTextArea jta = null;
    private JPanel  controlPanel = null;
    private JButton openButton = null;
    private JButton closeButton = null;
    private JButton clearButton = null;
    private JButton deleteButton = null;

    public DataIOStream(){
        super("文件输入输出测试器");
        init();
    }

    private void init(){
        if(container == null)
            container = getContentPane();
        container.setBackground(Color.WHITE);
        container.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        container.add(getContentPanel());
        setSize(500,500);
        setBackground(Color.pink);
        setVisible(true);
        updateVisible();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JPanel getContentPanel(){
        if(jContentPanel == null){
            jContentPanel = new JPanel(new BorderLayout());
            jContentPanel.add(getJTextArea(),BorderLayout.CENTER);
            jContentPanel.add(getControlPanel(),BorderLayout.SOUTH);
        }
        return jContentPanel;
    }

    private Component getControlPanel() {
        if(controlPanel == null){
            controlPanel = new JPanel(new GridLayout(1,4,5,5));
            controlPanel.add(getOpenButton());
            controlPanel.add(getCloseButton());
            controlPanel.add(getClearButton());
            controlPanel.add(getDeleteButton());
        }
        return controlPanel;
    }

    private JTextArea getJTextArea() {
        if(jta == null){
            jta = new JTextArea(20,40);
        }
        jta.setBackground(Color.gray);
        return jta;
    }

    private JButton getOpenButton(){
        if(openButton==null){
            openButton = new JButton();
            openButton.setText("写入文件");
            openButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File(JavaIO.address,"带缓存的文档编辑器储存池.txt");
                    String s = getJTextArea().getText();
                    try {
                        FileOutputStream out = new FileOutputStream(file);
                        DataOutputStream dout = new DataOutputStream(out);
                        dout.writeUTF(s);//使用UTF写入数据
                        //dout.writeChars(s); //使用Chars写入数据
                        //dout.writeBytes(s); //使用Bytes写入数据
                        dout.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
        return openButton;
    }

    private JButton getCloseButton(){
        if(closeButton == null){
            closeButton = new JButton();
            closeButton.setText("读取文件");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File(JavaIO.address,"带缓存的文档编辑器储存池.txt");
                    try {
                        FileInputStream in = new FileInputStream(file);
                        DataInputStream din = new DataInputStream(in);
                        String s = din.readUTF();//使用UTF读取数据
                        getJTextArea().append(s);
                        getJTextArea().append("\n");
                        din.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
        return closeButton;
    }

    private JButton getClearButton(){
        if(clearButton == null){
            clearButton = new JButton();
            clearButton.setText("清除内容");
            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getJTextArea().setText("");
                }
            });
        }
        return clearButton;
    }

    private JButton getDeleteButton(){
        if(deleteButton == null){
            deleteButton = new JButton();
            deleteButton.setText("删除文件！");
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File(JavaIO.address,"带缓存的文档编辑器储存池.txt");
                    if(file.exists()) {
                        System.out.println("准备销毁");
                        file.delete();
                    }
                }
            });
        }
        return deleteButton;
    }

    private void updateVisible(){
        this.setVisible(false);
        this.setVisible(true);
    }

}

class DataIOStreamTest{
    public static void main(String[] args) {
        new DataIOStream();
    }
}
