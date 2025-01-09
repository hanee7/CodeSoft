package StudentCourceReg;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    int enrolled;

    public Course(String courseCode, String title, String description, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0; 
    }

    public boolean isFull() {
        return enrolled >= capacity;
    }

    public void enroll() {
        if (!isFull()) {
            enrolled++;
        }
    }

    public void drop() {
        if (enrolled > 0) {
            enrolled--;
        }
    }

    @Override
    public String toString() {
        return courseCode + ": " + title + " - " + description + " | Capacity: " + capacity + " | Enrolled: " + enrolled;
    }
}

class Student {
    String studentID;
    String name;
    List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.isFull()) {
            System.out.println("Sorry, the course is full.");
        } else {
            course.enroll();
            registeredCourses.add(course);
            System.out.println("Successfully registered for " + course.title);
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.drop();
            registeredCourses.remove(course);
            System.out.println("Successfully dropped the course " + course.title);
        } else {
            System.out.println("You are not registered for this course.");
        }
    }

    public void viewRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Registered Courses for " + name + ":");
            for (Course course : registeredCourses) {
                System.out.println(course);
            }
        }
    }
}

class CourseDatabase {
    List<Course> courses;

    public CourseDatabase() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public Course getCourseByCode(String code) {
        for (Course course : courses) {
            if (course.courseCode.equals(code)) {
                return course;
            }
        }
        return null;
    }
}

class StudentDatabase {
    List<Student> students;

    public StudentDatabase() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentByID(String studentID) {
        for (Student student : students) {
            if (student.studentID.equals(studentID)) {
                return student;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseDatabase courseDatabase = new CourseDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();

        courseDatabase.addCourse(new Course("CS", "Introduction to Computer Science", "Learn the basics of Computer Science.", 3));
        courseDatabase.addCourse(new Course("MATH", "Calculularions", "Learn the fundamentals of Calculus.", 2));
        courseDatabase.addCourse(new Course("PHY", "Physics ", "Learn the basics of Physics.", 4));

        studentDatabase.addStudent(new Student("2003", "haneef"));
        studentDatabase.addStudent(new Student("2001", "nani"));

        boolean exit = false;
        while (!exit) {
            System.out.println("\n-- Main Menu --");
            System.out.println("1. Display Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    courseDatabase.displayCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    Student student = studentDatabase.getStudentByID(studentID);
                    if (student != null) {
                        System.out.print("Enter Course Code to Register: ");
                        String courseCode = scanner.nextLine();
                        Course course = courseDatabase.getCourseByCode(courseCode);
                        if (course != null) {
                            student.registerCourse(course);
                        } else {
                            System.out.println("Invalid course code.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    student = studentDatabase.getStudentByID(studentID);
                    if (student != null) {
                        System.out.print("Enter Course Code to Drop: ");
                        String courseCode = scanner.nextLine();
                        Course course = courseDatabase.getCourseByCode(courseCode);
                        if (course != null) {
                            student.dropCourse(course);
                        } else {
                            System.out.println("Invalid course code.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    student = studentDatabase.getStudentByID(studentID);
                    if (student != null) {
                        student.viewRegisteredCourses();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thanks For Visting!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again later.");
                    break;
            }
        }
    }
}
