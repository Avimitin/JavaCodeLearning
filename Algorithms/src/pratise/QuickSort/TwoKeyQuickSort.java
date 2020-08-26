package pratise.QuickSort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import programTest.StopWatch;

public class TwoKeyQuickSort {
    public void sort(Comparable[] a)
    {
        int lo =0, hi = a.length-1;
        int i = lo;

        while (i <= hi)
        {
            if ( less(a[i], a[lo]) ) exchange(a, i++, lo++);
            else if (a[i].compareTo(a[lo]) > 0) exchange(a, i++, hi--);
            else i++;
        }
    }


    private void exchange(Comparable[] a, int i, int j)
    {
        Comparable item = a[j];
        a[j] = a[i];
        a[i] = item;
    }

    private boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    public static void main(String[] args) throws Exception {
        Comparable[] testArray = new Comparable[10000];
        for (int i = 0; i<testArray.length; i++){
            if (StdRandom.uniform() < .5) testArray[i] =0;
            else testArray[i] = 1;
        }

        TwoKeyQuickSort t = new TwoKeyQuickSort();
        StopWatch w = new StopWatch();
        t.sort(testArray);
        double time = w.stop();

        for (int i= 0; i < testArray.length-1; i++){
            if (t.less(testArray[i+1], testArray[i]))
            {
                StdOut.print(testArray[i+1] +"\t\t"+testArray[i]);
                throw new Exception("ARRAY NOT SORTED");
            }
        }

        StdOut.print("耗时" + time + "秒");
    }
}
