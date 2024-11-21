package unit.time;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ZhangHongbin on 2017/3/9.
 */
public class TestJunit {

    String message = "LandLeaf";

    MessageUtil messageUtil = new MessageUtil(message);

    @Test(timeout = 1000)
    public void testPrintMessage() {
        System.out.println("inside printMessage");
        messageUtil.printMessage();
    }

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "LandLeaf";
        assertEquals(message, messageUtil.salutationMessage());
    }

}
