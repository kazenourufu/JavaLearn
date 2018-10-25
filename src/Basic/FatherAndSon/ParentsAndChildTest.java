package Basic.FatherAndSon;

public class ParentsAndChildTest {
    public static void main(String[] args){
        Parents p1 = new Parents();
        System.out.println("====================");
        Child c1 = new Child();
        System.out.println("====================");
        c1.fn_1();
        System.out.println("====================");
        Parents p2 = c1;


    }
}
