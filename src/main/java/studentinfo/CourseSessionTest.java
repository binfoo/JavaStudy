package studentinfo;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static junit.framework.Assert.assertEquals;

public class CourseSessionTest extends TestCase {
    private CourseSession session;
    private Date startDate;

    public void setUp() {
        startDate = createDate(2003, 1, 6);
        session = new CourseSession("ENGL", "101", startDate);
    }

    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
    }

    public void testEnrollStudents() {
        Student student1 = new Student("Li Lei");
        session.enroll(student1);
        assertEquals(1, session.getNumberOfStudents());
        assertEquals(student1, session.get(0));

        Student student2 = new Student("Han Meimei");
        session.enroll(student2);
        assertEquals(2, session.getNumberOfStudents());

        assertEquals(student2, session.get(1));

    }

    public void testCourseDates() {


        CourseSession session = new CourseSession("ABCD", "200", startDate);
        Date sixteenWeekOut = createDate(2003, 4, 25);
        assertEquals(sixteenWeekOut, session.getEndDate());
    }

    public Date createDate(int year, int month, int day) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

}
