package MultiThread;

public class ThreadTest extends Thread {
    private int count = 10;
    public void run(){
        while(true){
            System.out.print(count + " | ");
            if(count>5) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(--count==0)
                return;
        }
    }
}
