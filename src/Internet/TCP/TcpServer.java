package Internet.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpServer {
    private BufferedReader reader;                  //BufferedReader 对象
    private ServerSocket server;           //服务器socket 对象
    private Socket serverSocket;                   //客户端socket对象
    static final int port = 8998;
    static String localHostName;

    static {
        try {
            localHostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    static InetAddress localIP;

    static {
        try {
            localIP = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    void runServer() {
        try {
            server = new ServerSocket(port);  //创建服务器socket
            System.out.println("服务器socket已创建，端口: " + port);
            while (true) {
                System.out.println("等待客户端连接中...");
                serverSocket = server.accept();       //等待客户端连接，连接后返回与客户端连接的socket
                reader = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                //通过读取socket输入流初始化reader
                getClientMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getClientMessage() {
        try {
            while (true) {
                System.out.println("客户端信息: " + reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TcpServer tcpServer = new TcpServer();
        tcpServer.runServer();
    }
}

