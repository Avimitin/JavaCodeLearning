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
        int[][] hasCollinear = new int[len][2];
        lineSegments = new LineSegment[len];

        // 遍历数组，因为线段长度为4，遍历至倒数第4个节点即可
        for (int i = 0; i < len-4; i++) {
            // 初始化数组存储斜率
            Double[][] slopes = new Double[len][2];
            int slopesCount = 0;
            // 遍历创建起点 i 到 i 之后的所有点的斜率
            for (int j = i+1; j < len; j++) {
                double slope = pointsCopy[j].slopeTo(pointsCopy[i]);
                // 斜率的角标就是斜率的斜率所代表的 j 点
                slopes[j][0] = j*1.0;
                slopes[j][1] = slope;
                slopesCount++;
            }
            Double[][] slopesCp = new Double[slopesCount][2];
            int a = 0;
            for (Double[] slope : slopes) {
                if (slope[0] == null) continue;
                slopesCp[a++] = slope;
            }

            Arrays.sort(slopesCp, Comparator.comparingDouble(o -> o[1]));

            // 遍历斜率数组，遇到4个一样的斜率点就存到线段组里
            for (int k = 0; k < slopesCp.length; k++) {
                double current = slopesCp[k][1];
                int count = 1;
                int end = 1;
                for (int j = k+1; j < slopesCp.length; j++){
                    double next = slopesCp[j][1];
                    // 只要不同就归零计数器
                    if (Double.compare(current, next) == 0) {
                        count++;
                        end = slopesCp[j][0].intValue();
                    }
                    else {
                        k = j-1;
                        break;
                    }
                }
                // 当有4个相同斜率时，判断并加入线段组内
                if (count >= 4) {
                    // i是初始点 next是尾节点
                    hasCollinear[num][0] = i;
                    hasCollinear[num++][1] = end;
                }
            }
        }

        // 遍历结束，将所有的端点连线存入线段数组
        for (int i = 0; i < hasCollinear.length; i++) {
            if (hasCollinear[i][1] != 0) {
                LineSegment line = new LineSegment(pointsCopy[hasCollinear[i][0]], pointsCopy[hasCollinear[i][1]]);
                lineSegments[i] = line;
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
