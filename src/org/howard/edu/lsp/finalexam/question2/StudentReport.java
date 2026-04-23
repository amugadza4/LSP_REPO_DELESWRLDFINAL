package org.howard.edu.lsp.finalexam.question2;

/**
 * Concrete report for a student, extending the Report template.
 * Provides student-specific implementations of each report step.
 */
public class StudentReport extends Report {

    /** The name of the student. */
    private String studentName;

    /** The GPA of the student. */
    private double gpa;

    /**
     * Loads student data into the report fields.
     */
    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    /**
     * Prints the student report header.
     */
    @Override
    protected void formatHeader() {
        System.out.println("Student Report");
    }

    /**
     * Prints the student report body with name and GPA.
     */
    @Override
    protected void formatBody() {
        System.out.println("Student Name: " + studentName);
        System.out.println("GPA: " + gpa);
    }

    /**
     * Prints the student report footer.
     */
    @Override
    protected void formatFooter() {
        System.out.println("End of Student Report");
    }
}
