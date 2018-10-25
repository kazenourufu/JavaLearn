package Basic;

public class BasicPoints {
    public static void main(String[] args){
        //一些不是很熟悉的语法知识点

        //1. 数据的转换
        //  a)数据的隐式转换
        //  b)数据的显式转换
        //  数据的显式转换可能会损失数据精度（强制转换）
        int a = (int)'我';

        //2. switch 语句
        //  a)当表达式=case常量时开始执行
        //  b)会执行到break语句为止
        //  c)default可选
        //  d)可选常值类型包括：char,String,int
        String str="小明";
        switch (str){
            case "小明":
                System.out.println("Ming");
                break;
            case "小王":
                System.out.println("Wang");
                break;
            case "赵先生":
                System.out.println("Zhao");
                break;
            default:
                System.out.println("查无此人");
        }

        //3. foreach 语句
        //  a)语法：for(元素变量 x:遍历对象 obj){引用了x的语句;}
        int arr[]={7,10,1};
        for(int x:arr) {
            System.out.println("当前数值为: " + x);
        }

        //4. break
        //  a)break语句可以用于中断while,do,for等语句。
        //  b)在遇到循环嵌套时，一个break只跳出一层循环
        //  c)可以使用标签功能跳出指定循环
        int sum=0;
        LOOP:for(int i=0;i<10;i++){ //LOOP为标签
            sum+=i;
            for (int x=10;x<5;x--){
                System.out.println(x);
                if(x<7)
                    break LOOP;//LOOP为标签
            }
        }

        //5. continue
        //  a) continue是break的补充，会略过本次循环剩下的语句，重新回到条件判断。
        //  b) 对于for loop, continue会先执行i++，后进行条件判断
        //  c) continue 也可以使用标签
        sum=0;
        LOOP:for(int i=0;i<10;i++){ //LOOP为标签
            sum+=i;
            for (int x=10;x<5;x--){
                System.out.println(x);
                if(x<7)
                    continue LOOP;//LOOP为标签
            }
        }

        //6.不定长参数
        //  a)  doSomeThing(int...a),编译器会将数个int当做array处理
        //  b)  int...a 可以看做int[] a, a看做array处理即可
    }
}
