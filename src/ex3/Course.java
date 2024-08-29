package edu.iuh.fit.ex3;

public class Course {
    public String id;
    public String title;
    public Integer credit;
    public String department;

    // Constructors
    public Course() {
        this("", "", 0, "");
    }

    public Course(String id, String title, Integer credit, String department) {
        this.setId(id);
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    // Setters and Getters
    /**
     * Sets the ID of the course.
     *
     * @param id the ID of the course, which must be at least 3 characters long and contain only letters or digits.
     * @throws IllegalArgumentException if the ID is less than 3 characters long or contains non-alphanumeric characters.
     */

    public void setId(String id) {
        if (id.trim().length() < 3)
            throw new IllegalArgumentException("ID must have at least 3 characters");

        for (int i = 0; i < id.length(); i++) {
            char ch = id.charAt(i);
            if (!Character.isLetterOrDigit(ch))
                throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }
    /**
     * Sets the title of the course.
     *
     * @param title the title of the course.
     * @throws IllegalArgumentException if the title is null.
     */

    public void setTitle(String title) {
        if(title == null)
            throw new IllegalArgumentException("Title must not be empty");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    /**
     * Sets the credit value of the course.
     *
     * @param credit the credit value of the course, which must be non-negative.
     * @throws IllegalArgumentException if the credit value is less than 0.
     */

    public void setCredit(Integer credit) {
        if(credit < 0)
            throw new IllegalArgumentException("Credit must be greater than 0");
        this.credit = credit;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-25s%10d  %-10s", id, title, credit, department);
    }
}
