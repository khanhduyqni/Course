package edu.iuh.fit.ex3;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CourseList {

    private Course[] courses;
    private int count = 0;

    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n];
    }

    public Course[] getCourses() {
        return Arrays.copyOf(courses, count);  // Return a copy of the array containing only added courses
    }

    public boolean addCourse(Course course) {
        // Check if course is null
        if (course == null)
            throw new IllegalArgumentException("Course cannot be null");
        // Check if course already exists
        if (exists(course))
            throw new IllegalArgumentException("Course with this ID already exists");
        // Check if the array is full
        if (count == courses.length)
            throw new IllegalArgumentException("Course list is full");

        courses[count++] = course;
        return true;
    }

    private boolean exists(Course course) {
        return findCourseById(course.getId()) != null;
    }

    public boolean removeCourse(String courseId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(courseId)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Course with this ID does not exist");
        }

        for (int i = index; i < count - 1; i++) {
            courses[i] = courses[i + 1];
        }
        courses[--count] = null;
        return true;
    }

    public Course findCourseById(String courseId) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(courseId)) {
                return courses[i];
            }
        }
        return null;
    }

    public List<Course> findCoursesByTitle(String title) {
        List<Course> matchingCourses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchingCourses.add(courses[i]);
            }
        }
        return matchingCourses.isEmpty() ? null : matchingCourses;
    }

    public List<Course> findCoursesByDepartment(String department) {
        List<Course> matchingCourses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                matchingCourses.add(courses[i]);
            }
        }
        return matchingCourses.isEmpty() ? null : matchingCourses;
    }

    public List<Course> sortCoursesByTitle() {
        Course[] sortedCourses = Arrays.copyOf(courses, count);
        Arrays.sort(sortedCourses, Comparator.comparing(Course::getTitle));
        return Arrays.asList(sortedCourses);
    }

    public List<Course> findCoursesWithMaxCredits() {
        int maxCredits = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() > maxCredits) {
                maxCredits = courses[i].getCredit();
            }
        }

        List<Course> maxCreditCourses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredits) {
                maxCreditCourses.add(courses[i]);
            }
        }
        return maxCreditCourses;
    }

    public String findDepartmentWithMostCourses() {
        if (count == 0) {
            return null;
        }

        Map<String, Integer> departmentCount = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String department = courses[i].getDepartment();
            departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
        }

        return departmentCount.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .get()
                .getKey();
    }
}
