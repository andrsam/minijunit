package com.andrsam.minijunit.testclasses;

import com.andrsam.minijunit.annotations.Test;

/**
 * An example of a test class.
 */
public class TestClass {

    @Test
    public void testOutput1() {
        System.out.println("Hello from test - 1!");
    }

    @Test
    public void testCheckedException() throws Exception {
        throw new Exception("test checked exception");
    }

    @Test
    public void testUncheckedException() {
        throw new RuntimeException("test unchecked exception");
    }

    @Test
    public void testOutput2() {
        System.out.println("Hello from test - 2!");
    }

    @Test
    public void testSomeMethod() {
        someMethod();
    }

    public void someMethod() {

    }

}
