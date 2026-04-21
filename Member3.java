import java.util.Arrays;
public class Member3 implements Cloneable{
    
    public String name;
    public int age;
    public int[] scores;
    public Car8 car8;

    public Member3(String name, int age, int[] scores, Car8 car8){
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car8 = car8;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException { 
        Member3 cloned = (Member3) super.clone();
        cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
        cloned.car8= new Car8(this.car8.model);
        return cloned;
    }
    public Member3 getMember3(){
        Member3 cloned = null;
    try{
        cloned = (Member3) clone();
    }catch(CloneNotSupportedException e){
        e.printStackTrace();
    }
    return cloned;
}
}
