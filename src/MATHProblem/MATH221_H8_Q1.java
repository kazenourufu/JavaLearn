package MATHProblem;

public class MATH221_H8_Q1 {
    /*UBCStudent enjoys collecting antique loonie coins and counting problems. Their collection
    has gotten quite large and they are trying to arrange them nicely into groups.
        • If the coins are arranged in groups of 4 then there is 2 left over.
        • If the coins are arranged in groups of 5 then there are 3 left over.
        • If the coins are arranged in groups of 7 then there are 6 left over.
    What is the smallest number of coins there could be in their collection?
    */


    //A is the set that A={a:a=4m+2,m∈Z}
    int[] A = new int[1000];
    //B is the set that B={b:b=5n+3,n∈Z}
    int[] B = new int[1000];
    //C is the set that C={c:c=7k+6,k∈Z}
    int[] C = new int[1000];


    public  void initSets(){
        for (int m = 0; m < A.length; m++) {
            A[m] = 4*m+2;
        }

        for (int n = 0; n < B.length; n++) {
            B[n] = 5*n+3;
        }

        for (int k = 0; k <C.length; k++) {
            C[k] = 7*k+6;
        }
    }

    public int[] intersectSets() {
        int count = 0;
        int[] rst = new int[1000];
        for (int i = 0; i < A.length; i++) {
            int temp = A[i];
            for (int j = 0; j < B.length; j++) {
                if (temp == B[j]) {
                    for (int k = 0; k < C.length; k++) {
                        if (temp == C[k]) {
                            rst[count] = temp;
                            count++;
                        }
                    }
                }
            }
        }
        return rst;
    }

    public void printAll(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
            if(arr[i+1]==0)
                break;
        }
    }

    public static void main(String[] args) {
        MATH221_H8_Q1 q1 = new MATH221_H8_Q1();
        q1.initSets();
        q1.printAll(q1.intersectSets());
    }

}
