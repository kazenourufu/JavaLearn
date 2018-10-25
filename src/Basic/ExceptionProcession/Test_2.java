package Basic.ExceptionProcession;

public class Test_2 {
    Test_1 t = new Test_1();

    public void doAnotherThing (int x)throws MyException{
        t.doSth(x);
    }
}
