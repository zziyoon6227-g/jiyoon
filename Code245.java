import java.util.Comparator;
import java.util.TreeSet;

class Person3 {
    private int id;
    private int score;
    Person3(){}
    Person3(int id, int score){this.id=id; this.score=score;}
    int getId(){return id;}
    public String toString(){return "[id=" +id+ ",score=" +score+ "]";}
    }

    class Person3Comparator implements Comparator<Person3>{
        public int compare (Person3 o1, Person3 o2){
            return o1.getId() - o2.getId();
        }
    }


public class Code245 {
    public static void main(String[] args) {
        TreeSet<Person3> ts = new TreeSet<> (new Person3Comparator());
        ts.add(new Person3(4,83));
        ts.add(new Person3(5,90));
        ts.add(new Person3(2,93));
        ts.add(new Person3(1,88));
        ts.add(new Person3(3,70));
        for(Person3 p:ts)
        System.out.println(p);
    }
}
