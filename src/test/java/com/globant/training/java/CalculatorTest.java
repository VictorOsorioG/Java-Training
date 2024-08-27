package com.globant.training.java;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class CalculatorTest {

    Calculator calculator;
    private List<String> list;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        list = Arrays.asList("JUnit 5", "Mockito");
        System.out.println("Before");
    }

    @AfterEach
    void end() {
        calculator = null;
        list = null;
        System.out.println("After");
    }

    @Test
    @DisplayName("Multiply")
    @Disabled("Because")
    void multiply() {
        assertEquals(20, calculator.multiply(4,5), "should work");
    }

    @RepeatedTest(5)
    @DisplayName("Multiply by 0")
    void multiplyBy0() {
        assertEquals(0, calculator.multiply(0,5), "should be 0");
    }

    @Test
    void exceptionTest() {
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("a"));
    }

    @Test
    void groupedAssertions() {
        assertAll("multiply two sides",
                ()-> assertEquals(20, calculator.multiply(4,5)),
                () -> assertEquals(20, calculator.multiply(5,4))
        );
    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMinutes(1), () -> calculator.multiply(4,5));
    }

    @Test
    void timeoutNotExceededWithResult() {
        int result = assertTimeout(Duration.ofMinutes(1), () -> calculator.multiply(4,5));
        assertEquals(20, result);
    }

    @Test
    void timeoutEndTest() {
        assertTimeoutPreemptively(Duration.ofMinutes(1), () -> calculator.multiply(4,5));
    }

    @Test
    void parameterizedTest() {
        int[][] data = new int[][] { { 1, 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
    }

    @TestFactory
    @DisplayName("Cant use before and after each, supuestamente")
    Stream<DynamicTest> testDifferentMultiplyOperations() {
        int[][] data = new int[][] { { 1, 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
        return Arrays.stream(data).map(entry -> {
            int m1 = entry[0];
            int m2 = entry[1];
            int expected = entry[2];
            return dynamicTest(m1 + " * " + m2 + " = " + expected, () -> {
                assertEquals(expected, calculator.multiply(m1, m2));
            });
        });
    }

    public static int[][] data() {
        return new int[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
    }

    @ParameterizedTest
    @MethodSource(value =  "data")
    void testWithStringParameter(int[] data) {
        int m1 = data[0];
        int m2 = data[1];
        int expected = data[2];
        assertEquals(expected, calculator.multiply(m1, m2));
    }

    @DisplayName("Grouped tests for checking members")
    @Nested
    class CheckMembers {
        @Test
        void checkFirstElement() {
            assertEquals(("JUnit 5"), list.get(0));
        }
        @Test
        void checkSecondElement() {
            assertEquals(("Mockito"), list.get(1));
        }
    }

}