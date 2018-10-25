package SwingFrame;

import javax.swing.*;

public class MyListModel extends AbstractListModel<String> {
    String[] content = {"服务器列表1","服务器列表2","服务器列表3","服务器列表4","服务器列表5","服务器列表6","服务器列表7"};

    @Override
    public int getSize() {
        return content.length;
    }

    @Override
    public String getElementAt(int index) {
        return content[index];
    }
}
