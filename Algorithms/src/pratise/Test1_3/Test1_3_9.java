package pratise.Test1_3;

import programTest.Queue;
import programTest.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Test1_3_9 {
    public static void main(String[] args){
        Stack<String> opts = new Stack<>();
        Stack<String> nums = new Stack<>();

        while (!StdIn.isEmpty()){
            String item = StdIn.readString();

            if (item.equals("+") || item.equals("-") || item.equals("/") || item.equals("*")){
                opts.push(item);
            } else if (item.equals(")")) {
                String num1 = nums.pop();
                String num2 = nums.pop();
                String opt1 = opts.pop();

                String text = "(" + num2 + opt1 + num1 + ")";
                nums.push(text);
            } else {
                nums.push(item);
            }
        }

        StdOut.print(nums.pop());
    }
    /* 错误写法
    public static void main(String[] args){
        Queue<String> nums = new Queue<>();
        Queue<String> opts = new Queue<>();

        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (item.equals("+") || item.equals("-") || item.equals("/") || item.equals("*")){
                opts.enQueue(item);
            } else if (item.equals(")")) {
                String num1 = nums.deQueue();
                String num2 = nums.deQueue();
                String opt = opts.deQueue();

                String value = "(" + num1 + opt + num2 + ")";
                nums.enQueue(value);
            } else nums.enQueue(item);
        }

        StdOut.print(nums.deQueue());
    }

     */
}
