package Basic;

public class STU implements Comparable<Integer>{
    int id;
    String name;

    public STU(int id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
