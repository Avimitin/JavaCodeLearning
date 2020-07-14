package programTest;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;


public class Stack<Item> implements Iterable<Item>{
    private int N;
    private Node first;

    private class Node{
        Item item;
        Node next;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N ++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N --;
        return item;
    }

    public Item peek(){
        return first.item;
    }

    public int size(){
        return N;
    }
    public boolean isEmpty(){ return N == 0;}

    public static void main(String[] args){
        Stack<String> test = new Stack<String>();

        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                test.push(item);
            } else if (!test.isEmpty()){
                StdOut.print(test.pop());
            }
        };

        StdOut.printf("还有剩余%d个元素", test.size());
    }

    public Iterator<Item> iterator(){ return new StackIterator();}

    private class StackIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() { return current != null; }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){}
    }
}