package pratise.Test1_3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import programTest.Stack;

public class Test1_3_10 {
    public static String InfixToPostfix(String expression){
        String[] items = expression.split("");
        Stack<String> values = new Stack<>();

        for (String item : items){
            if (isDigit(item)) StdOut.print(item);
            else if (item.equals(")")){
                if (values.size() == 0) return "\nERROR! STACK SHOULD NOT BE EMPTY!";
                else {
                    StdOut.print(values.pop());
                }
            }
            else if (isOperator(item)) values.push(item);
        }

        return "\nDONE";
    }

    public static boolean isDigit(String num){
        final String number = "0123456789";

        String[] nums = number.split("");
        for (String n : nums){
            if (n.equals(num)){
                return true;
            }
        }

        return false;
    }

    public static boolean isOperator(String opt){
        return opt.equals("+") || opt.equals("-") || opt.equals("*") || opt.equals("/");
    }

    public static String GetExpression(){
        In in = new In();
        return in.readString();
    }
    // 1.3.11
    public static int EvaluatePostfix(String expression){
        String[] items = expression.split("");
        Stack<Integer> value = new Stack<>();

        for (String item : items){
            if (isDigit(item)){
                int num = Integer.parseInt(item);
                value.push(num);
            } else if (isOperator(item)){
                int num2 = value.pop();
                int num1 = value.pop();
                if (item.equals("+")) value.push(num1 + num2);
                else if (item.equals("-")) value.push(num1 - num2);
                else if (item.equals("*")) value.push(num1 * num2);
                else if (item.equals("/")) value.push(num1 / num2);
            }
        }

        return value.pop();
    }

    public static void main(String[] args){
        String text = "(((5+(7*(1+1)))*3)+(2*(1+1)))";
        StdOut.println(InfixToPostfix(text));
        String expression = GetExpression();
        StdOut.println(expression);
        StdOut.println(EvaluatePostfix(expression));
    }
}
