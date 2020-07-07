package programTest;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStack<Item>{
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap){
        a = (Item[]) new Object[cap];
    }

    public void push(Item item){
        a[N++] = item;
    }

    public Item pop(){
        return a[--N];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public static void main(String[] args){
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(5);

        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }

        StdOut.printf("\nStill Have %d Items In Stack", s.size());
    }
}