package studentinfo;

public class StudentTest extends junit.framework.TestCase {
    private final String firstStudentName = "ZhangHongbin";

    public void testCreate() {
        Student student = new Student(firstStudentName);
        assertEquals(student.getName(), firstStudentName);
    }
}
