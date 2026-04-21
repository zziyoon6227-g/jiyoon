import java.util.Stack;
public class Code237 {

    public static void main(String[] args) {
        
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        Integer data = stk.pop();
        System.out.println("you popped : "+data);
        stk.push(40);


        while(!stk.empty())
        System.out.println(stk.pop());
    }
}
