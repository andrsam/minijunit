package com.andrsam.minijunit.library;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertTest {
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test(expected = AssertionError.class)
    public void assertEquals() {
        exceptionRule.expect(AssertionError.class);
        Assert.assertEquals(1, 2);
        exceptionRule.expectMessage("expected:<1> but was:<2>");
    }
}