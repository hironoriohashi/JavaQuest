import static org.junit.Assert.*;

import org.junit.Test;

public class NumberUtilsTest {

    @Test
    public void isEvenに10を渡すとtrueを返す() {
        assertTrue(NumberUtils.isEven(10));
    }

    @Test
    public void isEvenに7を渡すとfalseを返す() {
        assertFalse(NumberUtils.isEven(7));
    }
}
