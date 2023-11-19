import java.util.LinkedList;
import java.util.Scanner;

class Student {
    String name;
    boolean present;

    public Student(String name) {
        this.name = name;
        this.present = false;
    }

    public String getName() {
        return name;
    }

    public boolean isPresent() {
        return present;
    }

    public void markAttendance() {
        present = true;
    }

    public void resetAttendance() {
        present = false;
    }
}

class AttendanceTracker {
    private LinkedList<Student> students;

    public AttendanceTracker() {
        students = new LinkedList<>();
    }

    public void addStudent(String name) {
        Student student = new Student(name);
        students.add(student);
    }

    public void markAttendance(String studentName) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                student.markAttendance();
                System.out.println(studentName + " is marked present.");
                return;
            }
        }
        System.out.println("Student not found: " + studentName);
    }

    public void checkAttendance(String studentName) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                if (student.isPresent()) {
                    System.out.println(studentName + " is present.");
                } else {
                    System.out.println(studentName + " is absent.");
                }
                return;
            }
        }
        System.out.println("Student not found: " + studentName);
    }

    public void printAttendance() {
        System.out.println("Attendance List:");
        for (Student student : students) {
            System.out.println(student.getName() + ": " + (student.isPresent() ? "Present" : "Absent"));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceTracker tracker = new AttendanceTracker();
        tracker.addStudent("Aditya Sharma");
        tracker.addStudent("Anushka Singh");
        tracker.addStudent("Diya Girish");

        while (true) {
            System.out.println("\nAttendance Tracker:");
            System.out.println("1. Mark Attendance");
            System.out.println("2. Check Attendance");
            System.out.println("3. Print Attendance List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to mark attendance: ");
                    String markName = scanner.nextLine();
                    tracker.markAttendance(markName);
                    break;
                case 2:
                    System.out.print("Enter student name to check attendance: ");
                    String checkName = scanner.nextLine();
                    tracker.checkAttendance(checkName);
                    break;
                case 3:
                    tracker.printAttendance();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Please enter a valid choice.");
            }
        }
    }
}


