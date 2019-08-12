package com.andrsam.minijunit.library;

import com.andrsam.minijunit.annotations.Test;
import com.andrsam.minijunit.library.result.ClassTestResult;
import com.andrsam.minijunit.library.result.MethodTestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс библиотеки-обработчика тестовых аннотаций.
 */
public class MiniJUnit {
    private static final Logger LOG = LoggerFactory.getLogger(MiniJUnit.class);

    /**
     * Выполняет запуск методов класса, помеченных аннотацией @Test.
     *
     * @param object - экземляр класса, содержащий тестируемые методы
     * @return информация о результатах выполнния методов
     */
    public ClassTestResult processClass(Object object) {
        Class<?> clazz = object.getClass();
        List<MethodTestResult> methodTestResults = new ArrayList<>();
        int successCount = 0,
                failureCount = 0;
        for (Method method : clazz.getDeclaredMethods()) {
            if (isMethodReadyForTest(method)) {
                MethodTestResult methodTestResult = invokeMethod(object, method);
                if (methodTestResult.isSuccess()) {
                    successCount++;
                } else {
                    failureCount++;
                }
                methodTestResults.add(methodTestResult);
            }
        }

        ClassTestResult result = new ClassTestResult(clazz.getName(), methodTestResults, successCount, failureCount);
        return result;
    }

    /**
     * Проверяет, содержит ли метод аннотацию @Test, является public void  и его аргументы пусты.
     *
     * @param method - метод, который нреобходимо протестировать
     * @return true, если метод содержит аннотацию @Test, является public void и его аргументы пусты
     */
    private boolean isMethodReadyForTest(Method method) {
        return Modifier.isPublic(method.getModifiers())
                && method.isAnnotationPresent(Test.class)
                && method.getReturnType().equals(Void.TYPE)
                && method.getParameterCount() == 0;
    }

    /**
     * Выполняет метод и формирует информацию о результате выполнения.
     *
     * @param object - экземпляр класса-теста
     * @param method - метод
     * @return результат выполнения
     */
    private MethodTestResult invokeMethod(Object object, Method method) {
        MethodTestResult methodTestResult = new MethodTestResult();
        methodTestResult.setMethodName(method.getName());
        methodTestResult.setSuccess(true);

        try {
            method.invoke(object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            methodTestResult.setSuccess(false);
            methodTestResult.setErrorMessage(e.getCause().getMessage());
        }
        return methodTestResult;
    }

    /**
     * Выводит на экран отчет о результатх выполнения тестов.
     *
     * @param result - результат выполнения тестов
     */
    public void printResults(ClassTestResult result) {
        if (result.isClassNotContainsSuitableMethods()) {
            LOG.info("====Class {} does not contains public void methods with test annotations and empty parameter list====", result.getClassName());
            return;
        }

        LOG.info("====class: {}====", result.getClassName());
        LOG.info("--------------------------------");
        result.getMethodTestResults().forEach(System.out::println);
        LOG.info("--------------------------------");
        LOG.info("success: {}, failed: {}, , total: {}", result.getSuccessCount(), result.getFailedCount(), result.getTotalCount());
    }
}
