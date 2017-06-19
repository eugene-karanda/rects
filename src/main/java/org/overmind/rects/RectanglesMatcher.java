package org.overmind.rects;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.06.2017 20:28
 */
class RectanglesMatcher {

    private final Zone globalZone;

    RectanglesMatcher(Zone globalZone) {
        this.globalZone = globalZone;
    }

    Map<Point, Optional<Rectangle>> matchAll(List<Point> points) {
        return points.stream()
            .collect(
                Collectors.toMap(point -> point,
                globalZone::find)
            );
    }
}
