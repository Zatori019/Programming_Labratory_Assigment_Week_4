import java.util.ArrayList;

public class Course {
    public String courseName;
    public int capacity;

    ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
    }

    public void displayInfo() {
        System.out.println("Course name: " + courseName);
        System.out.println("Course capacity: " + capacity);
        System.out.println("Current number of enrolled students: " + enrolledStudents.size());
        if (enrolledStudents.size() > 0) System.out.println("Enrolled students in this course: ");;
        for (Student student : enrolledStudents) {
            System.out.println("                   Student ID: " + student.studentID);
            System.out.println("                   Student name: " + student.name);
            System.out.println("-------------------------------------------------");
        }
    }
}
