public class BasicGrammer {
    /** 
    * void 是返回值
    * main 是方法名
    * public 代表 main方法是公开可访问的
    * 
    */
    public static void main(String[] args){
        // 输出文本
        System.out.println("Hello World");
        
        /**  +------------变量和数据类型-------------+ 
         * Java提供了两种变量类型：基本类型和引用类型
         * 基本类型包括整型，浮点型，布尔型，字符型。
         * 变量可重新赋值，等号是赋值语句，不是数学意义的等号。
         * 常量在初始化后不可重新赋值，使用常量便于理解程序意图。
        */

        int x = 1;
        System.out.println(x);
        /**
         * 在这里x已经被开辟内存空间了
         * 所以不可以使用：
         * int x = 2;
         * 将x重新赋值应该使用：
         */
        x = 2;
        System.out.println(x);

        // 每一次声明都开辟了一个内存空间
        int n = 3;
        x = x + n;
        System.out.println("x=" + x + "\n"
                            + "n=" + n
                          );
        
        // float 需要 带上f 尾缀
        float y = 4.10f;
        System.out.println(y);

        // 使用 final 来赋予常量，即不可再修改
        final char a = 'a';
        System.out.println("常量" + a);

        // 简单的运算
        int b = 100;
        int sum = ((b+1)*b)/2;
        System.out.println(sum);

        // 求解一元二次方程cx^2+dx+e=0
        double c = 1.0;
        double d = 3.0;
        double e = -4.0;

        double r1 = (-d + Math.sqrt(d*d - 4*c*e)) / (2*c);
        double r2 = (-d - Math.sqrt(d*d - 4*c*e)) / (2*c);
        System.out.println("r1=" + r1 + "\t" + "r2=" + r2);

        int age = 7;
        // primary student的定义: 6~12岁
        // 布尔运算是短路运算，当前面返回对应True or False 就直接返回前面的值
        boolean isPrimaryStudent = age >= 6 && age <= 12;
        // 三元运算符 b? a : c 如果 b True 返回 a False 返回 c
        System.out.println(isPrimaryStudent ? "Yes" : "No");

        // '' 单引号存单字符，""双引号存字符串
        char singleWord = 's';
        // 在这里，words变量指向了"Here is more words combine"字符串的内存空间
        String words = "Here is first words combine";
        // 如果将words指向转换，则原来的"Here is more words combine"就无法访问了
        // 既是“字符串不可变”特性
        words = "Here is second words combine";
        System.out.println("char:" + singleWord + '\t' + "String:" + words);

        // +--------数组---------+
        int[] ns = new int[5];
        ns[0] = 0;
        ns[1] = 1;
        ns[2] = 2;
        ns[3] = 3;
        ns[4] = 4;
        // 或者简写成， 会自动识别大小
        ns = new int[] {0, 1, 2};
        /** 
         * 在上述过程中，ns从{0, 1, 2, 3, 4} 数组指向了 {0, 1, 2}，数组本身没有变化
         * 因为字符串本身也不可变：
         * 当使用字符串作为数组时，names指向 {"ABC", "XYZ", "zoo"} 这个数组
         * 而数组本身的每一个元素分别指向对应的字符串
         * 所以下例 s 指向 "XYZ" 字符串，当 names[1] 改变指针时 s 不会有变化
        */
        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s);
    }
}