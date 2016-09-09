package com.foxley.interview;

/**
 *
 *  Date 09/8/2016
 *  @author Jecho Ricafrente
 *
 *  DRAFT
 *  find the intersection of two lines, needs clean up
 *
 *  ASSUMPTIONS:
 *      must handle all cases (negs, positive, parralel, perpendicular)
 *      may need to implement subfunctions to calculate slope, intercept, etc
 *      -created a point class to represent a coordinate, and a line class
 *      to represent a line derived from two points
 *
 */

public class IntersectionOfTwoLines {

    public class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Line {

        Point start;
        Point end;
        double m;
        double b;

        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
            computeSlope();
            computeIntercept();
        }

        public void computeSlope() {
            double rise = end.y - start.y;
            double run = end.x - start.x;

            double slope = rise / run;
            this.m = slope;
        }

        public void computeIntercept() {
            double intercept = end.y - (m * end.x);
            b = intercept;
        }
    }

    public static void main(String[] args) {

        IntersectionOfTwoLines obj = new IntersectionOfTwoLines();
        obj.mockupAndStart();
    }

    public Point compute(Point s1, Point e1, Point s2, Point e2) {
        Line l1 = new Line(s1, e1);
        Line l2 = new Line(s2, e2);

        return computeIntersection(l1, l2);
    }

    public Point computeIntersection(Line l1, Line l2) {
        double x = l1.m - l2.m;
        double b = l1.b - l2.b;

        if (x == 0) {
            return new Point(-999.999, -999.999);   // hardcoded, remove
        }

        double y = (l1.m * x) + l1.b;

        return new Point(x, y);
    }

    public void mockupAndStart() {
        Point s1 = new Point(-1.0, 0);
        Point e1 = new Point(-2.0, 2);
        Point s2 = new Point(-2.0,0);
        Point e2 = new Point(-1.0, 2.0);

        Point intersection = compute(s1, e1, s2, e2);
        System.out.println(intersection.y + ", " + intersection.x);
    }
}
