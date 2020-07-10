package pratise.Test1_1;

public class Test1_1_15 {
    public static void main(String[] args){
        int[] a = {1, 4, 3, 4, 7, 3, 5, 3, 8};
        int M = 9;
        int[] results = histogram(a, M);

        int sum = 0;

        for (int result : results){
            sum += result;
        }

        if (sum == a.length){
            System.out.print("True");
        } else {
            System.out.print("False");
        }
    }

    public static int[] histogram(int[] a, int M){
        int[] mArray = new int[M];
        
        for (int i = 0; i < M; i++){
            int count = 0;

            for (int num : a){
                if (i == num){
                    count ++;
                }
            }

            mArray[i] = count;
        }

        return mArray;
    }
}