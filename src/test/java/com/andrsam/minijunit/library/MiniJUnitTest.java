package com.andrsam.minijunit.library;

import com.andrsam.minijunit.library.result.ClassTestResult;
import com.andrsam.minijunit.testclasses.TestCalc;
import com.andrsam.minijunit.testclasses.TestClass;
import com.andrsam.minijunit.testclasses.TestNoSuitableMethodsClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiniJUnitTest {

    @Test
    public void processClass() {
        MiniJUnit miniJUnit = new MiniJUnit();

        ClassTestResult result1 = miniJUnit.processClass(new TestNoSuitableMethodsClass());
        assertEquals("com.andrsam.minijunit.testclasses.TestNoSuitableMethodsClass", result1.getClassName());
        assertTrue(result1.isClassNotContainsSuitableMethods());
        assertEquals(0, result1.getTotalCount());

        ClassTestResult result2 = miniJUnit.processClass(new TestCalc());
        assertEquals("com.andrsam.minijunit.testclasses.TestCalc", result2.getClassName());
        assertFalse(result2.isClassNotContainsSuitableMethods());
        assertEquals(2, result2.getTotalCount());
        assertEquals(1, result2.getSuccessCount());
        assertEquals(1, result2.getFailedCount());

        ClassTestResult result3 = miniJUnit.processClass(new TestClass());
        assertEquals("com.andrsam.minijunit.testclasses.TestClass", result3.getClassName());
        assertFalse(result3.isClassNotContainsSuitableMethods());
        assertEquals(5, result3.getTotalCount());
        assertEquals(3, result3.getSuccessCount());
        assertEquals(2, result3.getFailedCount());
    }
}