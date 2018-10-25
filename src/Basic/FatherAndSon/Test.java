package Basic.FatherAndSon;

public class Test {
    int a;
    int b;
    String str;

    public Test(){
        a = 1;
        b = 2;
    }

    public void doSomeThing(){

    }

    public Test doAnotherThing(){
        return new Test();
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public String getStr(){
        return str;
    }


}
