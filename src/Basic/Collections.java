package Basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Collections {
    public static void main(String[] args){
        HashSet<String> ints = new HashSet<String>();
        ints.add("a");
        ints.add("c");
        ints.add("d");
        ints.add("f");
        ints.add("SS");
        ints.add("ss");
        ints.add("nn");
        ints.add("n");
        ints.add("s");

        Iterator<String> ints_it = ints.iterator();

        while (ints_it.hasNext()){
            System.out.println(ints_it.next());
        }






    }
}
