import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Dialog
 */
public class Dialog {


    public static void main(String[] args) {
        DoppelVerketteteListe<Integer> dll = new DoppelVerketteteListe<Integer>();
        dll.add(0);
        dll.add(1);
        dll.add(456);
        dll.add(3);
        dll.add(234);
        dll.add(3);
        dll.add(4);

        System.out.println(
            Arrays.toString(dll.toArray(new Integer[dll.size()]))
        );
    }
}