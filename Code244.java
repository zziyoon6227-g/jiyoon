import java.util.Iterator;
import java.util.TreeSet;

class Person2 implements Comparable<Person2>{

    private int id;
    private int score;
    Person2(){}
    Person2(int id, int score){this.id=id; this.score=score;}
    public String toString(){return "[id=" +id+ ",score=" +score+ "]";}
    public int compareTo(Person2 p){
        return this.id - p.id;

    }
}

public class Code244 {
    public static void main(String[] args) {
        TreeSet<Person2> ts = new TreeSet<>();
        ts.add(new Person2(3,83));
        ts.add(new Person2(5,90));
        ts.add(new Person2(1,93));
        ts.add(new Person2(2,88));
        ts.add(new Person2(4,70));

        Iterator<Person2> itr = ts.iterator();
        while(itr.hasNext())
        System.out.println(itr.next());
    }
}
