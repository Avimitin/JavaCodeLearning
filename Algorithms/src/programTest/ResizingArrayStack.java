package programTest;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayStack<Item> extends FixedCapacityStack<Item> implements Iterable<Item>{
    /**
     * API:
     * 一个 Private 的栈
     * 一个元素数量的值
     * 查询栈是否为空的方法
     * 查询栈元素数量的方法
     * 变更栈大小的方法
     * 推入元素的方法
     * 弹出元素的方法
     * 一个迭代类
     */

    public ResizingArrayStack(){
        super(1);
    }

    public void resize(int max){
        Item[] newArray = (Item[]) new Object[max];

        for(int i = 0; i <= N; i++){
            newArray[i] = a[i];
        }
        // 将 a 指向新的数组
        a = newArray;
    }

    @Override
    public void push(Item item){
        if (N >= (a.length/4)*3){
            resize(a.length * 2);
        }

        a[N++] = item;
        
    }

    @Override
    public Item pop(){
        Item item = a[--N];
        a[N] = null;

        if (N>0 && N <= a.length/4){
            resize(a.length/2);
        }

        return item;
    }

    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;
        public boolean hasNext(){
            return i != 0;
        }

        public Item next(){
            return a[--i];
        }

        public void remove(){}
    }

    public static void main(String[] args){
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();

        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            
            if (!item.equals("-")){
                s.push(item);
            } else if (!s.isEmpty()){
                StdOut.print(s.pop() + " ");
            }
        }

        StdOut.print("\n还有" + s.size() + "个元素，分别是\n");
        for (String item : s){
            StdOut.print(item +" ");
        }
    }
}