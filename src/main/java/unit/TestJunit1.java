package unit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TestJunit1 {

    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

//    @Test
//    public void testPrintMessage() {
//        System.out.println("Inside testPrintMessage()");
//        assertEquals(message, messageUtil.printMessage());
//    }

    @Test
    public void testAdd(){

        int num = 5;
        String temp = null;
        String str = "张山是男的！";

        assertEquals("张山是男的！",str);

        assertFalse(num < 6);

        assertNotNull(str);

    }
}