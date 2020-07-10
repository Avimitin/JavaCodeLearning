package pratise.Test1_1;

import java.util.Scanner;

public class Test1_1_21 {
    public static void main(String[] args){
        if (args.length == 0) System.out.println("请输入最大行数");
        else{
            int num = Integer.parseInt(args[0]);

            Scanner scanner = new Scanner(System.in);
            System.out.println("请逐行输入数据");

            String[] lines = new String[num];

            while (num > 0){
                lines[num-1] = scanner.nextLine();
                num--;
            }

            scanner.close();
            
            for (String line : lines){
                String[] words = line.split(" ");
                String name = words[0];
                double firNum = Double.parseDouble(words[1]);
                double secNum = Double.parseDouble(words[2]);

                double cal = firNum / secNum;

                System.out.printf("|名字: %s|第一次: %.2f|第二次: %.2f|比率: %.2f %% \n", name, firNum, secNum, cal*100.00);
            }

        }
    }
}