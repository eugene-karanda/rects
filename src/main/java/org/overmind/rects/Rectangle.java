package org.overmind.rects;

import java.util.Objects;

import static org.overmind.rects.AreaUtils.byThreePoints;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.06.2017 21:12
 */
class Rectangle {

    private final static double E = 0.001;

    private final Point a;

    private final Point b;

    private final Point c;

    private final Point d;

    private final double area;

    Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        this.area = a.distanceTo(b) * a.distanceTo(d);
    }

    Point center() {
        return Point.of(
            (a.x() + c.x()) / 2.0,
            (a.y() + c.y()) / 2.0
        );
    }

    double bigRadius() {
        return Math.max(
            a.distanceTo(c),
            b.distanceTo(d)
        );
    }

    boolean match(Point point) {
        double sum = byThreePoints(a, b, point) +
            byThreePoints(b, c, point) +
            byThreePoints(c, d, point) +
            byThreePoints(a, d, point);
        System.out.println(sum);
        return Math.abs(sum - area) < E;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.area, area) == 0 &&
            Objects.equals(a, rectangle.a) &&
            Objects.equals(b, rectangle.b) &&
            Objects.equals(c, rectangle.c) &&
            Objects.equals(d, rectangle.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d, area);
    }

    @Override
    public String toString() {
        return "(" + a + "," + b + "," + c + "," + d + ')';
    }
}
