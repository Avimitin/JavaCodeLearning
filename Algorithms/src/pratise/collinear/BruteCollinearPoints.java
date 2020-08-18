package pratise.collinear;

public class BruteCollinearPoints {
    // lineSegment 是从起点到终点的线段，lineSegments 用于存储符合条件的线段
    private LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points){
        // 初始化线段数组
        lineSegments = new LineSegment[points.length-3];

        // 从头开始遍历，选择第一个节点与后面三个节点比较，4个4个暴力比较
        for (int i = 0; i< points.length-3; i++){
            for (int j = i+1; j < points.length-2;j++) {
                // slope 是起点到下一个点的斜率
                double slope = points[i].slopeTo(points[j]);
                for (int k = j+1; k < points.length-1; k++){
                    // 当第三个点到第二个点的斜率不等于第二个点到起点的斜率时，
                    // 说明三点不在一条线上，直接跳过。
                    if (points[k].slopeTo(points[j]) != slope) continue;
                    for (int l = k+1; l<points.length; l++){
                        // 前面三点已经确定在一条线上了，
                        // 只要终点到第三个点的斜率与起点到第二个点的斜率相等
                        // 则说明4点同线，把起点到终点的线段 lineSegment 存到数组里
                        if (points[l].slopeTo(points[k]) == slope){
                            lineSegments[i] = new LineSegment(points[i], points[l]);
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
