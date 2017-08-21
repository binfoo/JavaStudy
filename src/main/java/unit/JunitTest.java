package unit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ZhangHongbin on 2017/3/9.
 */
public class JunitTest {

    @Test
    public void testAdd(){
        String str = "这是个junit!";
        assertEquals("这是个new!",str);
    }
}
