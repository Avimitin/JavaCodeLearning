package pratise.Test1_3;

import programTest.Stack;
import java.util.Iterator;


public class Test1_3_12 implements Iterable<String>{
    static Stack<String> a = new Stack<>();

    public static Stack<String> copy(Stack<String> stack){
        while (!stack.isEmpty()){
            a.push(stack.pop());
        }
        return a;
    }

    public Iterator<String> iterator(){
        return new testIterator();
    }

    private class testIterator implements Iterator{
        public boolean hasNext() { return !(a.isEmpty());}
        public String next(){ return a.pop(); }
        public void remove(){};
    }
}
