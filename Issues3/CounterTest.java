import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CounterTest {
    Counter counter;

    @Before
    public void setup() {
        counter = new Counter();
    }

    @Test
    public void incrementメソッドを1回実行すると1を得られること() {
        assertThat(counter.increment(), is(1));
    }

    @Test
    public void incrementメソッドを1回実行した状態で実行すると2を得られること() {
        counter.increment();
        assertThat(counter.increment(), is(2));
    }

    @Test
    public void incrementを50回実行した状態で実行すると51が得られること() {
        for (int i = 0; i < 50; i++) {
            counter.increment();
        }
        assertThat(counter.increment(), is(51));
    }
}
