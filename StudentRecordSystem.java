import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String rollNumber;
    private String name;
    private String className;
    private Map<String, Double> marks;

    public Student(String rollNumber, String name, String className) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.className = className;
        this.marks = new HashMap<>();
    }

    public void addMarks(String subject, double mark) {
        this.marks.put(subject, mark);
    }

    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Class: " + className);
        System.out.println("Marks:");
        for (Map.Entry<String, Double> entry : marks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class StudentRecordSystem {
    private Map<String, Student> students;
    private Scanner scanner;

    public StudentRecordSystem() {
        this.students = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter class: ");
        String className = scanner.nextLine();

        students.put(rollNumber, new Student(rollNumber, name, className));
        System.out.println("Student added successfully!");
    }

    public void displayStudentDetails() {
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();

        if (students.containsKey(rollNumber)) {
            students.get(rollNumber).displayDetails();
        } else {
            System.out.println("Student not found!");
        }
    }

    public void addMarks() {
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();
        System.out.print("Enter mark: ");
        double mark = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        if (students.containsKey(rollNumber)) {
            students.get(rollNumber).addMarks(subject, mark);
            System.out.println("Marks added successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public void run() {
        while (true) {
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student Details");
            System.out.println("3. Add Marks");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudentDetails();
                    break;
                case 3:
                    addMarks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentRecordSystem system = new StudentRecordSystem();
        system.run();
    }
}