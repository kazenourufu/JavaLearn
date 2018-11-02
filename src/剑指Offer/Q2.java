package 剑指Offer;

public class Q2 {
    public String replaceSpace(StringBuffer str) {
        //length为字符串原始长度
        int length = str.length();
        //numSpace用于储存空格个数
        int numSpace = 0;
        //遍历字符串，统计空格个数
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ')
                numSpace++;
        }
        //当字符串中没有空格的时候直接输出原字符串（在没有空格的时候提高效率，无实际意义）
        if(numSpace==0)
            return str.toString();
        //新字符串长度应该 = 原来的长度 + 空格的个数 * 2
        int newLength = numSpace*2 + length;
        //重新设定字符串长度为新的长度
        str.setLength(newLength);
        //Java中没有用于表示字符串结尾的"/0"，所以直接从最后一位index开始遍历(从index = length-1开始）
        newLength--;
        for (int i = length-1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(newLength--, '0');
                System.out.println(str.toString());
                str.setCharAt(newLength--, '2');
                System.out.println(str.toString());
                str.setCharAt(newLength--, '%');
                System.out.println(str.toString());
            } else {
                str.setCharAt(newLength--, str.charAt(i));
                System.out.println(str.toString());
            }

        }
        return str.toString();
    }
}
