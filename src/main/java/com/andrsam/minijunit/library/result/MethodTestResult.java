package com.andrsam.minijunit.library.result;

import java.util.Objects;

/**
 * Содержит информацию о результатах тестирования метода.
 */
public class MethodTestResult {
    /**
     * Наименование тестируемого метода.
     */
    private String methodName;

    /**
     * Признак успешного выполнения тестового метода.
     */
    private boolean success;

    /**
     * Сообщение об ошибке.
     */
    private String errorMessage;

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodTestResult that = (MethodTestResult) o;
        return success == that.success &&
                methodName.equals(that.methodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodName, success);
    }

    @Override
    public String toString() {
        return "method name: '" + methodName + '\'' +
                ", success: " + success +
                (success ? "" : ", error message: '" + errorMessage + '\'');
    }
}
