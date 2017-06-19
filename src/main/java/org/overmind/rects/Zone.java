package org.overmind.rects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.06.2017 23:00
 */
class Zone {
    
    private final Point center;
    
    private final double radius;

    private List<Zone> innerZones;

    private List<Rectangle> rectangles;

    static Zone ofRectangle(Rectangle rectangle) {
        return new Zone(
            rectangle.center(),
            rectangle.bigRadius(),
            rectangle
        );
    }

    private Zone(Point center, double radius, Rectangle rectangle) {
        this.center = center;
        this.radius = radius;

        this.innerZones = new ArrayList<>();
        this.rectangles = new ArrayList<>(Collections.singleton(rectangle));
    }

    void add(Zone zone) {
        this.innerZones.add(zone);
    }

    boolean add(Rectangle rectangle) {
        if (match(rectangle)) {
            for (Zone innerZone : innerZones) {
                if(innerZone.add(rectangle)) {
                    return true;
                }
            }

            rectangles.add(rectangle);
            return true;
        } else {
            return false;
        }
    }

    Optional<Rectangle> find(Point point) {
        if (!match(point)) {
            return Optional.empty();
        } else {
            for (Rectangle rectangle : rectangles) {
                if (rectangle.match(point)) {
                    return Optional.of(rectangle);
                }
            }

            for (Zone zone : innerZones) {
                Optional<Rectangle> rectangleOptional = zone.find(point);
                if(rectangleOptional.isPresent()) {
                    return rectangleOptional;
                }
            }

            return Optional.empty();
        }
    }

    private boolean match(Point point) {
        return center.distanceTo(point) < radius;
    }

    private boolean match(Rectangle rectangle) {
        return match(rectangle.center());
    }

}
