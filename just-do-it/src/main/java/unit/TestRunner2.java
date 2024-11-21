package unit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by ZhangHongbin on 2017/3/9.
 */
public class TestRunner2 {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestJunit2.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }
}
