import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        AList<Integer> arr1 = new AList<Integer>();

        arr1.add(9);
        arr1.add(15);
        arr1.add(61);
        arr1.add(45);
        arr1.add(70);
        arr1.remove(4);
        arr1.add(90);
        arr1.add(111);
        arr1.add(7);
        arr1.add(1);
        arr1.add(17);
        System.out.println(arr1);
        arr1.bubbleSort();
    }
}





        //arr1.quickSort();

             /*Comparator integerComparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 == null) {
                    return 0;
                }
                if (o2 == null){
                    return -1;
                }
                int integer1 = (Integer) o1;
                int integer2 = (Integer) o2;
                if (integer1 > integer2){
                    return 1;
                }
                if (integer1 < integer2){
                    return -1;
                }
                return 0;
            }
        };*/




