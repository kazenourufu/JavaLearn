package Basic.ExceptionProcession;

public class Main {
    public static void main(String[] args){
        Test_1 t1 = new Test_1();
        Test_2 t2 = new Test_2();
        try {
            t2.doAnotherThing(6);
        } catch (MyException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("执行完毕");
        }




    }
}
