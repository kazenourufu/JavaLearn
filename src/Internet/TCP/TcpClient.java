package Internet.TCP;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient extends JFrame {
    private PrintWriter writer;
    Socket clientSocket;
    private JTextArea ta = new JTextArea();
    private JTextField tf = new JTextField();
    Container container;

    public TcpClient(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = this.getContentPane();
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        container.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        container.add(tf, BorderLayout.SOUTH);
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writer.println(tf.getText());
                ta.append(tf.getText() + "\n");
                ta.setSelectionEnd(ta.getText().length());
                tf.setText("");
            }
        });
    }

    private void connect() {
        ta.append("正在尝试连接\n");
        try {
            clientSocket = new Socket(InetAddress.getLocalHost().getHostName(), TcpServer.port);//TODO
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            ta.append("连接成功！\n");
            System.out.println("服务器信息：");
            System.out.println("名称：" + TcpServer.localHostName);
            System.out.println("IP：" + TcpServer.localIP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        TcpClient client = new TcpClient("发送数据");
        client.setSize(200, 200);
        client.setVisible(true);
        client.connect();


    }
}
