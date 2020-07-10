package pratise;

public class Test1_1_20 {
    public static void main(String[] args){
        System.out.print(Math.log(ln(5.0)));
    }

    public static double ln(double N){
        if (N >= 1){
            return ln(N-1) * N;
        } else {
            return 1;
        }
    }
}