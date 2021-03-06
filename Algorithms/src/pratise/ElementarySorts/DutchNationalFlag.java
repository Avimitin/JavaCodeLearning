package pratise.ElementarySorts;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class DutchNationalFlag {
    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;
    private final int[] a;
    private final int len;

    public DutchNationalFlag(int N){
        a = new int[N];
        len = N;
    }

    public void swap(int i, int j){
        int pebble = a[i];
        a[i] = a[j];
        a[j] = pebble;
    }

    public void color(int i){
        a[i] = StdRandom.uniform(3);
    }

    public static void main(String[] args){
        DutchNationalFlag d = new DutchNationalFlag(20);
        // 往数组塞东西
        for (int i = 0; i < d.len; i++){
            d.color(i);
            StdOut.print(d.a[i]);
        }
        StdOut.print("\n");
        // 初始化三个指针
        int begin = 0;
        int end = d.len -1;
        int current = 0;
        // 过滤
        while(current <= end){
            switch (d.a[current]){
                case RED:
                    d.swap(current++, begin++);
                    continue;
                case WHITE:
                    current++;
                    continue;
                case BLUE:
                    d.swap(current, end--);
            }
        }
        for (int i = 0; i < d.len; i++){
            StdOut.print(d.a[i]);
        }
    }
}