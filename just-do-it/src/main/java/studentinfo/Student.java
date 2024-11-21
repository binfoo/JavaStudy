package studentinfo;

public class Student {
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public String getName() {
        return studentName;
    }

    public void setName(String studentName) {
        this.studentName = studentName;
    }
}
