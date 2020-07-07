package pratise;

public class Test1_1_3 {
    public static void main(String[] args){
        if (args.length != 3){
            System.out.println("请输入3个数据");
        }

        if (args[0].equals(args[1]) && args[1].equals(args[2])){
            System.out.println("EQUAL");
        } else {
            System.out.println("NOT EQUAL");
        }
    }
}