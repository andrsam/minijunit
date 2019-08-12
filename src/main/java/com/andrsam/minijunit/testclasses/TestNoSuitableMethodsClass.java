package com.andrsam.minijunit.testclasses;

import com.andrsam.minijunit.annotations.Test;

/**
 * An example of a test class.
 */
public class TestNoSuitableMethodsClass {
    @Test
    public String testOutput2(int x) {
        return "wrong method";
    }
}
