package org.overmind.rects;

import java.util.Objects;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.06.2017 20:10
 */
public class Point {

    private final double x;

    private final double y;

    static Point of(double x, double y) {
        return new Point(x, y);
    }

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double x() {
        return x;
    }

    double y() {
        return y;
    }

    double distanceTo(Point other) {
        return Math.sqrt(
            Math.pow(x - other.x, 2.0) +
            Math.pow(y - other.y, 2.0)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
            Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ',' + y + ')';
    }
}
