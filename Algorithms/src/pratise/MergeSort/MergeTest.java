package pratise.MergeSort;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class MergeTest {
    public static void main(String[] args){
        Merge m = new Merge();
        MergeBN mbn = new MergeBN();
        int[] points = new int[513];
        int[] BNPoints = new int[513];
        Comparable[] array;
        Comparable[] BNArray;

        for (int N = 1; N< 513; N++){
            // 自顶向下
            array = new Comparable[N];
            for (int i= 0; i<N; i++){
                array[i] = StdRandom.uniform();
            }
            m.sort(array);
            points[N] = m.count;

            //自底向上
            BNArray = new Comparable[N];
            for (int i= 0; i<N; i++){
                BNArray[i] = StdRandom.uniform();
            }
            mbn.sort(BNArray);
            BNPoints[N] = mbn.count;

            //reset
            m.count=0;
            mbn.count=0;
        }

        //绘图
        StdDraw.setXscale(0,513);
        StdDraw.setYscale(0,10*Math.log(512)/Math.log(2)*51.0);
        StdDraw.setPenRadius(.01);
        for (int i =0; i< points.length; i++){
            StdDraw.setPenColor(Color.black);
            StdDraw.point(i, points[i]);
            StdDraw.setPenColor(Color.red);
            StdDraw.point(i, BNPoints[i]);
        }
        StdDraw.setPenColor(Color.blue);
        for (int i = 1; i< 513; i++){
            StdDraw.point(i, 6.0*i*Math.log10(i));
        }
    }
}
