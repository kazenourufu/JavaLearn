package Basic.ExceptionProcession;

public class Test_1{
    public void doSth (int x) throws MyException{
        if(x>5){
            throw new MyException("输入超过限值");
        } else {
            System.out.println("Test_1.doSth成功执行");
        }
    }
}
