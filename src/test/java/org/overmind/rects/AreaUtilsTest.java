package org.overmind.rects;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.overmind.rects.Point.of;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.06.2017 21:35
 */
public class AreaUtilsTest {
    @Test
    public void area() throws Exception {
        assertEquals(
            "Actual byThreePoints is different of expected",
            AreaUtils.byThreePoints(
                of(2, -3),
                of(1, 1),
                of(-6, 5)
            ),
            12.0,
            0.001
        );
    }

}