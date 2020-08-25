package pratise.QuickSort;

import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    public void sort(Comparable[] a)
    {
        // 必须随机，快排在数组随机时速度最快
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    public void sort(Comparable[] a, int lo, int hi)
    {
        // 将数组递归的排序
        if (hi<=lo) return;
        // j是排序之后的得到的相对中间值
        int j = partition(a, lo, hi);
        // 递归处理左半边
        sort(a, lo, j);
        // 递归处理右半边
        sort(a, j+1, hi);
    }

    public int partition(Comparable a[], int lo, int hi)
    {
        // 两个指针，一个在数组最左，一个在数组最右
        int i = lo; int j = hi+1;
        // 指定比较值为数组第一个值
        Comparable versus = a[lo];

        
        while (true)
        {
            while (less(a[++i], versus)) if (i == hi) break;
            while (less(versus, a[++j])) if (j == lo) break;
            if (i > j) break;
            exchange(a, i, j);
        }

        exchange(a, lo, j);
        return j;
    }

    private boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private void exchange(Comparable[] a, int i, int j)
    {
        Comparable current = a[j];
        a[j] = a[i];
        a[i] = current;
    }
}
