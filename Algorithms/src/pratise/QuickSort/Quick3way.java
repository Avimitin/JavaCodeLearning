package pratise.QuickSort;

// 当函数内有大量重复值时再使用这个办法

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3way {
    public void sort(Comparable[] a)
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    public void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        // lo 到 loBorder 是小于 versus 的所有值
        int loBorder = lo;
        // hiBorder 到 hi 是大于 versus 的所有值
        int hiBorder = hi;
        // i 是遍历数组的指针
        int i = lo+1;
        // versus 初始化为数组第一个值
        Comparable versus = a[lo];

        while (i <= hiBorder){
            int compare = a[i].compareTo(versus);

            // 当 a[i] 小于 versus 时，将 loBorder 和 i 对应键值交换
            // 此时 loBorder 左边就都是小于 versus 的值
            if (compare < 0) exchange(a, loBorder++, i++);
            // 当 a[i] 大于 versus 时，将 hiBorder 和 i 对应键值交换
            // 此时 hiBorder 右边就都是大于 versus 的值
            // 注意此时 i 不能自增，因为不知道从后往前挪来的值是否小于最小边界，要进行下次循环
            else if (compare > 0) exchange(a, hiBorder--, i);
            // loBorder 到 hiBorder 中间就全部是和 versus 相等的值
            else i++;
        }
        // 将乱序的左半边排序
        sort(a, lo, loBorder-1);
        // 将乱序的右半边排序
        sort(a, hiBorder+1, hi);
        // 此时排序完成。
    }

    private void exchange(Comparable[] a, int i, int j)
    {
        Comparable item = a[j];
        a[j] = a[i];
        a[i] = item;
    }

    public static void main(String[] args) {
        Comparable[] testArray = {5,3,5,1,2,1,4,7,5,5,4,3,3,4,5,2,1,8,7,9,4,9,8,7};

        Quick3way q = new Quick3way();
        q.sort(testArray);

        for (Comparable num : testArray){
            StdOut.print(num + " ");
        }
    }
}
