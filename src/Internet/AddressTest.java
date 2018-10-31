package Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressTest {
    public static void main(String[] args) {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            String localName = ip.getHostName();
            String localip = ip.getHostAddress();
            System.out.println("本机名：" + localName);
            System.out.println("本机IP地址：" + localip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
