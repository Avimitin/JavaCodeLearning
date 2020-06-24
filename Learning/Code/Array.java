import java.util.Arrays;

public class Array{
    public static void main(String[] args){
        for (String arg : args){
            if (arg!=null && arg.equals("-about")){
                System.out.println("a program about array");
                break;
            }
        }

        int[] ns = { 1, 4, 9, 16, 25 };
        // 倒序打印数组元素:
        for (int i = ns.length -1; i != -1; i--) {
            System.out.print(ns[i] + " ");
        }

        System.out.println();
        
        int[] ns_1 = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println("排序前:" + Arrays.toString(ns_1));
        // 排序后
        Arrays.sort(ns_1);
        System.out.println("排序后:" + Arrays.toString(ns_1));
        // 倒序排列

        for(int i=0; i<ns_1.length; i++){
            for(int j=i+1; j<ns_1.length; j++){
                if (ns_1[i] < ns_1[j]){
                    int x = ns_1[i];
                    ns_1[i] = ns_1[j];
                    ns_1[j] = x;
                } else if (ns_1[i] == ns_1[j]) {
                    continue;
                }
            }
        }
        
        System.out.println("降序排序后：" + Arrays.toString(ns_1));


        // 用二维数组表示的学生成绩:
        /**
         * 思路：
         * 先计算二维数组内每一个数组的平均值，
         * 再将这个二维数组内所有数组的平均值相加，除以数组元素数量
         * 弊端：
         * 因为从头使用int，最后所得值的小数与直接计算的值相差很大
         */
        int[][] scores = {
            { 82, 90, 91 },
            { 68, 72, 64 },
            { 95, 91, 89 },
            { 67, 52, 60 },
            { 79, 81, 85 },
        };
        
        
        int AvgSum = 0;

        for (int i = 0; i < scores.length; i++){
            // 每一轮循环重置学生总成绩相加
            int stuSum = 0;
            for (int j = 0; j < scores[i].length; j++){
                stuSum += scores[i][j];
            }

            int stuAvg = stuSum / scores[i].length;
            AvgSum += stuAvg;
        }
        
        double average = (double)AvgSum / scores.length;
        System.out.printf("所有学生平均成绩:%.2f\n", average);
    }
}