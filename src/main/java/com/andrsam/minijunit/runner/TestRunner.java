package com.andrsam.minijunit.runner;

import com.andrsam.minijunit.library.MiniJUnit;

/**
 * Содержит методы запуска тестов.
 */
public class TestRunner {

    /**
     * Выполняет запуск тестов
     *
     * @param object - экземпляр класса-теста
     */
    public static void runTests(Object object) {
        MiniJUnit miniJUnit = new MiniJUnit();
        miniJUnit.printResults(miniJUnit.processClass(object));
    }
}
