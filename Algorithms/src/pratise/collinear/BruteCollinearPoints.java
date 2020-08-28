package pratise.collinear;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BruteCollinearPoints {
    // lineSegment 是从起点到终点的线段，lineSegments 用于存储符合条件的线段
    private final LineSegment[] lineSegments;
    private int num = 0;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();

        // 初始化线段数组
        int len = points.length;
        lineSegments = new LineSegment[len];
        Point[] pointsCopy = new Point[len];

        for (int i = 0; i < len; i++) {
            if (points[i] == null) throw new IllegalArgumentException();
            pointsCopy[i] = points[i];
        }

        Arrays.sort(pointsCopy);
        if (isDuplicated(pointsCopy)) throw new IllegalArgumentException();

        // 从头开始遍历，选择第一个节点与后面三个节点比较，4个4个暴力比较
        for (int i = 0; i < len -3; i++) {
            for (int j = i+1; j < len -2; j++) {
                // slope 是起点到下一个点的斜率
                double slope = pointsCopy[i].slopeTo(pointsCopy[j]);
                for (int k = j+1; k < len -1; k++) {
                    // 当第三个点到第二个点的斜率不等于第二个点到起点的斜率时，
                    // 说明三点不在一条线上，直接跳过。
                    if (!(isEqual(pointsCopy[j].slopeTo(pointsCopy[k]), slope))) continue;
                    for (int x = k+1; x < len; x++) {
                        // 前面三点已经确定在一条线上了，
                        // 只要终点到第三个点的斜率与起点到第二个点的斜率相等
                        // 则说明4点同线，把起点到终点的线段 lineSegment 存到数组里
                        if (isEqual(pointsCopy[k].slopeTo(pointsCopy[x]), slope)) {
                            lineSegments[num++] = new LineSegment(pointsCopy[i], pointsCopy[x]);
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {
        return num;
    }

    public LineSegment[] segments() {
        // 重新创建一个数组来接受 LineSegments 中的所有线段，就不会出现 null 的情况
        LineSegment[] segmentsCopy = new LineSegment[num];
        for (int i = 0; i < num; i++) segmentsCopy[i] = lineSegments[i];
        return segmentsCopy;
    }

    private boolean isDuplicated(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i+1]) == 0) return true;
        }
        return false;
    }

    private boolean isEqual(double x, double y) {
        return Double.compare(x, y) == 0;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
