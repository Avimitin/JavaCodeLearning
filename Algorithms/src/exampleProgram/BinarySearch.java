import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            // hi-lo 数组去除头尾的一半长度
            int mid = lo + (hi - lo) / 2;
            // key 小于 数组中间值则往左半边搜索，反之则右半边
            if (key < a[mid]){
                hi = mid - 1;
            } else if (key > a[mid]){
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] whitelist = new int[]{1,3,6,7,30,60,78,123,421,432,555};
        int key = 432;
        int result;
        result = rank(key, whitelist);
        if (result < 0){
            System.out.println("NO RESULT!");
        } else {
            System.out.println(whitelist[result]);
        }
    }
}