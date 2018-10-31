package _TEMP;

public  class lab {

    public static void main(String[] args) {
        System.out.println(new lab().changeAge(new People(999,"樱桃")));
        int[] arr = new int[100];
        System.out.println("arr[1]=" + arr[1]);
    }

    public  int changeAge(People p){
        p.setAge(999);
        try{
            doSomething();
            return 1;
        } catch (Exception e){
            System.out.println("异常捕获");
            return 2;
        } finally {
            return 5;
        }
    }

    public void doSomething() throws Exception {
        throw new Exception();
    }

}
