package pratise;

public class Test1_1_13 {
    public static void main(String[] args){
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        String[][] array = new String[M][N];

        // 未转置
        for (int a = 0; a < M; a++){
            for (int b = 0; b < N; b++){
                String s = "("+a+","+b+")";
                array[a][b] = s;
                System.out.print(array[a][b]);
            }
            System.out.println();
        }

        // 转置后
        String[][] new_array = new String[N][M];
        
        for (int a = 0; a < N; a++){
            for (int b = 0; b < M; b++){
                String s = "("+a+","+b+")";
                new_array[a][b] = s;
                System.out.print(new_array[a][b]);
            }
            System.out.println();
        }

        
    }
}