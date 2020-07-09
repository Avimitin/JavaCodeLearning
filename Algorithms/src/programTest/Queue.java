package programTest;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public int size(){ return N; }
    public boolean isEmpty(){ return N == 0;}

    public void enQueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()){
            first = last;
        } else oldLast.next = last;

        N++;
    }

    public Item deQueue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty()){ last = null;}
        N--;
        return item;
    }

    public static void main(String[] args){
        Queue<String> test = new Queue<String>();

        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                test.enQueue(item);
            } else if (!test.isEmpty()){
                StdOut.print(test.deQueue());
            }
        };

        StdOut.printf("还有剩余%d个元素", test.size());
    }
}
