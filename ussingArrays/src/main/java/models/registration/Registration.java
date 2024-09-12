package models.registration;

import java.util.ArrayList;

public class Registration {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public Registration() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addStudent(String name, int age) {
        students.add(new Student(name, age));
    }

    public void showCoursesByStudentName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Courses for " + name + ": " + student.getCourses());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void addCourseToStudent(String studentName, String courseName) {
        Course course = null;
        for (Course c : courses) {
            if (c.getName().equalsIgnoreCase(courseName)) {
                course = c;
                break;
            }
        }
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                student.addCourse(course);
                System.out.println("Course added to the student.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void addCourse(String courseName) {
        courses.add(new Course(courseName));
    }
}

