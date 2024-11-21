package unit;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestResult;

/**
 * Created by ZhangHongbin on 2017/3/9.
 */
public class TestJunit3 extends TestResult{

    public synchronized void addError(Test test, Throwable t){

        super.addError(test,t);

    }

    // add the failure
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        super.addFailure((Test) test, t);
    }

    @org.junit.Test
    public void testAdd() {
        // add any test
    }

    // Marks that the test run should stop.
    public synchronized void stop() {
        //stop the test here
    }
}
