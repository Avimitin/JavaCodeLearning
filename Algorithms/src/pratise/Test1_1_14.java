public class Test1_1_14 {
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        int i = 0;

        while (N > 1){
            N = N/2;
            i ++;
        }

        System.out.print(i);
    }
}