package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test class for GradeCalculator.
 */
public class GradeCalculatorTest {

    private GradeCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new GradeCalculator();
    }

    // ---------------------------------------------------------------
    // Test for average()
    // ---------------------------------------------------------------

    @Test
    @DisplayName("Test average() returns correct result for typical 
scores")
    public void testAverageTypicalScores() {
        double result = calculator.average(80, 90, 70);
        assertEquals(80.0, result, 0.001);
    }

    // ---------------------------------------------------------------
    // Test for letterGrade()
    // ---------------------------------------------------------------

    @Test
    @DisplayName("Test letterGrade() returns B for average of 85")
    public void testLetterGradeB() {
        String grade = calculator.letterGrade(85.0);
        assertEquals("B", grade);
    }

    // ---------------------------------------------------------------
    // Test for isPassing()
    // ---------------------------------------------------------------

    @Test
    @DisplayName("Test isPassing() returns true for average of 75")
    public void testIsPassingTrue() {
        assertTrue(calculator.isPassing(75.0));
    }

    // ---------------------------------------------------------------
    // Boundary-value tests
    // ---------------------------------------------------------------

    @Test
    @DisplayName("Boundary: average of exactly 60 should return D and 
isPassing true")
    public void testBoundaryExactly60() {
        double avg = calculator.average(60, 60, 60);
        assertEquals(60.0, avg, 0.001);
        assertEquals("D", calculator.letterGrade(avg));
        assertTrue(calculator.isPassing(avg));
    }

    @Test
    @DisplayName("Boundary: average of exactly 90 should return A")
    public void testBoundaryExactly90() {
        double avg = calculator.average(90, 90, 90);
        assertEquals(90.0, avg, 0.001);
        assertEquals("A", calculator.letterGrade(avg));
    }

    // ---------------------------------------------------------------
    // Exception tests
    // ---------------------------------------------------------------

    @Test
    @DisplayName("Exception: score below 0 should throw 
IllegalArgumentException")
    public void testExceptionScoreBelowZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-1, 50, 50);
        });
    }

    @Test
    @DisplayName("Exception: score above 100 should throw 
IllegalArgumentException")
    public void testExceptionScoreAbove100() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(50, 101, 50);
        });
    }
}
