package Basic.FatherAndSon;

public class FatherAndSon {
    public static void main(String[] args){




        Test t = new Test();
        newTest nt = new newTest();
        System.out.println(t.getA());
        System.out.println(nt.getA());
        System.out.println(t.getStr());
        System.out.println(nt.getStr());

        //1. 当执行向下转型时，先用instanceof判断父类对象是否为子类实例
        Test a = new Test();
        newTest b = new newTest();
        newTest c;
        if(a instanceof  newTest){  //如果Test类的实例a是子类newTest的实例
            c = (newTest)a; //向下转型
        }







    }
}
