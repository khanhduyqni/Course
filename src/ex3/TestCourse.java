package edu.iuh.fit.ex3;

import java.util.List;
import java.util.ArrayList;

public class TestCourse {
//    public static void main(String[] args) {
//        CourseList courseList = new CourseList(5);
//
//        try {
//            Course course1 = new Course("CS101", "Introduction to Computer Science", 3, "CS");
//            Course course2 = new Course("CS101", "Data Structures", 4, "CS");
//
//            courseList.addCourse(course1);
//            courseList.addCourse(course2);  // This will throw an exception because the ID "CS101" already exists
//        } catch (IllegalArgumentException e) {
//            System.err.println(e.getMessage());
//        }
//
//        // Print out the courses to verify
//        for (Course course : courseList.getCourses()) {
//            if (course != null) {
//                System.out.println(course);
//            }
//        }
//    }
public static void main(String[] args) {
    // Khởi tạo danh sách khóa học với kích thước 10
    CourseList courseList = new CourseList(10);

    // Tạo các khóa học
    Course course1 = new Course("CS101", "Computer Science", 3, "CS");
    Course course2 = new Course("MTH101", "Calculus I", 4, "Mathematics");
    Course course3 = new Course("PHY101", "Physics I", 4, "Physics");
    Course course4 = new Course("CS102", "Data Structures", 3, "CS");
    Course course5 = new Course("MTH102", "Linear Algebra", 4, "Mathematics");

    // Thêm các khóa học vào danh sách
    try {
        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
    } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
    }

    // In ra tất cả các khóa học
    System.out.println("Danh sách các khóa học:");
    for (Course course : courseList.getCourses()) {
        if (course != null) {
            System.out.println(course);
        }
    }

    // Tìm kiếm khóa học theo ID
    System.out.println("\nTìm khóa học với ID 'CS102':");
    Course foundCourse = courseList.findCourseById("CS102");
    if (foundCourse != null) {
        System.out.println(foundCourse);
    } else {
        System.out.println("Không tìm thấy khóa học.");
    }

    // Tìm kiếm khóa học theo tên
    System.out.println("\nTìm khóa học có chứa tên 'Calculus':");
    List<Course> coursesByTitle = courseList.findCoursesByTitle("Calculus");
    if (coursesByTitle != null) {
        for (Course course : coursesByTitle) {
            System.out.println(course);
        }
    } else {
        System.out.println("Không tìm thấy khóa học.");
    }

    // Tìm kiếm khóa học theo khoa phụ trách
    System.out.println("\nTìm khóa học thuộc khoa 'CS':");
    List<Course> coursesByDepartment = courseList.findCoursesByDepartment("CS");
    if (coursesByDepartment != null) {
        for (Course course : coursesByDepartment) {
            System.out.println(course);
        }
    } else {
        System.out.println("Không tìm thấy khóa học.");
    }

    // Xóa một khóa học theo ID
    System.out.println("\nXóa khóa học với ID 'PHY101':");
    try {
        courseList.removeCourse("PHY101");
        System.out.println("Khóa học đã được xóa.");
    } catch (IllegalArgumentException e) {
        System.err.println(e.getMessage());
    }

    // In lại danh sách sau khi xóa
    System.out.println("\nDanh sách các khóa học sau khi xóa:");
    for (Course course : courseList.getCourses()) {
        if (course != null) {
            System.out.println(course);
        }
    }

    // Sắp xếp khóa học theo tên
    System.out.println("\nDanh sách khóa học sau khi sắp xếp theo tên:");
    List<Course> sortedCourses = courseList.sortCoursesByTitle();
    for (Course course : sortedCourses) {
        System.out.println(course);
    }

    // Tìm khóa học có số tín chỉ lớn nhất
    System.out.println("\nTìm các khóa học có số tín chỉ lớn nhất:");
    List<Course> maxCreditCourses = courseList.findCoursesWithMaxCredits();
    for (Course course : maxCreditCourses) {
        System.out.println(course);
    }

    // Tìm khoa phụ trách có nhiều khóa học nhất
    System.out.println("\nKhoa phụ trách có nhiều khóa học nhất:");
    String departmentWithMostCourses = courseList.findDepartmentWithMostCourses();
    System.out.println(departmentWithMostCourses != null ? departmentWithMostCourses : "Không có khóa học nào.");
}
}
