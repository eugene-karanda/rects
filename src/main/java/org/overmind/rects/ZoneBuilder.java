package org.overmind.rects;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.06.2017 23:50
 */
class ZoneBuilder {
    private Zone zone;

    static ZoneBuilder builder() {
        return new ZoneBuilder();
    }

    private ZoneBuilder() {
    }

    ZoneBuilder add(Rectangle rectangle) {
        if(zone == null) {
            zone = Zone.ofRectangle(rectangle);
            return this;
        }

        if (!zone.add(rectangle)) {
            Zone outerZone = Zone.ofCenter(
                zone.center(),
                zone.center().distanceTo(rectangle.center()),
                rectangle
            );
            outerZone.add(zone);
            zone = outerZone;
        }

        return this;
    }

    Zone build() {
        return zone;
    }
}
