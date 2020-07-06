public class Test1_1_14 {
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        System.out.println(lg(N));
    }

    public static int lg(int N){
        int i = 0;

        while (N > 1){
            N = N/2;
            i ++;
        }

        return i;
    }
}