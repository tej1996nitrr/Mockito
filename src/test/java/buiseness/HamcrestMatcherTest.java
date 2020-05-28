package buiseness;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;

public class HamcrestMatcherTest {

    @Test
    public void testMatchers()
    {
        List<Integer> scores = Arrays.asList(99,102,104,103);
        assertThat(scores, Matchers.<Integer>hasSize(4));
        assertThat(scores,hasItems(99,102));
        assertThat(scores,everyItem(greaterThan(60)));
        assertThat(scores,everyItem(lessThan(990)));
        Integer[] marks = { 1, 2, 3 };

        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContainingInAnyOrder(2, 3, 1));

    }
}
