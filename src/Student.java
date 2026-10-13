public class Student {
    public String studentID;
    public String name;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Student name: " + name);
    }
}
