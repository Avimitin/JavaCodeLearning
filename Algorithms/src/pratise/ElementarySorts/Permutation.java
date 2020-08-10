package pratise.ElementarySorts;

import edu.princeton.cs.algs4.StdOut;
import programTest.StopWatch;

public class Permutation {
    // Target: Confirm array a is permutation of array b
    public boolean less(int i, int j){
        return i < j;
    }
    
    public void exch(int i, int j, int[] a){
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public boolean isSorted(int[] a){
        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i-1]){
                return false;
            }
        }
        return true;
    }

    public int[] sort(int[] a){
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h +1;
        while (h >= 1){
            for (int i = h; i < N; i++){
                for (int j = i; j >=h && less(a[j], a[j-h]); j-=h){
                    exch(j, j-h, a);
                }
            }

            h/=3;
        }
        return a;
    }

    public boolean isPermutation(int[] a, int[] b){
        int[] bigger;
        int[] smaller;
        if (a.length >= b.length){
            bigger = a;
            smaller = b;
        } else {
            bigger = b;
            smaller = a;
        }

        boolean val = false;

        for (int num : smaller){
            val = false;
            for (int num2 : bigger){
                if (num == num2){
                    val = true;
                    break;
                }
            }
        }
        return val;
    }

    public static void main(String[] args){
        // initialize
        int[] a = {3, 5, 8, 9, 2, 4, 1, 7, 6, 0};
        int[] b = {3, 5, 8, 9, 2, 4, 1};
        Permutation p = new Permutation();
        // sort and count time
        StopWatch s = new StopWatch();
        a = p.sort(a);
        b = p.sort(b);
        // judge
        if (p.isSorted(a)) StdOut.print("a IS SORTED\n");
        if (p.isSorted(b)) StdOut.print("b IS SORTED\n");
        
        if (p.isPermutation(a, b)) StdOut.print("a AND b IS PERMUTATION\n");
        double cost = s.stop();
        StdOut.printf("SORT AND CONFIRM IS PERMUTATION COST %.2f SECONDS", cost);
    }
}