package pratise.collinear;

import java.util.Arrays;
import java.util.Comparator;

public class FastCollinearPoints {
    private LineSegment[] lineSegments;

    public FastCollinearPoints(Point[] points)
    {
        int len = points.length;
        // 排序点数组
        Arrays.sort(points);
        // 当存在空节点或者有相同节点时抛出异常
        for (int i = 0; i< len -1; i++){
            if (points[i] == null || points[i].compareTo(points[i+1]) == 0) {
                throw new IllegalArgumentException();
            }
        }

        // 创建一个拷贝数组
        Point[] pointsCopy = new Point[points.length];
        // 初始化一个存储两个端点的数组
        int[] hasCollinear = new int[len];
        // 初始化线段
        lineSegments = new LineSegment[len/4];
        // 拷贝数组解耦
        System.arraycopy(points,0, pointsCopy,0, points.length);

        // 遍历数组，因为线段长度为4，遍历至倒数第4个节点即可
        for (int i = 0; i< len-3; i++){
            // 初始化数组存储斜率
            Double[][] slopes = new Double[len][2];
            // 遍历创建起点 i 到 i 之后的所有点的斜率
            for (int j = i+1; j < len; j++){
                double slope = pointsCopy[i].slopeTo(pointsCopy[j]);
                // 斜率的角标就是斜率的斜率所代表的 j 点
                slopes[j][0] = j*1.0;
                slopes[j][1] = slope;

            }
            Arrays.sort(slopes, new Comparator<Double[]>() {
                @Override
                public int compare(Double[] o1, Double[] o2) {
                    return Double.compare(o1[1], o2[1]);
                }
            });


            // 创建计数器
            int count = 0;
            // 遍历斜率数组，遇到4个一样的斜率点就存到线段组里
            for (int k = 0; k < slopes.length-1; k++){
                // 存斜率的数组会有空值需要判断输入
                if (slopes[k] == null) continue;
                // 创建当前斜率变量用于比较
                double current = slopes[k][1];
                int next = k+1;

                // 只要不同就归零计数器
                if (Double.compare(current, slopes[next][1]) == 0) count++;
                else count = 0;

                // 当有4个相同斜率时，判断并加入线段组内
                if (count == 4) {
                    boolean isExist = false;
                    int end = slopes[next][0].intValue();

                    // 遍历查看当前节点是否已经在数组内
                    for (int x = 0; x < hasCollinear.length; x++){
                        if ((x <= i && i <= hasCollinear[x]) && (end>hasCollinear[x])){
                            hasCollinear[x] = end;
                        } else if (x <= i && i <= hasCollinear[x]){
                            isExist = true;
                        }
                    }

                    if (!isExist) {
                        // i是初始点 next是尾节点
                        hasCollinear[i] = slopes[next][0].intValue();
                        count = 0;
                    }
                }
            }
        }

        // 遍历结束，将所有的端点连线存入线段数组
        for (int i = 0; i< hasCollinear.length; i++){
            if (!(hasCollinear[i] == 0)){
                LineSegment line = new LineSegment(pointsCopy[i], pointsCopy[hasCollinear[i]]);
                lineSegments[i] = line;
            }
        }

    }

    public int numberOfSegments(){
        return lineSegments.length;
    }

    public LineSegment[] segments(){
        return lineSegments;
    }
}
