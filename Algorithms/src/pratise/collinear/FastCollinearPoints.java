package pratise.collinear;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class FastCollinearPoints {
    private final LineSegment[] lineSegments;
    private int num;

    public FastCollinearPoints(Point[] points)
    {
        int len = points.length;
        // 排序点数组
        Arrays.sort(points);
        // 当存在空节点或者有相同节点时抛出异常
        isLegal(points);

        // 创建一个拷贝数组
        Point[] pointsCopy = Arrays.copyOf(points, points.length);
        // 初始化一个存储两个端点的数组
        int[] hasCollinear = new int[len];
        lineSegments = new LineSegment[len];

        // 遍历数组，因为线段长度为4，遍历至倒数第4个节点即可
        for (int i = 0; i < len-4; i++) {
            // 初始化数组存储斜率
            Double[][] slopes = new Double[len][2];
            int slopesCount = 0;
            // 遍历创建起点 i 到 i 之后的所有点的斜率
            for (int j = i+1; j < len; j++) {
                double slope = pointsCopy[i].slopeTo(pointsCopy[j]);
                // 斜率的角标就是斜率的斜率所代表的 j 点
                slopes[j][0] = j*1.0;
                slopes[j][1] = slope;
                slopesCount ++;
            }
            Double[][] slopesCp = new Double[slopesCount][2];
            int a = 0;
            for (Double[] slope : slopes) {
                if (slope[0] == null) continue;
                slopesCp[a++] = slope;
            }

            Arrays.sort(slopesCp, Comparator.comparingDouble(o -> o[1]));

            for (Double[] slope : slopesCp){
                for (Double s : slope){
                    StdOut.print(s+ " ");
                }
                StdOut.println();
            }
            StdOut.println();

            // 创建计数器
            int count = 1;
            // 遍历斜率数组，遇到4个一样的斜率点就存到线段组里
            for (int k = 0; k < slopesCp.length-1; k++) {
                // 创建当前斜率变量用于比较
                double current = slopesCp[k][1];
                int next = k+1;

                // 只要不同就归零计数器
                if (Double.compare(current, slopesCp[next][1]) == 0) count++;
                else {
                    count = 0;
                    continue;
                }

                // 当有4个相同斜率时，判断并加入线段组内
                if (count >= 4) {
                    boolean isExist = false;
                    int end = slopesCp[next][0].intValue();

                    // 遍历查看当前节点是否已经在数组内
                    for (int x = 0; x < hasCollinear.length; x++) {
                        if ((x <= i && i <= hasCollinear[x]) && (end > hasCollinear[x])) {
                            hasCollinear[x] = end;
                        } else if (x <= i && i <= hasCollinear[x]) {
                            isExist = true;
                        }
                    }

                    if (!isExist) {
                        // i是初始点 next是尾节点
                        hasCollinear[i] = slopesCp[next][0].intValue();
                        count = 0;
                    }
                }
            }
        }

        // 遍历结束，将所有的端点连线存入线段数组
        for (int i = 0; i < hasCollinear.length; i++) {
            if (!(hasCollinear[i] == 0)) {
                LineSegment line = new LineSegment(pointsCopy[i], pointsCopy[hasCollinear[i]]);
                lineSegments[i] = line;
                num++;
            }
        }

    }

    public int numberOfSegments(){
        return num;
    }

    public LineSegment[] segments(){
        LineSegment[] segmentsCp = new LineSegment[num];
        int count = 0;
        for (LineSegment lineSegment : lineSegments) {
            if (lineSegment == null) continue;
            segmentsCp[count++] = lineSegment;
        }
        return segmentsCp;
    }

    private boolean isDuplicated(Point[] points) {
        // 要先排序点再使用该方法
        for (int i = 0; i < points.length - 1; i++) {
            if (isEqualPoint(points[i], points[i+1])) return true;
        }
        return false;
    }

    private boolean isEqualPoint(Point a, Point b) {
        return a.compareTo(b) == 0;
    }

    private boolean isNull(Point[] points) {
        for (Point point : points) {
            if (point == null) return true;
        }
        return false;
    }

    private void isLegal(Point[] points) {
        if (points == null) throw new IllegalArgumentException("ARRAY CANT BE NULL");
        if (isNull(points)) throw new IllegalArgumentException("POINT CANT BE NULL");
        if (isDuplicated(points)) throw new IllegalArgumentException("POINT CANT BE DUPLICATED");
    }
}
