package unit;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Created by ZhangHongbin on 2017/3/9.
 */
public class JunitTestSuite2 {

    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite(TestJunit1.class,TestJunit2.class,TestJunit3.class);

        TestResult result = new TestResult();
        testSuite.run(result);

        System.out.println("Number of test cases = " + result.runCount());
    }
}
