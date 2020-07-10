package pratise.Test1_1;

public class Test1_1_5 {
    public static void main(String[] args){
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        if (x < 1.00000 && x > 0.00000 && y < 1.00000 && y > 0.00000){
            System.out.println("True");
        } else System.out.println("False");
    }
}