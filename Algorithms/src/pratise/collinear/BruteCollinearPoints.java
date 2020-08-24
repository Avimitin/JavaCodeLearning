package pratise.collinear;

import java.util.Arrays;

public class BruteCollinearPoints {
    // lineSegment 是从起点到终点的线段，lineSegments 用于存储符合条件的线段
    private LineSegment[] lineSegments;
    private Point[] pointsCopy;
    private int len;

    public BruteCollinearPoints(Point[] points){
        // 初始化线段数组
        len = points.length;
        lineSegments = new LineSegment[len-3];
        pointsCopy = new Point[len];
        System.arraycopy(points, 0, pointsCopy, 0, len);
        Arrays.sort(pointsCopy);
        // 从头开始遍历，选择第一个节点与后面三个节点比较，4个4个暴力比较
        for (int i = 0; i< len-3; i++){
            for (int j = i+1; j < len-2;j++) {
                // slope 是起点到下一个点的斜率
                double slope = pointsCopy[i].slopeTo(pointsCopy[j]);
                for (int k = j+1; k < len-1; k++){
                    // 当第三个点到第二个点的斜率不等于第二个点到起点的斜率时，
                    // 说明三点不在一条线上，直接跳过。
                    if (pointsCopy[k].slopeTo(pointsCopy[j]) != slope) continue;
                    for (int l = k+1; l<pointsCopy.length; l++){
                        // 前面三点已经确定在一条线上了，
                        // 只要终点到第三个点的斜率与起点到第二个点的斜率相等
                        // 则说明4点同线，把起点到终点的线段 lineSegment 存到数组里
                        if (pointsCopy[l].slopeTo(pointsCopy[k]) == slope){
                            lineSegments[i] = new LineSegment(pointsCopy[i], pointsCopy[l]);
                        }
                    }
                }
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
