package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a course, extending the Report template.
 * Provides course-specific implementations of each report step.
 */
public class CourseReport extends Report {

    /** The name of the course. */
    private String courseName;

    /** The number of enrolled students. */
    private int enrollment;

    /**
     * Loads course data into the report fields.
     */
    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    /**
     * Prints the course report header.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Course Report");
    }

    /**
     * Prints the course report body with course name and enrollment.
     */
    @Override
    protected void formatBody() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrollment: " + enrollment);
    }

    /**
     * Prints the course report footer.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Course Report");
    }
}
