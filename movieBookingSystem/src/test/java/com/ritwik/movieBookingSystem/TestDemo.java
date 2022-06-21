package com.ritwik.movieBookingSystem;

import org.junit.jupiter.api.*;

/**
 * this class will be used to demo the unit testing and Junit framework functionality ...
 *
 * @Test
 * @BeforeEach
 * @AfterEach
 * @BeforeAll
 * @AfterAll
 */


public class TestDemo {

    /**
     * whenever we use @Test with any method, it becomes executable and test method ...
     */

    @Test
    public void myFirstTest() {
        System.out.println("inside the first test ... ");
    }

    @Test
    public void mySecondTest() {
        System.out.println("inside the second test ... ");
    }

    /**
     * before running any test, we do some preparation ...
     */

    @BeforeEach
    public void beforeEachTestMethod() {
        System.out.println("before each test ... ");
    }

    /**
     * I want to execute something after every test is executed ...
     */

    @AfterEach
    public void afterEachTestMethod() {
        System.out.println("after each test method ... ");
    }

    @BeforeAll
    public static void atTheVeryBeginning() {
        System.out.println("at the very beginning ... ");
    }

    @AfterAll
    public static void atTheVeryEnd() {
        System.out.println("at the very end ... ");
    }
}
