package pratise.ElementarySorts;

import edu.princeton.cs.algs4.StdOut;
import programTest.Stack;
import edu.princeton.cs.algs4.StdRandom;
import programTest.StopWatch;

public class ShellSort{
    private Stack<Integer> stack = new Stack<>();
    private int count;
    private int exchCount;

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
        int h = 1;
        while (h < len/3) h = 3*h+1;
        while (h >= 1){
            for (int i = h; i < len; i++){
                // 把 j 起始值设置在最末端i，每次 -h 往前比对直到达到最小的间隔角标 h
                for (int j = i; j >= h; j-=h){
                    count++;
                    if (less(a[j], a[j-h])){
                        exchange(a, j, j-h);
                        exchCount++;
                    }
                }
            }
            h/=3;
        }
    }
    
    public void preStoreSort(Comparable[] a){
        int len = a.length;
        int h = 1;
        stack.push(h);
        while (h < len/3){
            h = 3*h +1;
            stack.push(h);
        }
        
        h = stack.pop();
        while (h >=1){
            for (int i =h; i <len; i++){
                for (int j = i; j>=h && less(a[j], a[j-h]); j-=h){
                    exchange(a, j, j-h);
                }
            }
            h = stack.pop();
        }
    }

    public static void main(String[] args){
        ShellSort s = new ShellSort();
        StopWatch w1 = new StopWatch();
        for (int i=0; i<30; i++){
            int N = 1000+100*i;
            Double[] array = new Double[N];
            for (int j = 0; j < N; j++){
                array[j] = StdRandom.uniform()*N;
            }
            StopWatch w2 = new StopWatch();
            s.sort(array);
            double time = w2.stop();
            double rate = (s.count / N) * 1.00;
            StdOut.printf("数组大小为 %d，排序总的比较了 %d 次，比较次数和数组大小的比值为 %.2f;\n数组交换了 %d 次，排序耗时 %.4f 秒。\n\n", N, s.count, rate, s.exchCount,time);
        }
        double time = w1.stop();
        StdOut.printf("程序完成，总耗时 %.4f 秒", time);
    }
}