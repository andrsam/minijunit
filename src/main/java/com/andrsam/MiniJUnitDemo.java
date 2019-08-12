package com.andrsam;

import com.andrsam.minijunit.runner.TestRunner;
import com.andrsam.minijunit.testclasses.TestCalc;
import com.andrsam.minijunit.testclasses.TestClass;
import com.andrsam.minijunit.testclasses.TestNoSuitableMethodsClass;

/**
 * Демонстрационный класс.
 */
public class MiniJUnitDemo {
    public static void main(String[] args) {
        TestRunner.runTests(new TestNoSuitableMethodsClass());
        TestRunner.runTests(new TestClass());
        TestRunner.runTests(new TestCalc());
    }
}
