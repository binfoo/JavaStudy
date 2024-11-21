package unit;

import junit.framework.TestCase;

/**
 * Created by ZhangHongbin on 2017/3/9.
 */
public class JavaTest extends TestCase {

    protected int value1, value2;

    protected void setUp() {
        value1 = 3;
        value2 = 3;
    }

    public void testAdd() {
        double result = value1 + value2;

        assertTrue(result == 6);
    }
}
