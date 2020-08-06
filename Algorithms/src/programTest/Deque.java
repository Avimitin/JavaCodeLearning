import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item>{
    private int N;
    private Node first;
    private Node last;

    private class Node{
        Node front;
        Node next;
        Item item;
    }

    public Deque(){
        first = new Node();
        last = new Node();
    }

    public int size() { return N; }
    public boolean isEmpty() { return N==0;}

    public void addFirst(Item item){
        if (item == null) throw new IllegalArgumentException("NULL IS INVALID!");
        Node oldFirst = first;
        // reclaim new node
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public void addLast(Item item){
        if (item == null) throw new IllegalArgumentException("NULL IS INVALID!");
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.front = oldLast;
        last.next = null;
        N++;
    }

    public Item removeFirst(){
        if (N == 0) throw new NoSuchElementException("EMPTY QUEUE!");
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item removeLast(){
        if (N == 0) throw new NoSuchElementException("EMPTY QUEUE!");
        Item item = last.item;
        last = last.front;
        N--;
        return item;
    }

    public static void main(String[] args){
        Deque<String> Array = new Deque<>();
        String[] testArray = {"1", "2", "3", "-", "-"};
        for (String item : testArray){
            if (item == "-"){
                String removeItem = Array.removeLast();
                StdOut.print(removeItem);
            } else {
                Array.addLast(item);
            }
        }
    }

    public Iterator<Item> iterator(){ return new DequeIterator(); }

    private class DequeIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){return current != null;}
        public Item next(){
            if (!hasNext()) throw new NoSuchElementException("EMPTY QUEUE");
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){ throw new UnsupportedOperationException("THIS METHOD IS INAVALIABLE!"); }
    }
}