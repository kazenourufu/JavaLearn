package Basic.Strings;

public class Strings {
    public static void main(String[] args){
        //1. 在字符串中，char[]等价于一个字符串
        char a[] = {'g','o','o','d',' ','b','o','y'};
        //等价于
        String a_ = "good";

        //2. 字符串也可以通过提取char[]中的一部分创建
        String str = new String(a,1,3); //offset:起始位置，count:选取数量
        System.out.println(str);

        //3. 也可以通过char[]直接创建
        String str2 = new String(a);
        System.out.println(str2);

        //4. 相同的字符串变量在引用相同字符串常量时，其实体相同
        String str_a = new String("good");
        String str_b = new String("good");
        String str_c = "boy";
        String str_d = "boy";
        System.out.println("str_a和str_b相同(equals)？："+ (str_a.equals(str_b)));
        System.out.println("str_a和str_b相同(==)？："+ (str_a==str_b));
        System.out.println("str_c和str_d相同(equals)？："+ (str_c.equals(str_d)));
        System.out.println("str_c和str_d相同(==)？："+ (str_c==str_d));

        //5. 字符串可以直接通过+来连接,可以连接其他数据类型
        String str_X = str_a+str_c+1;
        System.out.println("str_a+str_c+1 = " + str_X);

        //6. substring()含头不含尾
        String str_e = "good boy";
        String substr_e = str_e.substring(0,2);//[0][1]=go
        System.out.println("substr_e = [0]-[2] = " + substr_e);

        //7. 字符串替换：replace(char oldChar, char newChar);
        String str_f = "AABAA";
        String allA_str_f = str_f.replace('B','A');
        System.out.println("替换之后的str_f=" + allA_str_f);

        //8. 开头和结尾：startsWith(),endsWith()
        String str_g1 = "12345";
        String str_g2 = "oh my god";
        System.out.println("str_g1是以12开头的吗？" + str_g1.startsWith("12"));
        System.out.println("str_g2是以god结尾的吗？" + str_g2.endsWith("god"));

        //9. 在比较字符串内容并需要忽略大小写时，可以通过equalsIgnoreCase();
        String str_h1 = "AbCdEf";
        String str_h2 = "ABCDEF";
        System.out.println("AbCdEf 和 ABCDEF 相同吗（区分大小写）" + str_h1.equals(str_h2));
        System.out.println("AbCdEf 和 ABCDEF 相同吗（不区分大小写）" + str_h1.equalsIgnoreCase(str_h2));

        //10. compareTo()比较两个字符串的字典顺序，返回值为（x1-x2)，其中x1为参数字符的字典序号（Unicode编号）,x2为被比较字符的字
        //典编号。
        String str_i1 = "A";
        String str_i2 = "C";
        System.out.println("A compareTo C = " + str_i1.compareTo(str_i2));
        String str_i3 = "ABB";
        String str_i4 = "AGG";
        System.out.println("ABB compareTo AGG = " + str_i3.compareTo(str_i4));//当字符串比较时，比较第一个不同的字符

        //11. 字符串转大小写: toUpperCase(),toLowerCase();

        //12. 格式化字符串
        //  a) 日期和时间字符串的格式化
        //  b) format()为静态方法，可以直接从String类调

        //13. 字符串生成器
        //  a)若需要将string builder的结果作为字符串输出，可以使用toString
        //  b)常用的编辑方法：append(),insert(),delete()
        StringBuilder str_bld = new StringBuilder("good");
        str_bld.append(" ");
        str_bld.append("boy is me");
        System.out.println(str_bld.toString());
        str_bld.insert(11," not");
        System.out.println(str_bld.toString());
        str_bld.delete(11,15);
        System.out.println(str_bld.toString());








    }
}
