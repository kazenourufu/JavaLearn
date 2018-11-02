package 剑指Offer;

/*
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Q1 {

    public boolean Find(int target, int[][] array) {
        int width = array[0].length;
        int height = array.length;
        //判断数组是否为空
        if (width == 0)
            return false;
        int i = height - 1;
        int j = 0;
        //从左下角开始遍历
        while (i >= 0 && j < width) {
            //如果相等输出结果
            if (array[i][j] == target) {
                return true;
            }
            //如果小于target，向右移动
            if (array[i][j] < target) {
                j++;
                continue;
            }
            //如果大于target，向上移动
            if (array[i][j] > target) {
                i--;
            }
        }
        //遍历超出边界，target不存在
        return false;
    }
}
