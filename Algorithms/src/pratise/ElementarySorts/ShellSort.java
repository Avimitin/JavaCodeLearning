package pratise.ElementarySorts;

import edu.princeton.cs.algs4.StdOut;

public class ShellSort{
    public boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    public void exchange(Comparable[] a, int i, int j){
        Comparable current = a[i];
        a[i] = a[j];
        a[j] = current;
    }

    public boolean isSorted(Comparable[] a){
        for (int i=1; i<a.length; i++){
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public void sort(Comparable[] a){
        int len = a.length;
        int h = 0;
        while (h < len/3) h = 3*h+1;
        while (h >= 1){
            for (int i = h; i < len; i++){
                // 把 j 起始值设置在最末端i，每次 -h 往前比对直到达到最小的间隔角标 h
                for (int j = i; j >= h && less(j, j-h); j-=h){
                    exchange(a, j, j-h);
                }
            }
            h/=3;
        }
    }
    
    public static void main(String[] args){
        ShellSort s = new ShellSort();
        boolean a = s.less('g', 'c');
        StdOut.print(a);
    }
}