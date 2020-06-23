import java.util.Arrays;

public class Array{
    public static void main(String[] args){
        int[] ns = { 1, 4, 9, 16, 25 };
        // 倒序打印数组元素:
        for (int i = ns.length -1; i != -1; i--) {
            System.out.println(ns[i]);
        }

        
        int[] ns_1 = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println("排序前:" + Arrays.toString(ns_1));
        // 排序后
        Arrays.sort(ns_1);
        System.out.println("排序前:" + Arrays.toString(ns_1));
        // 倒序排列
        

        // 用二维数组表示的学生成绩:
        int[][] scores = {
            { 82, 90, 91 },
            { 68, 72, 64 },
            { 95, 91, 89 },
            { 67, 52, 60 },
            { 79, 81, 85 },
        };
        
        int stuSum = 0;
        int stuAvg = 0;

        for (int i = 0; i < scores.length-1; i++){
            for (int j = 0; j < scores[i].length; j++){
                stuSum += scores[i][j];
            }
        }
        double average = 0;
        System.out.println(average);
    }
}