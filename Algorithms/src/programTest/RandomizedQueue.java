package programTest;

import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> {
    private class Node{
        Item item;
        Node next;
    }
    private Node first;
    private Node last;
    private int amount;

    public RandomizedQueue(){
        first = new Node();
        last = new Node();
    }

    public boolean isEmpty(){ return amount <= 0; }

    public int size(){ return amount; }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        amount++;
    }

    public Item dequeue(){
        if (isEmpty()){ throw new NoSuchElementException(); }
        else if (amount == 1){
            Item item = first.item;
            last = null;
            first = last;
            amount --;
            return item;
        }
        else{
            int num = StdRandom.uniform(amount);
            Node randomNodeFront = first;
            while (num != 0){
                randomNodeFront = randomNodeFront.next;
            }
            Node randomNode = randomNodeFront.next;
            Item item = randomNode.item;
            randomNodeFront.next = randomNode.next;
            randomNode = null;
            amount--;
            return item;
        }
    }
}