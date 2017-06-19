package org.overmind.rects;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.06.2017 21:30
 */
final class AreaUtils {

    static double byThreePoints(Point a, Point b, Point c) {
        double p = (a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a)) / 2.0;

        return Math.sqrt(
            p * (p - a.distanceTo(b)) * (p - b.distanceTo(c)) * (p - c.distanceTo(a))
        );
    }

}
