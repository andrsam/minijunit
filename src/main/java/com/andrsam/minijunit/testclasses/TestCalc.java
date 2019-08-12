package com.andrsam.minijunit.testclasses;

import com.andrsam.minijunit.annotations.Test;
import com.andrsam.minijunit.library.Assert;

public class TestCalc {
    @Test
    public void whenAdd1And1() {
        Calc calc = new Calc();
        int result = calc.add(1, 1);
        Assert.assertEquals(2, result);
    }

    @Test
    public void whenAdd1And1Wrong() {
        Calc calc = new Calc();
        int result = calc.add(1, 1);
        Assert.assertEquals(3, result);
    }


}
