package IO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Buffer extends JFrame{
    private JPanel jContentPanel = null;
    private Container container = null;
    private JTextArea jta = null;
    private JPanel  controlPanel = null;
    private JButton openButton = null;
    private JButton closeButton = null;
    private JButton clearButton = null;

    public Buffer(){
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
            controlPanel = new JPanel(new GridLayout(1,3,5,5));
            controlPanel.add(getOpenButton());
            controlPanel.add(getCloseButton());
            controlPanel.add(getClearButton());
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
                        FileWriter out = new FileWriter(file);
                        BufferedWriter bfout = new BufferedWriter(out);
                        bfout.write(s);
                        bfout.newLine();
                        bfout.close();
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
                        FileReader in = new FileReader(file);
                        BufferedReader bfin = new BufferedReader(in);
                        String s;
                        while((s=bfin.readLine())!=null) {
                            getJTextArea().append(s);
                            getJTextArea().append("\n");
                        }
                        in.close();
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

    private void updateVisible(){
        this.setVisible(false);
        this.setVisible(true);
    }

}

class Buffer_Test{
    public static void main(String[] args) {
        new Buffer();
    }
}