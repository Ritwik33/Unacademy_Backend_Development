package com.ritwik.movieBookingSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * name of the test class -> <ClassName>Test
 */

public class CalculatorTest {

    /**
     * test add
     *
     * test<MethodName>
     */

    @Test
    public void testAdd() {

        /**
         * expected result ...
         * 2 + 3 = 5
         */

        int expectedResult = 5;

        /**
         * actual result
         */

        int actualResult = new Calculator().add(2, 3);

        /**
         * if actual is matching with expected
         *
         * yes -> pass
         * no -> fail
         */

        Assertions.assertEquals(expectedResult, actualResult);
    }

    /**
     * test sub
     */

    @Test
    public void testSub() {
        int expectedResult = 5;
        int actualResult = new Calculator().sub(10, 5);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    /**
     * test mult
     */

    @Test
    public void testMult() {
        int expectedResult = 500;
        int actualResult = new Calculator().mult(10, 50);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    /**
     * test div
     */

    @Test
    public void testDiv() {
        double expectedResult = 5;
        double actualResult = new Calculator().div(100, 20);
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
