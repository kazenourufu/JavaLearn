package Basic.Number;

import java.text.DecimalFormat;

public class FormatProcess {
    private static String DecimalForm(String pattern, double value){
        DecimalFormat myForm = new DecimalFormat(pattern);
        myForm.setGroupingSize(1);
        String rst = myForm.format(value);
        return rst;
    }

    //1. Decimal Format
    public static void main(String[] args){
        String pattern = "###,###,###.###";
        System.out.println(DecimalForm(pattern,12321431.22321));
    }

    //2.

}
