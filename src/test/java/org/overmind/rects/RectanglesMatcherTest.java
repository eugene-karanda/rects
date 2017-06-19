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
    public void matchTest1() throws Exception {
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

    @Test
    public void matchTest2() throws Exception {
        RectanglesMatcher rectanglesMatcher = new RectanglesMatcher(
            ZoneBuilder.builder()
                .add(new Rectangle(
                    of(0.0, 0.0),
                    of(0.0, 5.0),
                    of(5.0, 5.0),
                    of(5.0, 0.0)
                ))
                .add(new Rectangle(
                    of(-10.0, 0.0),
                    of(-10.0, 5.0),
                    of(-5.0, 5.0),
                    of(-5.0, 0.0)
                ))
                .build()
        );
        Map<Point, Optional<Rectangle>> matchMap = rectanglesMatcher.matchAll(Arrays.asList(
            of(5, 2.5),
            of(-7.0, 2.0),
            of(0, 10.0)
        ));

        assertThat(matchMap)
            .containsOnly(
                entry(
                    of(5, 2.5),
                    Optional.of(
                        new Rectangle(
                            of(0.0, 0.0),
                            of(0.0, 5.0),
                            of(5.0, 5.0),
                            of(5.0, 0.0)
                        )
                    )
                ),
                entry(
                    of(-7.0, 2.0),
                    Optional.of(
                        new Rectangle(
                            of(-10.0, 0.0),
                            of(-10.0, 5.0),
                            of(-5.0, 5.0),
                            of(-5.0, 0.0)
                        )
                    )
                ),
                entry(
                    of(0, 10.0),
                    Optional.empty()
                )
            );
    }
}