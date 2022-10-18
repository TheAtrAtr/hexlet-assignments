package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int actual1 = App.take(numbers1, 5).size();
        int actual2 = App.take(numbers1, 3).size();
        assertThat(actual1).isEqualTo(4);
        assertThat(actual2).isEqualTo(3);
        // END
    }
}
