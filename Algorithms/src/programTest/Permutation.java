package programTest;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        if (k < 1) throw new IllegalArgumentException();
        Permutation p = new Permutation();
        Queue<String> q = p.new Queue<>();
        while (!StdIn.isEmpty()){
            String a = StdIn.readString();
            q.enQueue(a);
        }
        if (k > q.size()) throw new IllegalArgumentException();
        RandomizedQueue<String> r = new RandomizedQueue<>();
        for (String s : q){
            r.enqueue(s);
        }
        while(k!=0){
            StdOut.print(r.dequeue());
            k--;
        }
    }
    
    private class Queue<Item> implements Iterable<Item>{
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
    
        public Iterator<Item> iterator(){ return new QueueIterator();}
    
        private class QueueIterator implements Iterator<Item>{
            public boolean hasNext(){ return N>0;}
            public Item next(){
                Item item = first.item;
                first = first.next;
                if (isEmpty()){ last = null;}
                N--;
                return item;
            }
            public void remove(){}
        }
    }
}