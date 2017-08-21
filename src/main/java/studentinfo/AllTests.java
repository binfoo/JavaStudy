package studentinfo;

import junit.framework.TestSuite;

public class AllTests {

    public static TestSuite suite(){
        TestSuite suite = new junit.framework.TestSuite();
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(CourseSessionTest.class);
        return suite;
    }
}

