package SwingFrame;

import javax.swing.*;

public class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String> {
    String selectedItem = null;
    String[] test = {"艾泽拉斯","艾欧泽亚","艾欧尼亚"};

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (String)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return test.length;
    }

    @Override
    public String getElementAt(int index) {
        return test[index];
    }
}
