package org.overmind.rects;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.overmind.rects.Point.of;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 19.06.2017 22:09
 */
public class RectanglesMatcherTest {

    @Test
    public void matchTest() throws Exception {
        RectanglesMatcher rectanglesMatcher = new RectanglesMatcher(
            ZoneBuilder.builder()
                .add(new Rectangle(
                    of(5.0, 5.0),
                    of(5.0, 10.0),
                    of(20.0, 10.0),
                    of(20.0, 5.0)
                ))
                .add(new Rectangle(
                    of(1.0, 1.0),
                    of(2.0, 1.0),
                    of(2.0, 2.0),
                    of(1.0, 2.0)
                ))
                .build()
        );
        Map<Point, Optional<Rectangle>> matchMap = rectanglesMatcher.matchAll(Arrays.asList(
            of(12.5, 7.5),
            of(30.0, 50)
        ));

        assertThat(matchMap)
            .containsExactly(
                entry(
                    of(12.5, 7.5),
                    Optional.of(
                        new Rectangle(
                            of(5.0, 5.0),
                            of(5.0, 10.0),
                            of(20.0, 10.0),
                            of(20.0, 5.0)
                        )
                    )
                ),
                entry(
                    of(30.0, 50),
                    Optional.empty()
                )
            );
    }

}