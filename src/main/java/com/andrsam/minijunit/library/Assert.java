package com.andrsam.minijunit.library;

/**
 * Содержит методы проверки истинности условий
 */
public class Assert {

    /**
     * Проверяет на равенство два значения типа long,
     * в случае несовпадения генерируется AssertionError
     *
     * @param expected ожидаемое значение
     * @param actual   фактическое значение
     */
    public static void assertEquals(long expected, long actual) {
        if (expected != actual) {
            fail(formatMessage(expected, actual));
        }
    }

    /**
     * Выбрасывает AssertionError
     *
     * @param message - сообщение об ошибке
     */
    private static void fail(String message) {
        if (message == null) {
            throw new AssertionError();
        } else {
            throw new AssertionError(message);
        }
    }

    /**
     * Форматирует сообщение об ошибке
     *
     * @param expected ожидаемое значение
     * @param actual   фактическое значение
     * @return отформатированное сообщение об ошибке
     */
    private static String formatMessage(Object expected, Object actual) {
        String expectedString = String.valueOf(expected);
        String actualString = String.valueOf(actual);
        return String.format("expected: <%s> but was: <%s>", expectedString, actualString);
    }
}
