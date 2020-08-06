
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item>{
    private Item[] array;
    private int amount;

    public RandomizedQueue(){
        array = (Item[])new Object[5];
    }

    public boolean isEmpty(){ return amount <= 0; }

    public int size(){ return amount; }

    public void enqueue(Item item){
        if (item == null) throw new IllegalArgumentException();
        if (amount >= array.length/2){
            Item[] newArray = (Item[])new Object[array.length*2];
            for (int i = 0; i < array.length; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[amount++] = item;
    }

    public Item dequeue(){
        if (isEmpty()){ throw new NoSuchElementException(); }
        int ranNum = StdRandom.uniform(array.length);
        while (array[ranNum] == null){
            ranNum = StdRandom.uniform(array.length);
        }
        Item item = array[ranNum];
        array[ranNum] = null;
        amount--;
        return item;
    }

    public Item sample(){
        if (isEmpty()){ throw new NoSuchElementException(); }
        int ranNum = StdRandom.uniform(array.length);
        while (array[ranNum] == null){
            ranNum = StdRandom.uniform(array.length);
        }
        return array[ranNum];
    }

    public Iterator<Item> iterator(){ return new ArrayIterator(); }

    private class ArrayIterator implements Iterator<Item>{
        public boolean hasNext(){ return amount > 0; }

        public Item next(){
            if (isEmpty()){ throw new NoSuchElementException(); }
            int ranNum = StdRandom.uniform(array.length);
            while (array[ranNum] == null){
                ranNum = StdRandom.uniform(array.length);
            }
            Item item = array[ranNum];
            array[ranNum] = null;
            amount--;
            return item;
        }

        public void remove(){throw new UnsupportedOperationException(); }
    }

    public static void main(String[] args){
        int[] testArray = {1,2,3,4,5};
        RandomizedQueue<Integer> r = new RandomizedQueue<>();
        for (int i : testArray){
            r.enqueue(i);
        }
        StdOut.print(r.dequeue());
        for (int i : r){
            StdOut.print(i);
        }
    }
}