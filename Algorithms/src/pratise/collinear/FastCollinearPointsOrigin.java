package pratise.collinear;

import programTest.Queue;

public class FastCollinearPointsOrigin {
    private Queue<LineSegment> lineSegmentQueue = new Queue<>();

    public FastCollinearPointsOrigin(Point[] points){
        sort(points);
        for (int i = 0; i < points.length-4; i++){
            for (int q1=i+1; q1< points.length; q1++){
                int q2 = q1+1;
                double slope1 = points[i].slopeTo(points[q1]);
                double slope2 = points[q1].slopeTo(points[q2]);

                if (slope1 == slope2){
                    int q3 = q2+1;
                    double slope3 = points[q2].slopeTo(points[q3]);
                    if (slope1 == slope3){
                        int q4 = q3+1;
                        double slope4 = points[q3].slopeTo(points[q4]);
                        if (slope1 == slope4){
                            LineSegment line = new LineSegment(points[i], points[q4]);
                            lineSegmentQueue.enQueue(line);
                            i += 4;
                        }
                    }
                }
            }
        }
    }

    private void sort(Point[] points){
        int len = points.length;
        for (int sz = 1; sz < len; sz+=sz){
            for (int lo = sz; lo< len-sz; lo+=sz+sz){
                merge(points, lo, Math.min(lo+sz+sz-1,points.length-1));
            }
        }

    }

    private Point[] copy(Point[] points){
        Point[] another = new Point[points.length];
        System.arraycopy(points, 0, another, 0, points.length);
        return another;
    }

    private void merge(Point[] points, int lo, int hi){
        Point[] copies = copy(points);
        int i = lo;
        int mid = lo + (lo+hi)/2;
        int j = mid+1;

        for (int k = lo; k< hi; k++){
            if (i > mid) points[k] = copies[j++];
            else if (j > hi) points[k] = copies[i++];
            else if (points[j].compareTo(points[i]) < 0) points[k] = copies[j++];
            else points[k] = copies[i++];
        }

    }

}

