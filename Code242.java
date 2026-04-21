import java.util.Iterator;
import java.util.TreeSet;

public class Code242 {
    public static void main(String[] args) {
        int A[] = {4,6,1,9,8,10,5,2,3,7};
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i = 0; i<A.length; i++){
            ts.add(A[i]);
        }
            System.out.println(ts);

            Iterator<Integer> itr = ts.iterator();
            while(itr.hasNext()){
                System.out.print(itr.next() +" ");
            
        }
    
    }
}
