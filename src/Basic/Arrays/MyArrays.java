package Basic.Arrays;
import java.util.Arrays;

public class MyArrays {
    public static void main(String[] args){
        //1. 数组的声明
        int[] arrOfInt = new int[5];

        //2. 数组的初始化
        int[] arr_a1 = {1,2,3,4,10};
        int[] arr_a2 = new int[]{3,5,6,7};

        //3. 二维数组
        //  a)直接为每一维分配内存
        int[][] arr_b1 = new int[4][8];
        //  b)分别为每一维分配内存
        int[][] arr_b2 = new int[4][];
        arr_b2[0] = new int[3];
        arr_b2[1] = new int[4];

        //4. 填充数组元素
        int[] arr_c = new int[10];
        Arrays.fill(arr_c,1);
        printarr(arr_c);

        //5. 排序
        Arrays.sort(arr_a1);

        //6. 复制
        int[] arr_d1 = Arrays.copyOf(arr_a1,3);
        int[] arr_d2 = Arrays.copyOfRange(arr_a2,2,5);
        printarr(arr_d1);
        printarr(arr_d2);


        //7. 数组的查询
        // (a)binarySearch
        int index = Arrays.binarySearch(arr_a1,2);
        System.out.println("2的位置是:"+index);
        index = Arrays.binarySearch(arr_a1,0,1,3);
        System.out.println("3l;的位置是:"+index);
    }



    private static void printarr(int[] arr){
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
