package pratise.Test1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import programTest.Stack;

public class Test1_3_4{
    public static void main(String[] args){
        Stack<String> Parenthese = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String pattern = StdIn.readString();
            if (pattern.equals(")")){
                if (!Parenthese.pop().equals("(")) StdOut.println("False");
            } else if (pattern.equals("]")) {
                if (!Parenthese.pop().equals("[")) StdOut.println("False");
            } else if (pattern.equals("}")) {
                if (!Parenthese.pop().equals("{")) StdOut.println("False");
            } else Parenthese.push(pattern);
        }
        StdOut.print("True");
    }
}
