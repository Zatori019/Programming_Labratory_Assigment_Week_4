import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();

        System.out.println("How many courses do you want to add? (at least 3) ");
        int numberOfCourses = scanner.nextInt();
        System.out.println("-------------------------------------------------");
        scanner.nextLine();
        for (int i = 0; i < numberOfCourses; i++) {
            int count = i + 1;
            System.out.println("Enter " + count + ". course name: ");
            String tempName = scanner.nextLine();
            System.out.println("Enter " + count + ". course capacity: ");
            int tempCapacity = scanner.nextInt();
            Course course = new Course(tempName, tempCapacity);
            courses.add(course);
            scanner.nextLine();
        }

        System.out.println("=================ALL COURSES==================");
        for (Course course : courses) {
            course.displayInfo();
            System.out.println("-------------------------------------------------");
        }

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("MENU\n" + "1. Register a student\n" + "2. Display all course info\n" + "3. Exit the program\n");
            System.out.println("Please enter an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 :
                    System.out.println("Please enter a student name: ");
                    String tempName = scanner.nextLine();
                    System.out.println("Please enter a student ID: ");
                    String tempID = scanner.nextLine();
                    System.out.println("Please enter the course name you want to register for: ");
                    String tempCourseName = scanner.nextLine();
                    Course foundCourse = null;
                    for (Course course : courses) {
                        if (tempCourseName.equals(course.courseName)) foundCourse = course;
                    }
                    if (foundCourse != null) {
                        boolean alreadyRegistered = false;
                        for (Student student : foundCourse.enrolledStudents) {
                            if (tempID.equals(student.studentID)) {
                                alreadyRegistered = true;
                            }
                        }
                        if (foundCourse.capacity > foundCourse.enrolledStudents.size()){
                            if (!alreadyRegistered) {
                                Student student = new Student(tempID, tempName);
                                foundCourse.enrolledStudents.add(student);
                                System.out.println("Registiration is successful!");
                            } else {
                                System.out.println("A student with this ID is already registired to this course, Registiration Falied!");
                                System.out.println("-------------------------------------------------");
                            }
                        } else {
                            System.out.println("Course capacity is full, Registiration Falied!");
                            System.out.println("-------------------------------------------------");
                        }
                    } else {
                        System.out.println("No course found with that name, Registiration Faliled!");
                        System.out.println("-------------------------------------------------");
                    }break;
                case 2 :
                    System.out.println("=================ALL COURSE INFO==================");
                    for (Course course : courses) {
                        course.displayInfo();
                        System.out.println("=================================================");
                    }break;
                case 3 : isRunning = false;break;
                default:
                    System.out.println("Please enter a valid option! (1-3)");
            }
        }
    }
}