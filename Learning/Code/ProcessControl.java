import java.util.Scanner;

public class ProcessControl {
    public static void main(String[] args){
        
        // +-------输入和输出------+
        /** 设计一个程序，输入上次考试成绩（int）和本次考试成绩（int），
         * 然后输出成绩提高的百分比，
         * 保留两位小数位
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一次考试的成绩：");
        double firstScore = scanner.nextInt();
        System.out.print("\n请输入第二次考试的成绩:");
        double secondScore = scanner.nextInt();
        double increase = (secondScore - firstScore) / firstScore;
        System.out.printf("\n第一次考试的成绩是%.0f，第二次考试的成绩是%.0f,", firstScore, secondScore);
        System.out.printf("成绩提高的百分比为: %.2f%%\n", increase * 100);
        

        // +------if判断------+
        /**
         * 浮点数不可以直接使用==来判断
         * 类型判断内容相等需要使用equal()方法，且需要避免null值导致错误
         */
        double x = 0.01;
        double y = 0.10-9.0/100.0;
        if (x == y) {
            System.out.println("使用==相等");
        } else if (Math.abs(x-y) < 0.00001){
            System.out.println("使用绝对值相等");
        } else {
            System.out.println("不相等");
        }

        String test1 = "test1";
        String test2 = "TEST1".toLowerCase();

        if (test1 == test2){
            System.out.println("引用对象相同");
        } else if (test1 != null && test1.equals(test2)){
            System.out.println("值相同");
        } else {
            System.out.println("值不同");
        }


        // +--------switch/case---------+
        // 使用switch case实现简单的石头剪刀布游戏
        System.out.print("请输入石头或剪刀或者布:");
        if (scanner.hasNextLine()){
            scanner.nextLine();
            scanner.nextLine();
            String user = scanner.nextLine();
            System.out.println(user);
            int pc = 1 + (int)Math.random() * 3;

            switch (user) {
                case "石头":
                    System.out.printf("\n你输入了%s", user);

                    if (pc == 1){
                        System.out.println("平局");
                    } else if (pc == 2) {
                        System.out.println("你赢了");
                    } else if (pc == 3) {
                        System.out.println("你输了");
                    }

                    break;
                case "剪刀":
                    System.out.printf("\n你输入了%s", user);

                    if (pc == 1){
                        System.out.println("你输了");
                    } else if (pc == 2) {
                        System.out.println("平局");
                    } else if (pc == 3) {
                        System.out.println("你赢了");
                    }

                    break;
                case "布":
                    System.out.printf("\n你输入了%s", user);

                    if (pc == 1){
                        System.out.println("你输了");
                    } else if (pc == 2) {
                        System.out.println("你赢了");
                    } else if (pc == 3) {
                        System.out.println("平局");
                    }

                    break;
                default:
                    System.out.println("请在石头剪刀布中选择一个");
                    break;
                
            }
        }
        
        // +------------while 和 do while------------+
        int sum = 0;
		int m = 20;
		int n = 100;
		// 使用while计算M+...+N:
		while (m <= n) {
            sum += m;
            m++;
		}
        System.out.println(sum);
        
        sum = 0;
        
        do {
            sum += m;
            m++;
        } while (m <= n);
        System.out.println(sum);

        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i= ns.length-1; i != -1; i--) {
            System.out.println(ns[i]);
        }

        scanner.close();
    }
}