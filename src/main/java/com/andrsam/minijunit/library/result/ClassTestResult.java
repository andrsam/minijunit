package com.andrsam.minijunit.library.result;

import java.util.List;
import java.util.Objects;

/**
 * Содержит информацию о результатах тестирования класса.
 */
public class ClassTestResult {
    /**
     * Наименование тестируемого класса.
     */
    private String className;

    /**
     * Информация о результатах тестирования методов.
     */
    private List<MethodTestResult> methodTestResults;

    /**
     * Количество успешных попыток запуска тестов.
     */
    private int successCount;

    /**
     * Количество неудачных попыток запуска тестов.
     */
    private int failedCount;

    public ClassTestResult(String className, List<MethodTestResult> methodTestResults, int successCount, int failedCount) {
        this.className = className;
        this.methodTestResults = methodTestResults;
        this.successCount = successCount;
        this.failedCount = failedCount;
    }

    public String getClassName() {
        return className;
    }

    public List<MethodTestResult> getMethodTestResults() {
        return methodTestResults;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public int getTotalCount() {
        return methodTestResults.size();
    }

    /**
     * Определяет, содержит ли класс аннотации @Test
     *
     * @return true, если список результатов пустой
     */
    public boolean isClassNotContainsSuitableMethods() {
        return methodTestResults.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassTestResult that = (ClassTestResult) o;
        return successCount == that.successCount &&
                failedCount == that.failedCount &&
                className.equals(that.className) &&
                methodTestResults.equals(that.methodTestResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, methodTestResults, successCount, failedCount);
    }
}
