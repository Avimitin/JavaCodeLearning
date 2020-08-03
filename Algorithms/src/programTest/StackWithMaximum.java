package programTest;

public class StackWithMaximum<Item> extends Stack<Item>{
    private int count;
    
    @Override
    public Item pop(){
        Item item = first.item;
        first = first.next;
        if (N > count) count = N;
        N--;
        return item;
    }

    public int getMaximum(){ return count; }
}